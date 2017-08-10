/**
 * Classe responsavel por lancar excecoes nos
 * emprestimos
 * */

package emprestimo;

public class ExcecoesEmprestimo {

	/**
	 * Checka se o emprestimo e nulo
	 * 
	 * @param emprestimo Rpresenta o emprestimo a ser analisado
	 * */
	public void emprestimoInvalido(Emprestimo emprestimo) {
		if (emprestimo == null) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
	}
}
