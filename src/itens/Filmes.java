package itens;

public class Filmes extends Bluray{

	private int lancamento;
	private String genero;
	
	public Filmes(String nome, double preco, int duracao, String classind, String genero, int lancamento) {
		super(nome, preco, duracao, classind);
		this.genero = genero;
		this.lancamento = lancamento;
	}
	
	@Override
	public String toString() {
		return "FILME: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatus() + ", " + duracao +
				" min, " + classInd + ", " + genero + ", " + lancamento;
	}
}
