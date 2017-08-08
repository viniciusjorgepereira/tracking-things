package itens;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Itens {
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
