package itens;

import java.util.HashSet;
import java.util.Set;

public class JogoTabuleiro extends Itens {
	private Set<String> pecasPerdidas;
	
	public JogoTabuleiro(String nome, double preco) {
		super(nome, preco);
		pecasPerdidas = new HashSet<>();
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
	public String toString() {
		return "JOGO DE TABULEIRO: " + nome + ", R$ " + super.getPrecoString() + 
				", " + super.getStatus() + ", " + statusPecas();
	}
}
