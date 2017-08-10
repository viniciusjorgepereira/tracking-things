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
	 * Verifica se um item já está emprestado ou não, lancando
	 * excecao se emprestado no momento
	 * */
	public void statusItem(boolean status) {
		if (status) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * Verifica se o atributo é invalido
	 * */
	public void atributoInvalido(String infoItem) {
		if (infoItem == null) {
			throw new IllegalArgumentException("Atributo invalido");
		}
		
	}
}
