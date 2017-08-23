/**
 * Classe que cria e calcula a reputacao do
 * usuario
 * */

package usuarios;

public class Reputacao {
	
	private double reputacao;
	
	/**
	 * Constroi a reputacao do usuario
	 * 
	 * @param valor Representa o valor inicial da reputacao
	 * */
	public Reputacao(double valor) {
		this.reputacao = valor;
	}

	public double getReputacao() {
		return reputacao;
	}
	
	/**
	 * Acrescenta 5% do preco do item adicionado para
	 * emprestimo a reputacao do usuario
	 * 
	 * @param preco Representa o preco do item adicionado para emprestimo
	 * */
	public void acrescimoCinco(double preco) {
		this.reputacao += preco * 0.05;
	}
	
	/**
	 * Acrescenta 10% do preco do item ao emprestar
	 * a outro usuario
	 * 
	 * @param preco Representa o preco do item emprestado
	 * */
	public void acrescimoDez(double preco) {
		this.reputacao += preco * 0.10;
	}

	/**
	 * Diminui a reputacao de um usuario ao atrasar na entrega
	 * de um item
	 * 
	 * @param atraso Representa o atraso da entraga do item em dias
	 * @param preco Representa o preco do item emprestado
	 * */
	public void diminuirReputacao(int atraso, double preco) {
		double desconto = (double) atraso / 100;
		this.reputacao -= desconto * preco;
	}
}
