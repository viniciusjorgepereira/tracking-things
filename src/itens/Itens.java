package itens;

import java.text.DecimalFormat;

public abstract class Itens {
	protected String nome;
	protected double preco;
	protected boolean status;
	
	public Itens(String nome, double preco) {
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
	
	
	public String getStatus() {
		return status == true ? "Emprestado" : "Nao emprestado";
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPrecoString() {
		DecimalFormat df = new DecimalFormat("0.0#");
		String valor = df.format(preco).replace(",", ".");
		
		return valor;
	}

	public String getAtributo(String atributo) {
		if (atributo.equals("Preco")) {
			return getPrecoString();
			
		} else if (atributo.equals("Nome")) {
			return nome;
		}
		
		return "";
	}	
}
