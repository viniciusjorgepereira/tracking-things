package usuarios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import itens.Filmes;
import itens.Item;

public class UsuarioControllerTest {

	private UsuarioController controle;
	
	@Before
	public void inicializar() {
		controle = new UsuarioController();
		controle.cadastrarUsuario("Vinicius", "1234-1234", "oi@oi.com");
		controle.cadastrarBluRayFilme("Vinicius", "1234-1234", "Harry Potter", 19.99, 120, "aventura", "dez_anos", 2010);
	}

	@Test
	public void testCadastrarUsuario() {
		controle.cadastrarUsuario("Vinicius", "1234-1235", "oi@oi.com");
		assertEquals("oi@oi.com", controle.getInfoUsuario("Vinicius", "1234-1235", "email"));
	}

	@Test
	public void testGetInfoUsuario() {
		controle.cadastrarUsuario("Vinicius", "1234-1236", "oi@oi.com");
		assertEquals("1234-1236", controle.getInfoUsuario("Vinicius", "1234-1236", "telefone"));
	}

	@Test
	public void testPesquisaId() {
		IdUsuario id = new IdUsuario("Vinicius", "1234-1234");
		controle.pesquisaId("Vinicius", "1234-1234");
		assertEquals(id, controle.pesquisaId("Vinicius", "1234-1234"));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testRemoverUsuario() {
		controle.removerUsuario("Vinicius", "1234-1234");
		controle.getInfoUsuario("Vinicius", "1234-1234", "email");
	}

	@Test
	public void testRemoverItem() {
		controle.removerItem("Vinicius", "1234-1234", "Harry Potter");
		List<Item> lista = new ArrayList<>();
		assertEquals(lista, controle.getTodosItens());
	}

	@Test
	public void testPesquisarUsuario() {
		assertEquals("Vinicius, oi@oi.com, 1234-1234", controle.pesquisarUsuario("Vinicius", "1234-1234"));
	}

	@Test
	public void testAtualizarUsuario() {
		controle.atualizarUsuario("Vinicius", "1234-1234", "email", "oi@ufcg.com");
		assertEquals("oi@ufcg.com", controle.getInfoUsuario("Vinicius", "1234-1234", "email"));
	}

	@Test
	public void testCadastrarEletronico() {
		controle.cadastrarEletronico("Vinicius", "1234-1234", "GTA", 49.99, "ps4");
		assertEquals("PS4", controle.getInfoItem("Vinicius", "1234-1234", "GTA", "plataforma"));
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		controle.cadastrarJogoTabuleiro("Vinicius", "1234-1234", "Lego", 99.99);
		assertEquals("Lego", controle.getInfoItem("Vinicius", "1234-1234", "Lego", "nome"));
	}

	@Test
	public void testAdicionarPecaPerdida() {
		controle.cadastrarJogoTabuleiro("Vinicius", "1234-1234", "Monopoly", 99.99);
		controle.adicionarPecaPerdida("Vinicius", "1234-1234", "Monopoly", "Dado");
		assertEquals("JOGO DE TABULEIRO: Monopoly, R$ 99.99, Nao emprestado, COM PECAS PERDIDAS", controle.detalhesItem("Vinicius", "1234-1234", "Monopoly"));
	}

	@Test
	public void testCadastrarBluRayFilme() {
		controle.cadastrarBluRayFilme("Vinicius", "1234-1234", "Animais Fantasticos", 39.99, 130, "aventura", "dez_anos", 2016);
		assertEquals("AVENTURA", controle.getInfoItem("Vinicius", "1234-1234", "Animais Fantasticos", "genero"));
	}

	@Test
	public void testCadastrarBluRayShow() {
		controle.cadastrarBluRayShow("Vinicius", "1234-1234", "JB Ao Vivo", 29.90, 115, 12, "James Bay", "doze_anos");
		assertEquals("James Bay", controle.getInfoItem("Vinicius", "1234-1234", "JB Ao Vivo", "artista"));
	}

	@Test
	public void testCadastrarBluRaySerie() {
		controle.cadastrarBluRaySerie("Vinicius", "1234-1234", "The Good Wife", 49.99, "Mr Florick quebrou com a empresa toda", 340, "quatorze_anos", "drama", 7);
		assertEquals("SERIE: The Good Wife, R$ 49.99, Nao emprestado, 340 min, QUATORZE_ANOS, DRAMA, Temporada 7", controle.detalhesItem("Vinicius", "1234-1234", "The Good Wife"));
	}

	@Test
	public void testCadastrarBlurayTemporada() {
		controle.cadastrarBluRaySerie("Vinicius", "1234-1234", "The Good Wife", 49.99, "Mr Florick quebrou com a empresa toda", 340, "quatorze_anos", "drama", 7);
		controle.cadastrarBlurayTemporada("Vinicius", "1234-1234", "The Good Wife", 60);
		assertEquals("1", controle.getInfoItem("Vinicius", "1234-1234", "The Good Wife", "episodios"));
	}

	@Test
	public void testGetTodosItens() {
		List<Item> teste = new ArrayList<>();
		teste.add(new Filmes("Harry Potter", 19.99, 120, "dez_anos", "aventura", 2010));
		assertEquals(teste, controle.getTodosItens());		
	}

	@Test
	public void testDetalhesItem() {
		assertEquals("FILME: Harry Potter, R$ 19.99, Nao emprestado, 120 min, DEZ_ANOS, AVENTURA, 2010", controle.detalhesItem("Vinicius", "1234-1234", "Harry Potter"));
	}

	@Test
	public void testGetInfoItem() {
		assertEquals("120 min", controle.getInfoItem("Vinicius", "1234-1234", "Harry Potter", "duracao"));
	}

	@Test
	public void testAtualizarItem() {
		controle.atualizarItem("Vinicius", "1234-1234", "Harry Potter", "preco", "29.99");
		assertEquals("29.99", controle.getInfoItem("Vinicius", "1234-1234", "Harry Potter", "preco"));
	}

	@Test
	public void testRegistrarEmprestimo() {
		controle.cadastrarUsuario("Jorge", "12-12", "teste@teste.com");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Jorge", "12-12", "Harry Potter", "10/08/2017", 5);
		assertEquals("FILME: Harry Potter, R$ 19.99, Emprestado, 120 min, DEZ_ANOS, AVENTURA, 2010", controle.detalhesItem("Vinicius", "1234-1234", "Harry Potter"));	
	}

	@Test
	public void testDevolverItem() {
		controle.cadastrarUsuario("Jorge", "12-12", "teste@teste.com");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Jorge", "12-12", "Harry Potter", "10/08/2017", 5);
		assertEquals("Emprestado", controle.getInfoItem("Vinicius", "1234-1234", "Harry Potter", "emprestimo"));		
		controle.devolverItem("Vinicius", "1234-1234", "Jorge", "12-12", "Harry Potter", "10/08/2017", "11/08/2017");
		assertEquals("Nao emprestado", controle.getInfoItem("Vinicius", "1234-1234", "Harry Potter", "emprestimo"));		
	}
	
	@Test
	public void testListarCaloteiros() {
		controle.cadastrarUsuario("Jorge", "123-123", "a@b.c");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", 1);
		controle.devolverItem("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", "22/08/2017");
		assertEquals("Lista de usuarios com reputacao negativa: Jorge, a@b.c, 123-123|", controle.listarCaloteiros());
	}
	
	@Test
	public void testListarTop10Melhores() {
		controle.cadastrarUsuario("Jorge", "123-123", "a@b.c");
		assertEquals("1: Vinicius - Reputacao: 1,00|2: Jorge - Reputacao: 0,00|", controle.listarTop10MelhoresUsuarios());
	}
	
	@Test
	public void testListarTop10Piores() {
		controle.cadastrarBluRaySerie("Vinicius", "1234-1234", "The Flash", 99.99, "The Fastest man alive", 360, "DEz_Anos", "Outro", 2);
		controle.cadastrarUsuario("Jorge", "123-123", "a@b.c");
		controle.cadastrarUsuario("Silva", "1212-1212", "b@c.d");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", 1);
		controle.devolverItem("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", "22/08/2017");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Silva", "1212-1212", "The Flash", "15/08/2017", 2);
		controle.devolverItem("Vinicius", "1234-1234", "Silva", "1212-1212", "The Flash", "15/08/2017", "23/08/2017");
		assertEquals("1: Silva - Reputacao: -6,00|2: Jorge - Reputacao: -2,20|3: Vinicius - Reputacao: 18,00|", controle.listarTop10PioresUsuarios());		
	}
	
	@Test
	public void testListarEmprestimosUsuarioEmprestando() {
		controle.cadastrarUsuario("Jorge", "123-123", "a@b.c");
		controle.registrarEmprestimo("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", 1);
		controle.devolverItem("Vinicius", "1234-1234", "Jorge", "123-123", "Harry Potter", "10/08/2017", "22/08/2017");
		assertEquals("Emprestimos: EMPRESTIMO - De: Vinicius, Para: Jorge, Harry Potter, 10/08/2017, 1 dias, ENTREGA: 22/08/2017|", controle.listarEmprestimosUsuarioEmprestando("Vinicius", "1234-1234"));
	}
}
