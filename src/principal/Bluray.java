package principal;

public class Bluray {
	
	protected int preco;
	protected int duracao;
	protected String titulo;
	protected int anoLancamento;
	protected boolean emprestimo;
	protected ClassInd classind;
	
	public Bluray(String titulo, int preco, int duracao, ClassInd classind, int lancamento) {
		this.titulo = titulo;
		this.preco = preco;
		this.duracao = duracao;
		this.classind = classind;
		this.anoLancamento = lancamento;
	}
}
