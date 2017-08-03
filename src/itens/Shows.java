package itens;

public class Shows extends Bluray{

	private int faixas;
	private String artista;
	private String classInd;
	
	public Shows(String nome, double preco, int duracao, int faixas, String artista, String classInd) {
		super(nome, preco, duracao);
		this.faixas = faixas;
		this.artista = artista;
		this.classInd = classInd;		
	}

}
