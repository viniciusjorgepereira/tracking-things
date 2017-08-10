package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeriesTest {

	//Atributos
	private Series suits;
	private Series novo2;
	
	/**
	 * Inicializacao para o teste
	 */
	@Before
	public void inicializar() {
		suits = new Series("Suits", 49.99, 240, "Serie finalizada", "quatorze_anos" ,"outro", 2);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		
		novo2 = new Series("Suits", 29.99, 140, "Temporada especial", "quatorze_anos", "OUTRO",  2);
	}
	
	/**
	 * Testa o metodo do hascode, duas series sao iguais se tiver mesmo
	 * nome e mesma quantidade de temporada
	 */
	@Test
	public void testHashCode() {
		assertEquals(-2003882079, suits.hashCode());
		assertEquals(-2003882079, novo2.hashCode());
	}

	/**
	 * Testa o metodo getAtributo de serie passando: nome
	 */
	@Test
	public void testGetAtributoNome() {
		assertEquals("Suits", suits.getAtributo("nome"));
	}

	/**
	 * Testa o metodo getAtributo de serie passando: emprestimo
	 */
	@Test
	public void testGetAtributoEmprestimo() {
		assertEquals("Nao emprestado", suits.getAtributo("emprestimo"));
	}
	
	/**
	 * Testa o metodo getAtributo de serie passando: duracao
	 */
	@Test
	public void testGetAtributoDuracao() {
		assertEquals("240 min", suits.getAtributo("duracao"));
	}

	/**
	 * Testa o metodo getAtributo de serie passando: classificacao
	 */
	@Test
	public void testGetAtributoClassificacao() {
		assertEquals("QUATORZE_ANOS", suits.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo getAtributo de serie passando: genero
	 */
	@Test
	public void testGetAtributoGenero() {
		assertEquals("OUTRO", suits.getAtributo("genero"));
	}
	
	/**
	 * Testa o metodo getAtributo de serie passando: temporada
	 */
	@Test
	public void testGetAtributoTemporada() {
		assertEquals("2", suits.getAtributo("temporada"));
	}
	
	/**
	 * Testa o metodo getAtributo de serie passando: descricao
	 */
	@Test
	public void testGetAtributoDescricao() {
		assertEquals("Serie finalizada", suits.getAtributo("descricao"));
	}
	
	/**
	 * Testa o metodo getAtributo de serie passando: episodios
	 */
	@Test
	public void testGetAtributoEpisodios() {
		assertEquals("4", suits.getAtributo("episodios"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: preco
	 */
	@Test
	public void testAtualizarAtributoPreco() {
		suits.atualizarAtributo("preco", "59.90");
		assertEquals("59.9", suits.getAtributo("preco"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: nome
	 */
	@Test
	public void testAtualizarAtributoNome() {
		suits.atualizarAtributo("nome", "Suitss");
		assertEquals("Suitss", suits.getAtributo("nome"));
	}

	/**
	 * Testa o metodo de atualizar atributo, passando: duracao
	 */
	@Test
	public void testAtualizarAtributoDuracao() {
		suits.atualizarAtributo("duracao", "100");
		assertEquals("100 min", suits.getAtributo("duracao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: classificacao
	 */
	@Test
	public void testAtualizarAtributoClassificacao() {
		suits.atualizarAtributo("classificacao", "dez_anos");
		assertEquals("DEZ_ANOS", suits.getAtributo("classificacao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: genero
	 */
	@Test
	public void testAtualizarAtributoGenero() {
		suits.atualizarAtributo("genero", "drama");
		assertEquals("DRAMA", suits.getAtributo("genero"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: temporada
	 */
	@Test
	public void testAtualizarAtributoTemporada() {
		suits.atualizarAtributo("temporada", "7");
		assertEquals("7", suits.getAtributo("temporada"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: descricao
	 */
	@Test
	public void testAtualizarAtributoDescricao() {
		suits.atualizarAtributo("descricao", "Pearson foi embora");
		assertEquals("Pearson foi embora", suits.getAtributo("descricao"));
	}
	
	/**
	 * Testa o metodo de atualizar atributo, passando: episodios
	 */
	@Test
	public void testAtualizarAtributoEpisodios() {
		suits.atualizarAtributo("episodios", "12");
		assertEquals("12", suits.getAtributo("episodios"));
	}
	
	/**
	 * Testa o metodo equals, duas series sao iguais se tiver o mesmo
	 * nome e a mesma quantidade de temporadas
	 */
	@Test
	public void testEqualsTrue() {
		assertEquals(true, suits.equals(novo2));
	}

	/**
	 * Testa o metodo equals, duas series sao iguais se tiver o mesmo
	 * nome e a mesma quantidade de temporadas
	 */
	@Test
	public void testEqualsFalse() {
		Series house = new Series("House of Cards", 99.99, 180, "Ta pegando fogo bicho", "DEZESSEIS_ANOS", "outro", 5);
		assertEquals(false, suits.equals(house));
	}

	/**
	 * Testa o metodo de adicionar temporada, que se refere a quantidade
	 * de episodios da serie
	 */
	@Test
	public void testAdicionarTemporada() {
		suits.adicionarTemporada(45);
		assertEquals("5", suits.getAtributo("episodios"));
	}

	/**
	 * Testa o metodo toString de serie
	 */
	@Test
	public void testToString() {
		assertEquals("SERIE: Suits, R$ 49.99, Nao emprestado, 240 min, QUATORZE_ANOS, OUTRO, Temporada 2", suits.toString());
	}

}
