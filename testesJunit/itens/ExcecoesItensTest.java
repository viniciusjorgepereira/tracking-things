package itens;

import org.junit.Before;
import org.junit.Test;

public class ExcecoesItensTest {

	private ExcecoesItens excecoes;

	@Before
	public void inicializar() {
		excecoes = new ExcecoesItens();
	}

	/**
	 * Lanca uma excecao caso o item procurado nao exista no sistema
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemNotFound() {
		excecoes.itemInexistente();
	}

	/**
	 * Testa o status do item, dando uma excecao caso o parametro seja true, do
	 * contrario, nada ocorre
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testStatusItem() {
		excecoes.statusItem(true);
	}

	/**
	 * Testa a excecao caso o parametro seja invalido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalido() {
		excecoes.atributoInvalido(null);
	}

}
