package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilmesTest {
	
	private Filmes novo;
	
	@Before
	public void inicializar() {
		novo = new Filmes("Os Vingadores", 19.99, 120, "doze_anos", "aventura", 2015);
	}
	
	@Test
	public void testGetAtributoPreco() {
		assertEquals("19.99", novo.getAtributo("preco"));
	}

	@Test
	public void testGetAtributoNome() {
		assertEquals("Os Vingadores", novo.getAtributo("nome"));
	}
	

	@Test
	public void testGetAtributoEmprestimo() {
		assertEquals("Nao emprestado", novo.getAtributo("emprestimo"));
	}
	
	@Test
	public void testGetAtributoDuracao() {
		assertEquals("120 min", novo.getAtributo("duracao"));
	}
	
	@Test
	public void testGetAtributoClassificacao() {
		assertEquals("DOZE_ANOS", novo.getAtributo("classificacao"));
	}
	
	@Test
	public void testGetAtributoGenero() {
		assertEquals("AVENTURA", novo.getAtributo("genero"));
	}
	
	@Test
	public void testGetAtributoPrecoLancamento() {
		assertEquals("2015", novo.getAtributo("lancamento"));
	}
		
	@Test
	public void testAtualizarAtributoPreco() {
		novo.atualizarAtributo("preco", "29.90");
		assertEquals("29.9", novo.getAtributo("preco"));
	}

	@Test
	public void testAtualizarAtributoNome() {
		novo.atualizarAtributo("nome", "Os Vingadores 2");
		assertEquals("Os Vingadores 2", novo.getAtributo("nome"));
	}

	@Test
	public void testAtualizarAtributoDuracao() {
		novo.atualizarAtributo("duracao", "130");
		assertEquals("130 min", novo.getAtributo("duracao"));
	}

	@Test
	public void testAtualizarAtributoClassificacao() {
		novo.atualizarAtributo("classificacao", "livre");
		assertEquals("LIVRE", novo.getAtributo("classificacao"));
	}
	
	@Test
	public void testAtualizarAtributoGenero() {
		novo.atualizarAtributo("genero", "acao");
		assertEquals("ACAO", novo.getAtributo("genero"));
	}
	
	@Test
	public void testAtualizarAtributoLancamento() {
		novo.atualizarAtributo("lancamento", "2014");
		assertEquals("2014", novo.getAtributo("lancamento"));
	}
	
	@Test
	public void testToString() {
		assertEquals("FILME: Os Vingadores, R$ 19.99, Nao emprestado, 120 min, DOZE_ANOS, AVENTURA, 2015", novo.toString());
	}
}
