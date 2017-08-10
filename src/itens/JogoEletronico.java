/**
 * Classe que gera itens do tipo Jogos Eletronicos.
 * Herda caracteristica da classe itens
 * */

package itens;

public class JogoEletronico extends Item {
	private Plataforma plataforma;

	/**
	 * Constroi um objeto do tipo Jogo Eletronico
	 * 
	 * @param nome Representa o nome do item
	 * @param preco Representa o preco do item
	 * @param plataforma Plataforma que o jogo funciona
	 * */
	public JogoEletronico(String nome, Double preco, String plataforma) {
		super(nome, preco);
		this.plataforma = Plataforma.valueOf(plataforma.toUpperCase());
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
			
		} else if ("plataforma".equals(atributo.toLowerCase())) {
			return this.plataforma.getValor();
			
		}
		return null;
	}
	
	/**
	 * Metodo abstrato que atualiza dados de um item
	 * 
	 * @param atributo Atributo a ser alterado
	 * @param valor Valor que substituira o antigo
	 * */
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			this.nome = valor;
			
		} else if ("plataforma".equals(atributo.toLowerCase())) {
			this.plataforma = Plataforma.valueOf(valor.toUpperCase());
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	/**
	 * Metodo equals que analisa se um um objeto e igual
	 * atraves do nome e da plataforma
	 * 
	 * @param obj Objeto a ser comparado
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	/**
	 * Retorna uma representacao em String do jogo eletronico
	 * 
	 * @return Uma string com dados do jogo eletronico
	 * */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + super.getPrecoString() + ", " +
				super.getStatusString() + ", " + this.plataforma.getValor();
	}
}
