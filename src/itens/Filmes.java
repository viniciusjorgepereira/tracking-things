package itens;

public class Filmes extends Bluray{

	private int lancamento;
	private String genero;
	
	public Filmes(String nome, double preco, int duracao, String genero, int lancamento) {
		super(nome, preco, duracao);
		this.genero = genero;
		this.lancamento = lancamento;
	}
}
