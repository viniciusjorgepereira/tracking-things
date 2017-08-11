/**
 * Classe responsavel por lancar excecoes dos
 * emprestimos
 * */

package emprestimo;

public class ExcecoesEmprestimo {

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
	 * Checka se o periodo de emprestimo eh valido
	 * 
	 * @param periodo Numero de dias do emprestimo
	 */
	public void periodoInvalido(int periodo) {
		if (periodo > 7) {
			throw new IllegalArgumentException("Periodo invalido");
		}
	}
}
