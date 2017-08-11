/**
 * Classe que cria jogos de tabuleiro. Herda caracteristicas de
 * Item.
 * */

package itens;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item {
	private List<String> pecasPerdidas;
	
	/**
	 * Cria um jogo de tabuleiro. Dentro do construtor ha
	 * um array para armazenar as possiveis pecas perdias
	 * 
	 * @param nome Representa nome do jogo
	 * @param preco Representa preco do jogo
	 * */
	public JogoTabuleiro(String nome, double preco) {
		super(nome, preco);
		pecasPerdidas = new ArrayList<>();
	}
	
	/**
	 * Adiciona peças perdidas ao jogo
	 * 
	 * @param peca Peca perdida a ser registrada
	 * */
	public void adicionarPecaPerdida(String peca) {
		pecasPerdidas.add(peca);
	}

	
	/**
	 * Checka status do jogo, se ha  pecas perdidas
	 * ou nao
	 * 
	 * @return Uma string indicando se ha pecas perdidas ou se esta completo
	 * */
	public String statusPecas() {
		if (pecasPerdidas.size() > 0) {
			return "COM PECAS PERDIDAS";
		}
		return "COMPLETO";
	}
	
	/**
	 * Retorna as pecas perdidas
	 * 
	 * @return Todas as pecas perdidas em forma de string
	 * */
	public String getPecasPerdidas() {
		String saida = "";
		for (String peca : pecasPerdidas) {
			saida += peca + System.lineSeparator();
		}
		return saida;
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
			
		} else if ("pecas perdidas".equals(atributo.toLowerCase())) {
			return getPecasPerdidas();	
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
			this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			this.nome = valor;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	/**
	 * Metodo equals. Ve se um jogo de tabuleiro e igual a outro
	 * pelo nome e pelas pecas perdidas
	 * 
	 * @param obj Objeto a ser comparado
	 * 
	 * @return um boolean informando se e igual ou nao
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}

	/**
	 * Retorna uma representacao em string de um jogo de tabuleiro
	 * 
	 * @return Uma string com os dados do jogo de tabuleiro
	 * */
	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + nome + ", R$ " + super.getPrecoString() + 
				", " + super.getStatusString() + ", " + statusPecas();
	}


}
