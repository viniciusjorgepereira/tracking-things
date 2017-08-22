package emprestimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartoes.CartaoFidelidade;
import itens.Item;
import usuarios.IdUsuario;
import usuarios.Usuario;

public class EmprestimoController {
	private ExcecoesEmprestimo excecoesEmprestimo;
	private ArrayList<Emprestimo> emprestimosOrdenados;
	
	public EmprestimoController() {
		 excecoesEmprestimo = new ExcecoesEmprestimo();
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
	public void registrarEmprestimo(Usuario dono, Usuario requerente, Emprestimo emprestimo) {
		permicaoEmprestimo(requerente.getCartao(), emprestimo.getDias(), emprestimo.getItem());
		dono.registrarEmprestimo(emprestimo);
		requerente.registrarEmprestimo(emprestimo);
	}
	
	public void permicaoEmprestimo(CartaoFidelidade cartao, int periodoRequerido, Item item) {
		excecoesEmprestimo.permitirEmprestimo(cartao.permicaoEmprestimo());
		excecoesEmprestimo.periodoInvalido(cartao.diasMaximoEmprestimo(), periodoRequerido);
	}
	
	public Emprestimo criarEmprestimo(IdUsuario idDono, IdUsuario idRequerente, Item item, String dataEmprestimo, int periodo) {
		return new Emprestimo(idDono, idRequerente, dataEmprestimo, item, periodo);
	}
	
	public String listarEmprestimosUsuarioEmprestando(List<Emprestimo> emprestimos) {
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return "Emprestimos: " + listagemEmprestimos();
		}
		return "Nenhum item emprestado";
	}

	private void ordenaEmprestimos(List<Emprestimo> emprestimos) {
		emprestimosOrdenados = new ArrayList<>(emprestimos);
		Collections.sort(emprestimosOrdenados, new OrdemEmprestimoNome());
	}
	
	private String listagemEmprestimos() {
		String saida = "";
		for(Emprestimo emprestimo: this.emprestimosOrdenados) {
			saida += emprestimo.toString() + "|";
		}
		return saida;
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(List<Emprestimo> emprestimos) {
		ordenaEmprestimos(emprestimos);
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return "Emprestimos pegos: " + listagemEmprestimos();			
		}
		return "Nenhum item pego emprestado";
	}
}
