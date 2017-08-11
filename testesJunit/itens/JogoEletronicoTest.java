package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoEletronicoTest {
	private JogoEletronico jgEletronico;
	private JogoEletronico jgEletronico2;

	@Before
	public void testJogoEletronico() {
		jgEletronico = new JogoEletronico("Final Fantasy XV", 150.0, "ps4");
		jgEletronico2 = new JogoEletronico("Just Dance", 65.0, "xbox_one");
	}
	
	@Test
	public void testGetAtributo() {
		assertEquals("Final Fantasy XV", jgEletronico.getAtributo("nome"));
		assertEquals("65.0", jgEletronico2.getAtributo("preco"));
	}

	@Test
	public void testAtualizarAtributo() {
		jgEletronico.atualizarAtributo("nome", "FINAL FANTASY XV");
		assertEquals("FINAL FANTASY XV", jgEletronico.getAtributo("nome"));
		
		jgEletronico2.atualizarAtributo("preco", "75.0");
		assertEquals("75.0", jgEletronico2.getAtributo("preco"));
		
		jgEletronico2.atualizarAtributo("plataforma", "pc");
		assertEquals("PC", jgEletronico2.getAtributo("plataforma"));
	}

	@Test
	public void testEqualsObject() {
		JogoEletronico jgTest = new JogoEletronico("Final Fantasy XV", 85.0, "pc");
		assertFalse(jgEletronico.equals(jgTest));
		
		jgTest.atualizarAtributo("plataforma", "PS4");
		
		assertTrue(jgEletronico.equals(jgTest));
	}

	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: Final Fantasy XV, R$ 150.0, Nao emprestado, PS4", jgEletronico.toString());
		assertEquals("JOGO ELETRONICO: Just Dance, R$ 65.0, Nao emprestado, XBOX_ONE", jgEletronico2.toString());
	}

}
