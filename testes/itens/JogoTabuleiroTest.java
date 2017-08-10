package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest {
	private JogoTabuleiro jgTabuleiro;
	private JogoTabuleiro jgVazio;
	
	@Before
	public void testJogoTabuleiro() {
		jgTabuleiro = new JogoTabuleiro("Xadrez", 10.0);
		jgVazio = new JogoTabuleiro("Only for empty tests", 0.15);
	}
	
	@Test
	public void testAdicionarPecaPerdida() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals(jgTabuleiro.getPecasPerdidas(), "rainha branca\n" + 
													 "rei preto\n");
	}
	
	@Test
	public void testGetAtributo() {
		assertEquals(jgTabuleiro.getAtributo("nome"), "Xadrez");
		assertEquals(jgTabuleiro.getAtributo("preco"), "10.0");
	}

	@Test
	public void testAtualizarAtributo() {
		jgTabuleiro.atualizarAtributo("nome", "XADREZ");
		assertEquals(jgTabuleiro.getNome(), "XADREZ");
		
		jgTabuleiro.atualizarAtributo("preco", "12.0");
		assertEquals(12.0, jgTabuleiro.getPreco(), 0.1);
	}

	

	@Test
	public void testStatusPecas() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals(jgTabuleiro.statusPecas(), "COM PECAS PERDIDAS");
		assertEquals(jgVazio.statusPecas(), "COMPLETO");
	}

	@Test
	public void testGetPecasPerdidas() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals(jgTabuleiro.getPecasPerdidas(), "rainha branca\n" + 
				 									 "rei preto\n");
	}

	@Test
	public void testEqualsObject() {
		JogoTabuleiro jgTest = new JogoTabuleiro("Xadrez", 0.15);
		assertTrue(jgTabuleiro.equals(jgTest));
	}

	@Test
	public void testToString() {
		jgTabuleiro.adicionarPecaPerdida("rainha branca");
		jgTabuleiro.adicionarPecaPerdida("rei preto");
		
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 10.0, Nao emprestado, COM PECAS PERDIDAS", 
					 "JOGO DE TABULEIRO: " + jgTabuleiro.getNome() + ", R$ " + jgTabuleiro.getPrecoString() +
					 ", " + jgTabuleiro.getStatusString() + ", " + jgTabuleiro.statusPecas());
		
		assertEquals("JOGO DE TABULEIRO: Only for empty tests, R$ 0.15, Nao emprestado, COMPLETO", 
				 "JOGO DE TABULEIRO: " + jgVazio.getNome() + ", R$ " + jgVazio.getPrecoString() +
				 ", " + jgVazio.getStatusString() + ", " + jgVazio.statusPecas());
	}

}
