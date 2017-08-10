package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilmesTest {

	//Atributos
	private Filmes novo;
	
	/**
	 * Inicializacao
	 */
	@Before
	public void inicializar() {
		novo = new Filmes("Os Vingadores", 19.99, 120, "doze_anos", "aventura", 2015);
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: preco
	 */
	@Test
	public void testGetAtributoPreco() {
		assertEquals("19.99", novo.getAtributo("preco"));
	}

	/**
	 * Testa o metodo getAtributo de filmes, passando: nome
	 */
	@Test
	public void testGetAtributoNome() {
		assertEquals("Os Vingadores", novo.getAtributo("nome"));
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: emprestimo
	 */
	@Test
	public void testGetAtributoEmprestimo() {
		assertEquals("Nao emprestado", novo.getAtributo("emprestimo"));
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: duracao
	 */
	@Test
	public void testGetAtributoDuracao() {
		assertEquals("120 min", novo.getAtributo("duracao"));
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: classificacao
	 */
	@Test
	public void testGetAtributoClassificacao() {
		assertEquals("DOZE_ANOS", novo.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: genero
	 */
	@Test
	public void testGetAtributoGenero() {
		assertEquals("AVENTURA", novo.getAtributo("genero"));
	}
	
	/**
	 * Testa o metodo getAtributo de filmes, passando: lancamento
	 */
	@Test
	public void testGetAtributoPrecoLancamento() {
		assertEquals("2015", novo.getAtributo("lancamento"));
	}
		
	/**
	 * Testa o metodo de atualizar atributo, passando: preco
	 */
	@Test
	public void testAtualizarAtributoPreco() {
		novo.atualizarAtributo("preco", "29.90");
		assertEquals("29.9", novo.getAtributo("preco"));
	}

	/**
	 * Testa o metodo de atualizar atributo, passando: nome
	 */
	@Test
	public void testAtualizarAtributoNome() {
		novo.atualizarAtributo("nome", "Os Vingadores 2");
		assertEquals("Os Vingadores 2", novo.getAtributo("nome"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: duracao
	 */
	@Test
	public void testAtualizarAtributoDuracao() {
		novo.atualizarAtributo("duracao", "130");
		assertEquals("130 min", novo.getAtributo("duracao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: classificacao
	 */
	@Test
	public void testAtualizarAtributoClassificacao() {
		novo.atualizarAtributo("classificacao", "livre");
		assertEquals("LIVRE", novo.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: genero
	 */
	@Test
	public void testAtualizarAtributoGenero() {
		novo.atualizarAtributo("genero", "acao");
		assertEquals("ACAO", novo.getAtributo("genero"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: lancamento
	 */
	@Test
	public void testAtualizarAtributoLancamento() {
		novo.atualizarAtributo("lancamento", "2014");
		assertEquals("2014", novo.getAtributo("lancamento"));
	}
	
	/**
	 * Testa o metodo toString de filmes
	 */
	@Test
	public void testToString() {
		assertEquals("FILME: Os Vingadores, R$ 19.99, Nao emprestado, 120 min, DOZE_ANOS, AVENTURA, 2015", novo.toString());
	}
}
