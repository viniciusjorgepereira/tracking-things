package principal;

public class Filmes{
	
	private int preco;
	private boolean emprestimo;
	private int anoLancamento;
	private int duracao;
	private String titulo;
	private ClassIndicativa classificacao;
	private Genero genero;
	
	public Filmes(String titulo, int lancamento, int duracao, ClassIndicativa classificacao, Genero genero) {
		this.titulo = titulo;
		this.anoLancamento = lancamento;
		this.duracao = duracao;
		this.classificacao = classificacao;
		this.genero = genero;
	}

}
