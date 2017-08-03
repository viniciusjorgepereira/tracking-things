package itens;

public class Filmes extends Bluray{

	private int lancamento;
	private Genero genero;
	
	public Filmes(String nome, int duracao, double valor, Genero genero, int lancamento) {
		super(nome, duracao, valor);
		this.genero = genero;
		this.lancamento = lancamento;
	}
}
