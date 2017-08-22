/**
 * Interface que carrega os metodos abstratos
 * dos tipos de Cartao de Fidelidade
 * */

package cartoes;

public interface CartaoFidelidade {;
	
	/**
	 * Metodo abstrato que retorna uma String
	 * informando o tipo de cartao
	 * 
	 * @return O tipo de cartao
	 * */
	public abstract String getTipoCartao();
	
	/**
	 * Metodo abstrato que retorna se o usuario
	 * tem permissao para pegar emprestado
	 * 
	 * @return Se o usuario tem permissao de emprestimo ou nao
	 * */
	public abstract boolean permissaoEmprestimo();
	
	/**
	 * Metodo abstrato que retorna qual o maximo
	 * de dias que o usuario pode pegar emprestado
	 * 
	 * @return A quantidade de dias maximo que um usuário
	 * pode pegar o item emprestado
	 * */
	public abstract int diasMaximoEmprestimo();

}
