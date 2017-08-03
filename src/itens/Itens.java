package itens;

public abstract class Itens {
	protected String nome;
	protected double valor;
	
	public Itens(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
}
