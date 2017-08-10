/**
 * Classe responsavel por lancar excecoes nos
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
}
