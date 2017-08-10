/**
 * Classe que gera filmes. Esta classe herda características
 * da classe Bluray
 * */
package itens;

public class Filmes extends Bluray{

	private int lancamento;
	private Genero genero;
	
	/**
	 * Constroi um objeto do tipo Filmes
	 * 
	 * @param nome Representa o nome do filme
	 * @param preco O preco do item
	 * @param duracao Representa a duracao do filme
	 * @param classind Representa a classificacao indicativa
	 * @param genero Representa o genero do filme
	 * @param lancamento Representa o ano de lancamento
	 * */
	public Filmes(String nome, double preco, int duracao, String classind, String genero, int lancamento) {
		super(nome, preco, duracao, classind);
		this.genero = Genero.valueOf(genero.toUpperCase());
		this.lancamento = lancamento;
	}
	
	/**
	 * Recupera informacoes de um atributo desejado
	 * 
	 * @param atributo Representa o atributo a ser recuperado
	 * 
	 * @return o atributo desejado em forma de String
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
			
		} else if ("lancamento".equals(atributo.toLowerCase())) {
			return this.lancamento + "";	
		}
		
		return null;
	}
	
	/**
	 * Atualiza um atriuto do filme
	 * 
	 * @param atributo Representa atributo que sera atualizado
	 * @param valor Representa valor que sera setado como novo
	 * */
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			 this.nome = valor;
			 
		} else if ("duracao".equals(atributo.toLowerCase())) {
			 this.duracao = Integer.parseInt(valor);
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			 this.classInd = ClassificacaoIndicativa.valueOf(valor.toUpperCase());
			
		} else if ("genero".equals(atributo.toLowerCase())) {
			 this.genero = Genero.valueOf(valor.toUpperCase());
			
		} else if ("lancamento".equals(atributo.toLowerCase())) {
			 this.lancamento = Integer.parseInt(valor);
		}
	}
		
	/**
	 * Retorna uma representação em string do filme
	 * 
	 * @return Uma representacao em string do filme
	 * */
	@Override
	public String toString() {
		return "FILME: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao +
				" min, " + classInd.getValor() + ", " + genero.getValor() + ", " + lancamento;
	}
}
