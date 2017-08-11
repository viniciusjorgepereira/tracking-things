package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest {
	private JogoTabuleiro jgTabuleiro;
	private JogoTabuleiro jgVazio;
	private final String pulaLinha = System.lineSeparator();
	
	@Before
	public void testJogoTabuleiro() {
		jgTabuleiro = new JogoTabuleiro("Xadrez", 10.0);
		jgVazio = new JogoTabuleiro("Only for empty tests", 0.15);
	}
	
	@Test
	public void testAdicionarPecaPerdida() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals("rainha branca" + pulaLinha +
					 "rei preto" + pulaLinha, jgTabuleiro.getPecasPerdidas());
	}
	
	@Test
	public void testGetAtributo() {
		assertEquals("Xadrez", jgTabuleiro.getAtributo("nome"));
		assertEquals("10.0", jgTabuleiro.getAtributo("preco"));
	}

	@Test
	public void testAtualizarAtributo() {
		jgTabuleiro.atualizarAtributo("nome", "XADREZ");
		assertEquals("XADREZ", jgTabuleiro.getNome());
		
		jgTabuleiro.atualizarAtributo("preco", "12.0");
		assertEquals(12.0, jgTabuleiro.getPreco(), 0.1);
	}

	

	@Test
	public void testStatusPecas() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals("COM PECAS PERDIDAS", jgTabuleiro.statusPecas());
		assertEquals("COMPLETO", jgVazio.statusPecas());
	}

	@Test
	public void testGetPecasPerdidas() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals("rainha branca" + pulaLinha +
				 	 "rei preto" + pulaLinha, jgTabuleiro.getPecasPerdidas());
	}

	@Test
	public void testEqualsObject() {
		JogoTabuleiro jgTest = new JogoTabuleiro("Xadrez", 0.15);
		assertTrue(jgTabuleiro.equals(jgTest));
		
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertFalse(jgTabuleiro.equals(jgTest));
	}

	@Test
	public void testToString() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 10.0, Nao emprestado, COM PECAS PERDIDAS", jgTabuleiro.toString());
		assertEquals("JOGO DE TABULEIRO: Only for empty tests, R$ 0.15, Nao emprestado, COMPLETO", jgVazio.toString());
	}

}
