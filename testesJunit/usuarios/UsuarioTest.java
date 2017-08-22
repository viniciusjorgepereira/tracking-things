package usuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import emprestimo.Emprestimo;
import itens.Item;
import itens.Series;

public class UsuarioTest {

	private Usuario novo;
	private Usuario outroUsuario;
	private IdUsuario novoId;
	private IdUsuario outroUsuarioId;

	@Before
	public void inicializa() {
		novo = new Usuario("Vinicius", "4002-8922", "vinicius@ccc.com");
		outroUsuario = new Usuario("Jorge", "3321-3321", "jorge@ccc.ufcg.com");
		
		novoId = new IdUsuario(novo.getNome(), novo.getTelefone());
		outroUsuarioId = new IdUsuario(outroUsuario.getNome(), outroUsuario.getTelefone());
		
		novo.cadastrarBlurayFilme("Animais Fantasticos", 49.99, 120, 2016, "AVENTURA", "QUATORZE_ANOS");
		novo.cadastrarBluraySerie("The Flash", 89.99, "Primeira temporada", 240, "QUATORZE_ANOS", "POLICIAL", 2);
		novo.cadastrarBlurayShow("James Bay Ao Vivo", 29.99, 138, 14, "James Bay", "livre");
		novo.cadastrarBlurayTemporada("The Flash", 240);
		
		novo.cadastrarEletronico("GTA V", 89.99, "XBOX_ONE");
		novo.cadastrarEletronico("Harry Potter Lego Years 1-4", 39.99, "PS4");
		
		novo.cadastrarJogoTabuleiro("Monopoly", 49.99);
		novo.cadastrarJogoTabuleiro("Xadrez de Bruxo", 99.99);
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
		Item teste = new Series("The Flash", 59.90, 380, "My name is Barry Allen and i'm the fastest man alive", "quatorze_anos", "policial", 2);
		assertEquals(teste, novo.getItem("The Flash"));
	}

	@Test
	public void testGetDetalhesItem() {
		assertEquals("SERIE: The Flash, R$ 89.99, Nao emprestado, 240 min, QUATORZE_ANOS, POLICIAL, Temporada 2", novo.getDetalhesItem("The Flash"));
	}

	@Test
	public void testGetInfoUsuario() {
		assertEquals("vinicius@ccc.com", novo.getInfoUsuario("Email"));
	}
	
	@Test
	public void testGetInfoUsuario2() {
		assertEquals("4002-8922", novo.getInfoUsuario("telefone"));
	}
	
	@Test
	public void testGetInfoUsuario3() {
		assertEquals("Vinicius", novo.getInfoUsuario("nome"));
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

	@Test
	public void testAtualizarDadosUsuario() {
		novo.atualizarDadosUsuario("email", "vinicius@ccc.ufcg.com");
		assertEquals("vinicius@ccc.ufcg.com", novo.getEmail());
	}

	@Test
	public void testAtualizarDadosItens() {
		novo.atualizarDadosItens("Animais Fantasticos", "preco", "39.99");
		assertEquals("39.99", novo.getInfoItem("Animais Fantasticos", "preco"));
	}

	@Test
	public void testAdicionarPecaPerdida() {
		novo.adicionarPecaPerdida("Xadrez de Bruxo", "Rainha ma");
		assertEquals("JOGO DE TABULEIRO: Xadrez de Bruxo, R$ 99.99, Nao emprestado, COM PECAS PERDIDAS", novo.getDetalhesItem("Xadrez de Bruxo"));
	}

	@Test
	public void testCriarEmprestimo() {
		novo.criarEmprestimo(novoId, outroUsuarioId, "Xadrez de Bruxo", "08/08/2017", 5);
		assertEquals("JOGO DE TABULEIRO: Xadrez de Bruxo, R$ 99.99, Emprestado, COMPLETO", novo.getDetalhesItem("Xadrez de Bruxo"));
	}

	@Test
	public void testRegistrarEmprestimo() {
		Emprestimo emprestimo = novo.criarEmprestimo(novoId, outroUsuarioId, "Xadrez de Bruxo", "08/08/2017", 5);
		outroUsuario.registrarEmprestimo(emprestimo);
	}

	@Test
	public void testEncontraEmprestimo() {
		Emprestimo emprestimo = novo.criarEmprestimo(novoId, outroUsuarioId, "Monopoly", "03/08/2017", 6);
		outroUsuario.registrarEmprestimo(emprestimo);
		assertEquals(emprestimo, novo.encontraEmprestimo(novoId, outroUsuarioId, "Monopoly", "03/08/2017"));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testDevolverItem() {
		novo.devolverItem(novoId, outroUsuarioId, "Monopoly 2", "03/08/2017", "05/07/2017");
	}
	
	@Test
	public void testDevolverItem2() {
		Emprestimo emprestimo = novo.criarEmprestimo(novoId, outroUsuarioId, "Monopoly", "03/08/2017", 6);
		outroUsuario.registrarEmprestimo(emprestimo);
		novo.devolverItem(novoId, outroUsuarioId, "Monopoly", "03/08/2017", "05/07/2017");
	}

	@Test
	public void testToString() {
		assertEquals("Vinicius, vinicius@ccc.com, 4002-8922", novo.toString());
	}
}
