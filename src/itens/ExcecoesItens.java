package itens;

public class ExcecoesItens {
	
	public void precoInvalido(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}
	
	public void itemNotFound() {
		throw new IllegalArgumentException("Item nao encontrado");
	}

	public void statusItem(boolean status) {
		if (status) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}
}
