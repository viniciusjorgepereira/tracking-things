package usuarios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
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

	public void testCadastrarJogoTabuleiro() {
		
	}

	
	public void testAdicionarPecaPerdida() {
		fail("Not yet implemented");
	}

	
	public void testCadastrarBluRayFilme() {
		fail("Not yet implemented");
	}

	
	public void testCadastrarBluRayShow() {
		fail("Not yet implemented");
	}

	
	public void testCadastrarBluRaySerie() {
		fail("Not yet implemented");
	}

	
	public void testCadastrarBlurayTemporada() {
		fail("Not yet implemented");
	}


	public void testGetTodosItens() {
		fail("Not yet implemented");
	}


	public void testDetalhesItem() {
		fail("Not yet implemented");
	}


	public void testGetInfoItem() {
		fail("Not yet implemented");
	}


	public void testAtualizarItem() {
		fail("Not yet implemented");
	}


	public void testRegistrarEmprestimo() {
		fail("Not yet implemented");
	}


	public void testDevolverItem() {
		fail("Not yet implemented");
	}

}
