package emprestimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartoes.CartaoFidelidade;
import itens.Item;
import ordenadores.OrdenadorDeItens;
import usuarios.Usuario;

public class EmprestimoController {
	private ExcecoesEmprestimo excecoesEmprestimo;
	private List<Emprestimo> emprestimosOrdenados;
	private OrdenadorDeItens ordenadorDeItens;
	private Set<Emprestimo> emprestimosSistema;
	
	public EmprestimoController() {
		emprestimosSistema = new HashSet<>();
		excecoesEmprestimo = new ExcecoesEmprestimo();
		ordenadorDeItens = new OrdenadorDeItens();
	}
	
	/**
	 * Registra emprestimos
	 * 
	 * @param nomeDono Nome do dono
	 * @param telefoneDono Telefone do dono
	 * @param nomeRequerente Nome da pessoa que pega emprestado
	 * @param telefoneRequerente Telefone da pessoa que pega emprestado
	 * @param nomeItem Nome do item
	 * @param dataEmprestimo Representa a data do emprestimo
	 * @param periodo Representa o periodo do emprestimo em dias
	 * */
	public void registrarEmprestimo(Usuario dono, Usuario requerente, String nomeItem, String dataEmprestimo, int periodo) {
		dono.getStatusItem(nomeItem);
		Item item = dono.getItem(nomeItem);
		Emprestimo emprestimo = criarEmprestimo(dono, requerente, item, dataEmprestimo, periodo);
		dono.registrarEmprestimo(emprestimo);
		requerente.registrarEmprestimo(emprestimo);
		dono.addReputacaoDez(item.getPreco());
		item.adicionaQuantidadeEmprestimos();
		emprestimosSistema.add(emprestimo);
	}

	/**
	 * Registra devolucoes de itens no sistema
	 * 
	 * @param nomeDono Nome do dono
	 * @param telefoneDono Telefone do dono
	 * @param nomeRequerente Nome da pessoa que pega emprestado
	 * @param telefoneRequerente Telefone da pessoa que pega emprestado
	 * @param nomeItem Nome do item
	 * @param dataEmprestimo Representa a data do emprestimo
	 * @param dataDevolucao Representa a data de devolucao do item
	 * */
	public void devolverItem(Usuario dono, Usuario requerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Emprestimo emprestimoDono = dono.pegaEmprestimo(dono, requerente, dono.getItem(nomeItem), dataEmprestimo);
		excecoesEmprestimo.emprestimoInvalido(emprestimoDono);
		Emprestimo emprestimoRequerente = requerente.pegaEmprestimo(dono, requerente, dono.getItem(nomeItem), dataEmprestimo);
		excecoesEmprestimo.emprestimoInvalido(emprestimoRequerente);
		emprestimoDono.devolucao(dataDevolucao);
		emprestimoRequerente.devolucao(dataDevolucao);		
		double preco = dono.getItem(nomeItem).getPreco();
		int atraso = emprestimoDono.getAtraso();
		punicaoAtraso(requerente, atraso, preco);
	}
	
	public void punicaoAtraso(Usuario requerente, int atraso, double preco) {
		if (atraso <= 0) {
			requerente.addReputacaoCinco(preco);
		}
		else if (atraso > 0) {
			requerente.diminuirReputacao(atraso, preco);			
		}
	}
	
	public void permissaoEmprestimo(Usuario requerente, int periodoRequerido, Item item) {
		CartaoFidelidade cartao = requerente.getCartao();
		excecoesEmprestimo.permitirEmprestimo(cartao.permissaoEmprestimo());
		excecoesEmprestimo.periodoInvalido(cartao.diasMaximoEmprestimo(), periodoRequerido);
	}
	
	public Emprestimo criarEmprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo, int periodo) {
		permissaoEmprestimo(requerente, periodo, item);
		return new Emprestimo(dono, requerente, dataEmprestimo, item, periodo);
	}
	
	public String listarEmprestimosUsuarioEmprestando(Usuario dono) {
		emprestimosOrdenados = new ArrayList<>(dono.getEmprestando());
		if (emprestimosOrdenados.size() > 0) {
			ordenaEmprestimos();
			return "Emprestimos: " + listagemEmprestimos();
		}
		return "Nenhum item emprestado";
	}

	private void ordenaEmprestimos() {
		Collections.sort(emprestimosOrdenados, new OrdemEmprestimoNome());
	}
	
	private String listagemEmprestimos() {
		String saida = "";
		for(Emprestimo emprestimo: this.emprestimosOrdenados) {
			saida += emprestimo.toString() + "|";
		}
		return saida;
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(Usuario requerente) {
		emprestimosOrdenados = new ArrayList<>(requerente.getEmprestado());
		if (emprestimosOrdenados.size() > 0) {
			ordenaEmprestimos();
			return "Emprestimos pegos: " + listagemEmprestimos();			
		}
		return "Nenhum item pego emprestado";
	}
	
	private List<Item> itensNaoEmprestados(List<Item> todosItens) {
		for (int i = todosItens.size() - 1; i > 0 ; i--) {
			if (todosItens.get(i).getStatus() == true) {
				todosItens.remove(i);
			}
		}
		return todosItens;
	}
	
	private List<Emprestimo> itensEmprestados() {
		List<Emprestimo> emprestados = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimosSistema) {
			if (emprestimo.getStatus() == true) {
				emprestados.add(emprestimo);
			}
		}
		return emprestados;
	}
	
	public String listarItensNaoEmprestados(List<Item> todosItens) {
		List<Item> itens = new ArrayList<>(itensNaoEmprestados(todosItens));
		ordenadorDeItens.adicionaItens(itens);
		return ordenadorDeItens.listarItensOrdenadosPorNome();
	}

	public String listarItensEmprestados() {
		emprestimosOrdenados = new ArrayList<>(itensEmprestados());
		ordenaEmprestimos();
		String saida = "";
		for (Emprestimo emprestimo : emprestimosOrdenados) {
			saida += "Dono do item: " + emprestimo.getNomeDono() + ", Nome do item emprestado: " + emprestimo.getNomeItem() + "|";
		}
		return saida;
	}

	public String listarEmprestimosItem(String nomeItem) {
		String saida = "Emprestimos associados ao item: ";
		for (Emprestimo emprestimo : emprestimosSistema) {
			if (emprestimo.getNomeItem().equals(nomeItem)) {
				saida += emprestimo.toString() + "|";
			}
		}
		if (saida.equals("Emprestimos associados ao item: ")) {
			return "Nenhum emprestimos associados ao item";
		}
		return saida;
	}

	public String listarTop10Itens(List<Item> todosItens) {
		ordenadorDeItens.adicionaItens(todosItens);
		return ordenadorDeItens.listarItensOrdenadosPorQuantidadeEmprestimos();
	}
}
