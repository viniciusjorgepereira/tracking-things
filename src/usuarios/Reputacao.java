package usuarios;

public class Reputacao {
	
	private double reputacao;
	
	public Reputacao(double valor) {
		this.reputacao = valor;
	}

	public double getReputacao() {
		return reputacao;
	}
	
	public void acrescimoCinco(double preco) {
		this.reputacao += preco * 0.05;
	}
	
	public void acrescimoDez(double preco) {
		this.reputacao += preco * 0.10;
	}

	public void diminuirReputacao(int atraso, double preco) {
		double desconto = (double) atraso / 100;
		this.reputacao -= desconto * preco;
	}
}
