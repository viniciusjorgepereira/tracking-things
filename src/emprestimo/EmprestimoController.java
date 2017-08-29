/**
 * Classe que gerencia emprestimos e suas excecoes
 * */

package emprestimo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartoes.CartaoFidelidade;
import itens.Item;
import ordenadores.OrdenadorDeItens;
import usuarios.Usuario;

public class EmprestimoController implements Serializable{
	private static final long serialVersionUID = 1L;
	private ExcecoesEmprestimo excecoesEmprestimo;
	private List<Emprestimo> emprestimosOrdenados;
	private OrdenadorDeItens ordenadorDeItens;
	private Set<Emprestimo> emprestimosSistema;
	
	/**
	 * Constroi o EmprestimoController. Nele, há
	 * um HashSet dos emprestimos do Sistema, Um
	 * objeto que gerencia as excecoes de emprestimo
	 * e um objeto de Ordenador de Itens;
	 * */
	public EmprestimoController() {
		emprestimosSistema = new HashSet<>();
		excecoesEmprestimo = new ExcecoesEmprestimo();
		ordenadorDeItens = new OrdenadorDeItens();
	}
	
	/**
	 * Registra emprestimos
	 * 
	 * @param dono Usuario dono do item
	 * @param requerente Usuario requerente do item
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
	 * @param dono Usuario dono do item
	 * @param requerente Usuario requerente do item
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
	
	/**
	 * Registra uma punicao por atraso do item na reputacao
	 * do usuario
	 * 
	 * @param requerente Usuario requerente do item
	 * @param atraso Dias de atraso na entrega
	 * @param preco Preco do item emprestado
	 * */
	public void punicaoAtraso(Usuario requerente, int atraso, double preco) {
		if (atraso <= 0) {
			requerente.addReputacaoCinco(preco);
		}
		else if (atraso > 0) {
			requerente.diminuirReputacao(atraso, preco);			
		}
	}
	
	/**
	 * Checka se um emprestimo e permitido
	 * 
	 * @param requerente Usuario requerente do item
	 * @param periodoRequerido Perido que o item e procurado pelo requerente
	 * @param item Item a ser emprestado
	 * */
	public void permissaoEmprestimo(Usuario requerente, int periodoRequerido, Item item) {
		CartaoFidelidade cartao = requerente.getCartao();
		excecoesEmprestimo.permitirEmprestimo(cartao.permissaoEmprestimo());
		excecoesEmprestimo.periodoInvalido(cartao.diasMaximoEmprestimo(), periodoRequerido);
	}
	
	/**
	 * Cria um novo emprestimo
	 * 
	 * @param dono Usuario dono do item
	 * @param requerente Usuario requerente do item
	 * @param item Item a ser emprestado
	 * @param dataEmprestimo Data que o emprestimo ocorreu
	 * @param periodo Periodo em dias que o item pode ficar com o requerente
	 * 
	 * @return Retorna o novo emprestimo criado
	 * */
	public Emprestimo criarEmprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo, int periodo) {
		permissaoEmprestimo(requerente, periodo, item);
		return new Emprestimo(dono, requerente, dataEmprestimo, item, periodo);
	}
	
	/**
	 * Lista emprestimos em que o usuario tem papel de
	 * dono
	 * 
	 * @param dono Usuario dono do item
	 * 
	 * @return String com a informacoes do itens que o usuario emprestou
	 
	 * */
	public String listarEmprestimosUsuarioEmprestando(Usuario dono) {
		emprestimosOrdenados = new ArrayList<>(dono.getEmprestando());
		if (emprestimosOrdenados.size() > 0) {
			ordenaEmprestimos();
			return "Emprestimos: " + listagemEmprestimos();
		}
		return "Nenhum item emprestado";
	}

	/**
	 * Invoca metodo de ordenar emprestimos por nome do item
	 * */
	private void ordenaEmprestimos() {
		Collections.sort(emprestimosOrdenados, new OrdemEmprestimoNome());
	}
	
	/**
	 * Lista emprestimos ordenados
	 * 
	 * @return String com emprestimos ordenados por nome do item envolvido
	 * */
	private String listagemEmprestimos() {
		String saida = "";
		for(Emprestimo emprestimo: this.emprestimosOrdenados) {
			saida += emprestimo.toString() + "|";
		}
		return saida;
	}
	
	/**
	 * Lista emprestimos que o usuario pegou emprestado
	 * ordenados pelo nome do item envolvido
	 * 
	 * @param requerente Usuario quem tem papel de requerente nos emprestimos
	 * 
	 * @return Retorna String com os emprestimos ordenados pelo nome do item envolvido
	 * */
	public String listarEmprestimosUsuarioPegandoEmprestado(Usuario requerente) {
		emprestimosOrdenados = new ArrayList<>(requerente.getEmprestado());
		if (emprestimosOrdenados.size() > 0) {
			ordenaEmprestimos();
			return "Emprestimos pegos: " + listagemEmprestimos();			
		}
		return "Nenhum item pego emprestado";
	}
	
	/**
	 * Checka itens nao emprestados
	 * 
	 * @return Uma lista com os itens nao emprestados
	 * */
	private List<Item> itensNaoEmprestados(List<Item> todosItens) {
		for (int i = todosItens.size() - 1; i > 0 ; i--) {
			if (todosItens.get(i).getStatus() == true) {
				todosItens.remove(i);
			}
		}
		return todosItens;
	}
	
	/**
	 * Checka itens emprestados
	 * 
	 * @return Uma lista com os itens emprestados
	 * */
	private List<Emprestimo> itensEmprestados() {
		List<Emprestimo> emprestados = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimosSistema) {
			if (emprestimo.getStatus() == true) {
				emprestados.add(emprestimo);
			}
		}
		return emprestados;
	}
	
	/**
	 * Lista itens nao emprestados
	 * 
	 * @param todosItens Lista com todos os itens do Sistema
	 * 
	 * @return Uma String com as informacoes de itens nao emprestados
	 * */
	public String listarItensNaoEmprestados(List<Item> todosItens) {
		List<Item> itens = new ArrayList<>(itensNaoEmprestados(todosItens));
		ordenadorDeItens.adicionaItens(itens);
		return ordenadorDeItens.listarItensOrdenadosPorNome();
	}

	/**
	 * Lista itens emprestados
	 * 
	 * @return Uma String com as informacoes de itens emprestados
	 * */
	public String listarItensEmprestados() {
		emprestimosOrdenados = new ArrayList<>(itensEmprestados());
		ordenaEmprestimos();
		String saida = "";
		for (Emprestimo emprestimo : emprestimosOrdenados) {
			saida += "Dono do item: " + emprestimo.getNomeDono() + ", Nome do item emprestado: " + emprestimo.getNomeItem() + "|";
		}
		return saida;
	}

	/**
	 * Lista emprestimos relacionados ao item
	 * 
	 * @param nomeItem Nome do item a ser buscado
	 * 
	 * @return Uma String com as informacoes dos emprestimos relacionados ao item
	 * */
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

	/**
	 * Lista o top 10 dos itens
	 * 
	 * @param todosItens Lista de todos os itens do Sistema
	 * 
	 * @return Uma String deste top 10
	 * */
	public String listarTop10Itens(List<Item> todosItens) {
		ordenadorDeItens.adicionaItens(todosItens);
		return ordenadorDeItens.listarItensOrdenadosPorQuantidadeEmprestimos();
	}
}
