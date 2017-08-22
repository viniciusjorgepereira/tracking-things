/**
 * Classe item que abriga as caracteristicas base para
 * os itens do sistema
 * */

package itens;

import java.text.DecimalFormat;

public abstract class Item {
	protected String nome;
	protected double preco;
	protected boolean status;
	protected int quantidadeEmprestimos;
	
	/**
	 * Constroi um objeto do tipo Item. Dentro do construtor,
	 * possui um status indicando se ele foi emprestado ou nao
	 * 
	 * @param nome Representa nome do item
	 * @param preco Representa preco do item
	 * */
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.status = false;
		this.quantidadeEmprestimos = 0;
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
	public int getQuantidadeEmprestimos() {
		return quantidadeEmprestimos;
	}
	
	public void adicionaQuantidadeEmprestimos() {
		this.quantidadeEmprestimos += 1;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Diz qual o status daquele item
	 * 
	 * @return String dizendo se esta emprestado ou nao
	 * */
	public String getStatusString() {
		return status == true ? "Emprestado" : "Nao emprestado";
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Retorna a formatacao correta do preco do item
	 * em um String
	 * 
	 * @return Uma string com a formatacao correta em reais
	 * */
	public String getPrecoString() {
		DecimalFormat df = new DecimalFormat("0.0#");
		return df.format(preco).replace(",", ".");
	}

	/**
	 * Metodo abstrato que resgata dados de um certo atributo
	 * passado como parametro
	 * 
	 * @param atributo Atributo a ser resgatado
	 * 
	 * @return Uma string com o dado recuperado
	 * */
	public abstract String getAtributo(String atributo);
	
	/**
	 * Metodo abstrato que atualiza dados de um item
	 * 
	 * @param atributo Atributo a ser alterado
	 * @param valor Valor que substituira o antigo
	 * */
	public abstract void atualizarAtributo(String atributo, String valor);

}
