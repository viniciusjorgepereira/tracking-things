package itens;

public class Filmes extends Bluray{

	private int lancamento;
	private Genero genero;
	
	public Filmes(String nome, double preco, int duracao, String classind, String genero, int lancamento) {
		super(nome, preco, duracao, classind);
		this.genero = Genero.valueOf(genero.toUpperCase());
		this.lancamento = lancamento;
	}
	
	@Override
	public String getAtributo(String atributo) {
		if ("preco".equals(atributo.toLowerCase())) {
			return super.getPrecoString();
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
			
		} else if ("emprestimo".equals(atributo.toLowerCase())) {
			return super.getStatusString();
			
		} else if ("duracao".equals(atributo.toLowerCase())) {
			return this.duracao + " min";
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			return this.classind.getValor();
			
		} else if ("genero".equals(atributo.toLowerCase())) {
			return this.genero.getValor();
			
		} else if ("lancamento".equals(atributo.toLowerCase())) {
			return this.lancamento + "";	
		}
		
		return null;
	}
	
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			 this.nome = valor;
			 
		} else if ("duracao".equals(atributo.toLowerCase())) {
			 this.duracao = Integer.parseInt(valor);
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			 this.classind = ClassificacaoIndicativa.valueOf(valor.toUpperCase());
			
		} else if ("genero".equals(atributo.toLowerCase())) {
			 this.genero = Genero.valueOf(valor.toUpperCase());
			
		} else if ("lancamento".equals(atributo.toLowerCase())) {
			 this.lancamento = Integer.parseInt(valor);
		}
	}
		
	@Override
	public String toString() {
		return "FILME: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao +
				" min, " + classind.getValor() + ", " + genero.getValor() + ", " + lancamento;
	}
}
