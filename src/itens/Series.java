/**
 * Classe que cria series. Herda caracteristica de BluRay
 * */

package itens;

public class Series extends Bluray{
	
	private int episodios;
	private Genero genero;
	private String descricao;
	private int numTemporadas;
	
	/**
	 * Constroi um objeto do tipo serie
	 * 
	 * @param nome Representa o nome do Item
	 * @param preco Representa preco do item
	 * @param duracao Representa duracao da serie
	 * @param descricao Uma descricao da serie
	 * @param classificacao Representa a classificacao indicativa da serie
	 * @param genero Representa o genero da serie
	 * @param temporada Representa a temporada da serie
	 * */
	public Series(String nome, double preco, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, preco, duracao, classificacao);
		this.descricao = descricao;
		this.numTemporadas = temporada;
		this.genero = Genero.valueOf(genero.toUpperCase());
	}

	/**
	 * Metodo que acrescenta temporadas a uma serie
	 * 
	 * @param duracao Representa a duracao do episodio
	 * */
	public void adicionarTemporada(int duracao) {
		this.episodios += 1;
	}
	
	/**
	 * Metodo que resgata dados de um certo atributo
	 * passado como parametro
	 * 
	 * @param atributo Atributo a ser resgatado
	 * 
	 * @return Uma string com o dado recuperado
	 * */
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
			return this.classInd.getValor();
			
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

	/**
	 * Metodo que atualiza dados de um item
	 * 
	 * @param atributo Atributo a ser alterado
	 * @param valor Valor que substituira o antigo
	 * */
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			this.nome = valor;
			
		} else if ("duracao".equals(atributo.toLowerCase())) {
			this.duracao = Integer.parseInt(valor);
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			this.classInd = ClassificacaoIndicativa.valueOf(valor.toUpperCase());
			
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

	/**
	 * Metodo equals. Ve se uma serie e igual a outra
	 * pelo nome e pelo numero de temporadas
	 * 
	 * @param obj Objeto a ser comparado
	 * 
	 * @return um boolean informando se e igual ou nao
	 * */
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
	
	/**
	 * Retorna uma representacao em string de uma serie
	 * 
	 * @return Uma string com os dados da serie
	 * */
	@Override
	public String toString() {
		return "SERIE: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao + 
				" min, " + classInd.getValor() + ", " + genero.getValor() + ", Temporada " + numTemporadas;
	}

}
