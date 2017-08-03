package itens;

public abstract class Itens {
	protected String nome;
	protected double preco;
	
	public Itens(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
}
