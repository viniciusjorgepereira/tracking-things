package cartoes;

public class CartaoNoob implements CartaoFidelidade{
	private final String tipo = "Noob";
	private final boolean emprestimo = true;
	private final int dias = 7;
	
	
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
