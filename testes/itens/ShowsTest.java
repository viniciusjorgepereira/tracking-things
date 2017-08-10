package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShowsTest {

	private Shows desconhecido;
	
	@Before
	public void inicializar() {
		desconhecido = new Shows("Um show ai", 39.99, 120, 16, "Desconhecido", "livre");
	}
	
	/**
	 * Testa o metodo getAtributo, passando: preco
	 */
	@Test
	public void testGetAtributoPreco() {
		assertEquals("39.99", desconhecido.getAtributo("preco"));
	}
	
	/**
	 * Testa o metodo getAtributo, passando: nome
	 */
	@Test
	public void testGetAtributoNome() {
		assertEquals("Um show ai", desconhecido.getAtributo("nome"));
	}
	
	/**
	 * Testa o metodo getAtributo, passando: emprestimo
	 */
	@Test
	public void testGetAtributoEmprestimo() {
		assertEquals("Nao emprestado", desconhecido.getAtributo("emprestimo"));
	}

	/**
	 * Testa o metodo getAtributo, passando: duracao
	 */
	@Test
	public void testGetAtributoDuracao() {
		assertEquals("120 min", desconhecido.getAtributo("duracao"));
	}
	
	/**
	 * Testa o metodo getAtributo, passando: classificacao
	 */
	@Test
	public void testGetAtributoClassificacao() {
		assertEquals("LIVRE", desconhecido.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo getAtributo, passando: faixas
	 */
	@Test
	public void testGetAtributoFaixas() {
		assertEquals("16", desconhecido.getAtributo("faixas"));
	}
	
	/**
	 * Testa o metodo getAtributo, passando: artista
	 */
	@Test
	public void testGetAtributoArtista() {
		assertEquals("Desconhecido", desconhecido.getAtributo("artista"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo de shows, passando: preco 
	 */
	@Test
	public void testAtualizarAtributoPreco() {
		desconhecido.atualizarAtributo("preco", "19.90");
		assertEquals("19.9", desconhecido.getAtributo("preco"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo de shows, passando: nome 
	 */
	@Test
	public void testAtualizarAtributoNome() {
		desconhecido.atualizarAtributo("nome", "Show topper");
		assertEquals("Show topper", desconhecido.getAtributo("nome"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo de shows, passando: duracao 
	 */
	@Test
	public void testAtualizarAtributoDuracao() {
		desconhecido.atualizarAtributo("duracao", "100");
		assertEquals("100 min", desconhecido.getAtributo("duracao"));
	}

	/**
	 * Testa o metodo de atualizar atributo de shows, passando: classificacao 
	 */
	@Test
	public void testAtualizarAtributoClassificacao() {
		desconhecido.atualizarAtributo("classificacao", "dez_anos");
		assertEquals("DEZ_ANOS", desconhecido.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo de shows, passando: faixas 
	 */
	@Test
	public void testAtualizarAtributoFaixas() {
		desconhecido.atualizarAtributo("faixas", "12");
		assertEquals("12", desconhecido.getAtributo("faixas"));
	}
	
	
	/**
	 * Testa o metodo de atualizar atributo de shows, passando: artista 
	 */
	@Test
	public void testAtualizarAtributoArtista() {
		desconhecido.atualizarAtributo("artista", "Eu");
		assertEquals("Eu", desconhecido.getAtributo("artista"));
	}
	
	/**
	 * Testa o metodo toString de shows
	 */
	@Test
	public void testToString() {
		assertEquals("SHOW: Um show ai, R$ 39.99, Nao emprestado, 120 min, LIVRE, Desconhecido, 16 faixas", desconhecido.toString());
	}
}
