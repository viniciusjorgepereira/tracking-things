package itens;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item {
	private List<String> pecasPerdidas;
	
	public JogoTabuleiro(String nome, double preco) {
		super(nome, preco);
		pecasPerdidas = new ArrayList<>();
	}
	
	public void adicionarPecaPerdida(String peca) {
		pecasPerdidas.add(peca);
	}
	
	public String statusPecas() {
		if (pecasPerdidas.size() > 0) {
			return "COM PECAS PERDIDAS";
		}
		return "COMPLETO";
	}
	
	public String getPecasPerdidas() {
		String saida = "";
		for (String peca : pecasPerdidas) {
			saida += peca + System.lineSeparator();
		}
		return saida;
	}
	
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

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + nome + ", R$ " + super.getPrecoString() + 
				", " + super.getStatusString() + ", " + statusPecas();
	}


}
