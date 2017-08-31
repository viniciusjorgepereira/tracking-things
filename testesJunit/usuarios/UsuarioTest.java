package usuarios;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.Series;

public class UsuarioTest {

	private Usuario novoUsuario;

	@Before
	public void inicializa() {
		novoUsuario = new Usuario("Vinicius", "4002-8922", "vinicius@ccc.com");
		
		novoUsuario.cadastrarBlurayFilme("Animais Fantasticos", 49.99, 120, 2016, "AVENTURA", "QUATORZE_ANOS");
		novoUsuario.cadastrarBluraySerie("The Flash", 89.99, "Primeira temporada", 240, "QUATORZE_ANOS", "POLICIAL", 2);
		novoUsuario.cadastrarBlurayShow("James Bay Ao Vivo", 29.99, 138, 14, "James Bay", "livre");
		novoUsuario.cadastrarBlurayTemporada("The Flash", 240);
		
		novoUsuario.cadastrarEletronico("GTA V", 89.99, "XBOX_ONE");
		novoUsuario.cadastrarEletronico("Harry Potter Lego Years 1-4", 39.99, "PS4");
		
		novoUsuario.cadastrarJogoTabuleiro("Monopoly", 49.99);
		novoUsuario.cadastrarJogoTabuleiro("Xadrez de Bruxo", 99.99);
	}

	@Test
	public void testGetNome() {
		assertEquals("Vinicius", novoUsuario.getNome());
	}

	@Test
	public void testSetNome() {
		novoUsuario.setNome("Jorge");
		assertEquals("Jorge", novoUsuario.getNome());
	}

	@Test
	public void testGetEmail() {
		assertEquals("vinicius@ccc.com", novoUsuario.getEmail());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("4002-8922", novoUsuario.getTelefone());
	}

	@Test
	public void testGetItem() {
		Item teste = new Series("The Flash", 59.90, 380, "My name is Barry Allen and i'm the fastest man alive", "quatorze_anos", "policial", 2);
		assertEquals(teste, novoUsuario.getItem("The Flash"));
	}

	@Test
	public void testGetDetalhesItem() {
		assertEquals("SERIE: The Flash, R$ 89.99, Nao emprestado, 240 min, QUATORZE_ANOS, POLICIAL, Temporada 2", novoUsuario.getDetalhesItem("The Flash"));
	}

	@Test
	public void testGetInfoUsuario() {
		assertEquals("vinicius@ccc.com", novoUsuario.getInfoUsuario("Email"));
	}
	
	@Test
	public void testGetInfoUsuario2() {
		assertEquals("4002-8922", novoUsuario.getInfoUsuario("telefone"));
	}
	
	@Test
	public void testGetInfoUsuario3() {
		assertEquals("Vinicius", novoUsuario.getInfoUsuario("nome"));
	}
	
	@Test
	public void testGetInfoItem() {
		assertEquals("89.99", novoUsuario.getInfoItem("The Flash", "preco"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRemoverItem() {
		novoUsuario.removerItem("The Flash");
		novoUsuario.getItem("The Flash");
	}

	@Test
	public void testAtualizarDadosUsuario() {
		novoUsuario.atualizarDadosUsuario("email", "vinicius@ccc.ufcg.com");
		assertEquals("vinicius@ccc.ufcg.com", novoUsuario.getEmail());
	}

	@Test
	public void testAtualizarDadosItens() {
		novoUsuario.atualizarDadosItens("Animais Fantasticos", "preco", "39.99");
		assertEquals("39.99", novoUsuario.getInfoItem("Animais Fantasticos", "preco"));
	}

	@Test
	public void testAdicionarPecaPerdida() {
		novoUsuario.adicionarPecaPerdida("Xadrez de Bruxo", "Rainha ma");
		assertEquals("JOGO DE TABULEIRO: Xadrez de Bruxo, R$ 99.99, Nao emprestado, COM PECAS PERDIDAS", novoUsuario.getDetalhesItem("Xadrez de Bruxo"));
	}

	@Test
	public void testToString() {
		assertEquals("Vinicius, vinicius@ccc.com, 4002-8922", novoUsuario.toString());
	}
}
