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
	
	public void permitirEmprestimo(Boolean permicao) {
		if (permicao == false) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
	}
	/**
	 * Checka se o periodo de emprestimo eh valido
	 * 
	 * @param periodo Numero de dias do emprestimo
	 */
	public void periodoInvalido(int periodoPermitido, int periodoRequerido) {
		if (periodoRequerido > periodoPermitido) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}
}
