/**
 * Classe responsavel por lancar excecoes dos
 * emprestimos
 * */

package emprestimo;

import java.io.Serializable;

public class ExcecoesEmprestimo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * Checka se o emprestimo eh nulo
	 * 
	 * @param emprestimo Reresenta o emprestimo a ser analisado
	 * */
	public void emprestimoInvalido(Emprestimo emprestimo) {
		if (emprestimo == null) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
	}
	
	/**
	 * Lança excecao caso o usuario nao possa pegar itens emprestados
	 * 
	 * @param permissao Diz se o usuario pode pegar um item emprestado ou nao
	 * */
	public void permitirEmprestimo(Boolean permissao) {
		if (!permissao) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
	}
	/**
	 * Checka se o periodo de emprestimo eh valido
	 * 
	 * @param periodoPermitido Numero de dias que o emprestimo e permitido
	 * @param periodoRequerido Numero de dias desejados para emprestimo
	 */
	public void periodoInvalido(int periodoPermitido, int periodoRequerido) {
		if (periodoRequerido > periodoPermitido) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}
}
