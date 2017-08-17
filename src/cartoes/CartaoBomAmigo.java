package cartoes;

public class CartaoBomAmigo implements CartaoFidelidade{
	private final String tipo = "BomAmigo";
	private final boolean emprestimo = true;
	private final int dias = 14;
	
	
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
