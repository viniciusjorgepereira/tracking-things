package cartoes;

public class CartaoFreeRider implements CartaoFidelidade {
	private final String tipo = "FreeRyder";
	private final boolean emprestimo = true;
	private final int dias = 5;
	
	
	@Override
	public String getTipoCartao() {
		return tipo;
	}

	@Override
	public boolean permicaoEmprestimo() {
		return emprestimo;
	}

	@Override
	public int diasMaximoEmprestimo() {
		return dias;
	}
}
