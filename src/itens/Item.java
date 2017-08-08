package itens;

import java.text.DecimalFormat;

public abstract class Item {
	protected String nome;
	protected double preco;
	protected boolean status;
	
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.status = false;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String getStatusString() {
		return status == true ? "Emprestado" : "Nao emprestado";
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPrecoString() {
		DecimalFormat df = new DecimalFormat("0.0#");
		return df.format(preco).replace(",", ".");
	}

	public String getAtributo(String atributo) {
		String saida = "";
		if ("preco".equals(atributo.toLowerCase())) {
			saida += getPrecoString();			
		}
		else if ("nome".equals(atributo.toLowerCase())) {
			saida += this.nome;			
		}
		else if ("emprestimo".equals(atributo.toLowerCase())) {
			saida += getStatusString();			
		}
		return saida;
	}	
}
