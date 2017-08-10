package itens;

public class Series extends Bluray{
	
	private int episodios;
	private Genero genero;
	private String descricao;
	private int numTemporadas;
	
	public Series(String nome, double preco, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, preco, duracao, classificacao);
		this.descricao = descricao;
		this.numTemporadas = temporada;
		this.genero = Genero.valueOf(genero.toUpperCase());
	}

	public void adicionarTemporada(int duracao) {
		this.episodios += 1;
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
			
		} else if ("temporada".equals(atributo.toLowerCase())) {
			return String.valueOf(this.numTemporadas);
			
		} else if ("descricao".equals(atributo.toLowerCase())) {
			return this.descricao;
			
		} else if ("episodios".equals(atributo.toLowerCase())) {
			return String.valueOf(this.episodios);
			
		}
		return null;
	}

	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			this.nome = valor;
			
		} else if ("duracao".equals(atributo.toLowerCase())) {
			this.duracao = Integer.parseInt(valor);
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			this.classind = ClassificacaoIndicativa.valueOf(valor.toUpperCase());
			
		} else if ("genero".equals(atributo.toLowerCase())) {
			this.genero = Genero.valueOf(valor.toUpperCase());
			
		} else if ("temporada".equals(atributo.toLowerCase())) {
			this.numTemporadas = Integer.parseInt(valor);
			
		} else if ("descricao".equals(atributo.toLowerCase())) {
			this.descricao = valor;
			
		} else if ("episodios".equals(atributo.toLowerCase())) {
			this.episodios = Integer.parseInt(valor);
			
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numTemporadas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		if (nome == null) {
			if (other.nome!= null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numTemporadas != other.numTemporadas)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SERIE: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao + 
				" min, " + classind.getValor() + ", " + genero.getValor() + ", Temporada " + numTemporadas;
	}

}
