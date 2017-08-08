package usuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario novo;
	
	@Before
	public void inicializa() {
		novo = new Usuario("Vinicius", "4002-8922", "vinicius@ccc.com");
		novo.cadastrarBlurayFilme("Animais Fantasticos", 49.99, 120, 2016, "AVENTURA", "QUATORZE_ANOS");
		novo.cadastrarBluraySerie("", 89.99, "Primeira temporada", 240, "QUATORZE_ANOS", "POLICIAL", 1);
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

	
	public void testGetTodosItens() {
		fail("Not yet implemented");
	}

	
	public void testGetItem() {
		fail("Not yet implemented");
	}

	
	public void testGetDetalhesItem() {
		fail("Not yet implemented");
	}

	
	public void testGetInfoUsuario() {
		fail("Not yet implemented");
	}

	
	public void testGetInfoItem() {
		fail("Not yet implemented");
	}

	
	public void testRemoverItem() {
		fail("Not yet implemented");
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
