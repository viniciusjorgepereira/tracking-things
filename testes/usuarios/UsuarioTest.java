package usuarios;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.Series;

public class UsuarioTest {

	private Usuario novo;

	@Before
	public void inicializa() {
		novo = new Usuario("Vinicius", "4002-8922", "vinicius@ccc.com");
		novo.cadastrarBlurayFilme("Animais Fantasticos", 49.99, 120, 2016, "AVENTURA", "QUATORZE_ANOS");
		novo.cadastrarBluraySerie("The Flash", 89.99, "Primeira temporada", 240, "QUATORZE_ANOS", "POLICIAL", 1);
	}

	@Test
	public void testGetNome() {
		assertEquals("Vinicius", novo.getNome());
	}

	@Test
	public void testSetNome() {
		novo.setNome("Jorge");
		assertEquals("Jorge", novo.getNome());
	}

	@Test
	public void testGetEmail() {
		assertEquals("vinicius@ccc.com", novo.getEmail());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("4002-8922", novo.getTelefone());
	}

	@Test
	public void testGetItem() {
		Item teste = new Series("The Flash", 59.90, 380, "My name is Barry Allen and i'm the fastest man alive", "quatorze_anos", "policial", 1);
		assertEquals(teste, novo.getItem("The Flash"));
	}

	@Test
	public void testGetDetalhesItem() {
		assertEquals("SERIE: The Flash, R$ 89.99, Nao emprestado, 240 min, QUATORZE_ANOS, POLICIAL, Temporada 1", novo.getDetalhesItem("The Flash"));
	}

	@Test
	public void testGetInfoUsuario() {
		assertEquals("vinicius@ccc.com", novo.getInfoUsuario("Email"));
	}
	
	@Test
	public void testGetInfoItem() {
		assertEquals("89.99", novo.getInfoItem("The Flash", "preco"));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testRemoverItem() {
		novo.removerItem("The Flash");
		novo.getItem("The Flash");
	}

	public void testAtualizarDadosUsuario() {
		fail("Not yet implemented");
	}

	public void testAtualizarDadosItens() {
		fail("Not yet implemented");
	}

	public void testCadastrarEletronico() {
		fail("Not yet implemented");
	}

	public void testCadastrarJogoTabuleiro() {
		fail("Not yet implemented");
	}

	public void testAdicionarPecaPerdida() {
		fail("Not yet implemented");
	}

	public void testCadastrarBlurayFilme() {
		fail("Not yet implemented");
	}

	public void testCadastrarBluraySerie() {
		fail("Not yet implemented");
	}

	public void testCadastrarBlurayTemporada() {
		fail("Not yet implemented");
	}

	public void testCadastrarBlurayShow() {
		fail("Not yet implemented");
	}

	public void testEmprestar() {
		fail("Not yet implemented");
	}

	public void testReceberEmprestimo() {
		fail("Not yet implemented");
	}

	public void testEncontraEmprestimo() {
		fail("Not yet implemented");
	}

	public void testDevolverItem() {
		fail("Not yet implemented");
	}

	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

}
