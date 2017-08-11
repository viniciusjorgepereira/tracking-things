package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeriesTest {

	private Series suits;
	private Series novo2;
	
	@Before
	public void inicializar() {
		suits = new Series("Suits", 49.99, 240, "Serie finalizada", "quatorze_anos" ,"outro", 2);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		suits.adicionarTemporada(60);
		
		novo2 = new Series("Suits", 29.99, 140, "Temporada especial", "quatorze_anos", "OUTRO",  2);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(-2003882079, suits.hashCode());
		assertEquals(-2003882079, novo2.hashCode());
	}

	@Test
	public void testGetAtributoNome() {
		assertEquals("Suits", suits.getAtributo("nome"));
	}

	@Test
	public void testGetAtributoEmprestimo() {
		assertEquals("Nao emprestado", suits.getAtributo("emprestimo"));
	}

	@Test
	public void testGetAtributoDuracao() {
		assertEquals("240 min", suits.getAtributo("duracao"));
	}

	@Test
	public void testGetAtributoClassificacao() {
		assertEquals("QUATORZE_ANOS", suits.getAtributo("classificacao"));
	}
	
	@Test
	public void testGetAtributoGenero() {
		assertEquals("OUTRO", suits.getAtributo("genero"));
	}
	
	@Test
	public void testGetAtributoTemporada() {
		assertEquals("2", suits.getAtributo("temporada"));
	}
	
	@Test
	public void testGetAtributoDescricao() {
		assertEquals("Serie finalizada", suits.getAtributo("descricao"));
	}
	
	@Test
	public void testGetAtributoEpisodios() {
		assertEquals("4", suits.getAtributo("episodios"));
	}
	
	@Test
	public void testAtualizarAtributoPreco() {
		suits.atualizarAtributo("preco", "59.90");
		assertEquals("59.9", suits.getAtributo("preco"));
	}
	
	@Test
	public void testAtualizarAtributoNome() {
		suits.atualizarAtributo("nome", "Suitss");
		assertEquals("Suitss", suits.getAtributo("nome"));
	}

	@Test
	public void testAtualizarAtributoDuracao() {
		suits.atualizarAtributo("duracao", "100");
		assertEquals("100 min", suits.getAtributo("duracao"));
	}
	
	@Test
	public void testAtualizarAtributoClassificacao() {
		suits.atualizarAtributo("classificacao", "dez_anos");
		assertEquals("DEZ_ANOS", suits.getAtributo("classificacao"));
	}
	
	@Test
	public void testAtualizarAtributoGenero() {
		suits.atualizarAtributo("genero", "drama");
		assertEquals("DRAMA", suits.getAtributo("genero"));
	}
	
	@Test
	public void testAtualizarAtributoTemporada() {
		suits.atualizarAtributo("temporada", "7");
		assertEquals("7", suits.getAtributo("temporada"));
	}
	
	@Test
	public void testAtualizarAtributoDescricao() {
		suits.atualizarAtributo("descricao", "Pearson foi embora");
		assertEquals("Pearson foi embora", suits.getAtributo("descricao"));
	}
	
	@Test
	public void testAtualizarAtributoEpisodios() {
		suits.atualizarAtributo("episodios", "12");
		assertEquals("12", suits.getAtributo("episodios"));
	}
	
	@Test
	public void testEqualsTrue() {
		assertEquals(true, suits.equals(novo2));
	}

	@Test
	public void testEqualsFalse() {
		Series house = new Series("House of Cards", 99.99, 180, "Ta pegando fogo bicho", "DEZESSEIS_ANOS", "outro", 5);
		assertEquals(false, suits.equals(house));
	}

	@Test
	public void testAdicionarTemporada() {
		suits.adicionarTemporada(45);
		assertEquals("5", suits.getAtributo("episodios"));
	}

	@Test
	public void testToString() {
		assertEquals("SERIE: Suits, R$ 49.99, Nao emprestado, 240 min, QUATORZE_ANOS, OUTRO, Temporada 2", suits.toString());
	}

}
