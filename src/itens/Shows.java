package itens;

public class Shows extends Bluray{

	private int faixas;
	private String artista;
	
	public Shows(String nome, double preco, int duracao, int faixas, String artista, String classInd) {
		super(nome, preco, duracao, classInd);
		this.faixas = faixas;
		this.artista = artista;	
	}

	@Override
	public String toString() {
		return "SHOW: "+ nome + ", R$ " + super.getPrecoString() + ", " + super.getStatus() + ", " + duracao + 
				" min, " + classInd + ", " + artista + ", " + faixas + " faixas";
	}
}
