/**
 * Classe que lança exceções para os itens
 * */

package itens;

public class ExcecoesItens {
	
	/**
	 * Verifica se um item não foi encontrado, lancando
	 * excecao se não encontrado
	 * */
	public void itemNotFound() {
		throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Verifica se um item ja esta emprestado ou nao, lancando
	 * excecao se emprestado no momento
	 * 
	 * @param status Boolean que indica se um item esta emprestado ou nao
	 * */
	public void statusItem(boolean status) {
		if (status) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * Verifica se o atributo e invalido
	 * 
	 * @param infoItem Infoma atributo a ser checkado
	 * */
	public void atributoInvalido(String infoItem) {
		if (infoItem == null) {
			throw new IllegalArgumentException("Atributo invalido");
		}
		
	}
}
