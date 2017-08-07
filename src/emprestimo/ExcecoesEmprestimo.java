package emprestimo;

public class ExcecoesEmprestimo {

	public void emprestimoInvalido(Emprestimo emprestimo) {
		if (emprestimo == null) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
	}
	
}
