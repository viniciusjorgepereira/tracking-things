package cartoes;

public class CartaoCaloteiro implements CartaoFidelidade {
	private final String tipo = "Caloteiro";
	private final boolean emprestimo = false;
	private final int dias = 0;
	
	
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
