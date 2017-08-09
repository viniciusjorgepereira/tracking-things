package itens;

public class ExcecoesItens {
	public void itemNotFound() {
		throw new IllegalArgumentException("Item nao encontrado");
	}

	public void statusItem(boolean status) {
		if (status) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}
}
