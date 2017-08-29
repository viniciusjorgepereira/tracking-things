package emprestimo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.JogoTabuleiro;
import usuarios.Usuario;

public class EmprestimoControllerTest {

	private EmprestimoController ec;
	Usuario dono = new Usuario("Samara", "1234-5615", "samararinoa@gmail.com");
	Usuario requerente = new Usuario("Alguem", "1698-532", "alguem_ai@gmail.com");
	
	@Before
	public void testEmprestimoController() {
		ec = new EmprestimoController();
		dono.cadastrarJogoTabuleiro("Xadrez", 10.0);
	}

	@Test
	public void testRegistrarEmprestimo() {
		ec.registrarEmprestimo(dono, requerente, "Xadrez", "13/05/2017", 5);
		
		assertEquals(1, ec.getEmprestimosSistema().size());
	}

	@Test
	public void testDevolverItem() {
		ec.registrarEmprestimo(dono, requerente, "Xadrez", "13/05/2017", 5);
		ec.devolverItem(dono, requerente, "Xadrez", "13/05/2017", "20/05/2017");
		assertEquals("Emprestimos associados ao item: EMPRESTIMO - De: Samara, Para: Alguem, Xadrez, 13/05/2017, 5 dias, ENTREGA: 20/05/2017|", ec.listarEmprestimosItem("Xadrez"));
	}

	@Test
	public void testPunicaoAtraso() {
		ec.registrarEmprestimo(dono, requerente, "Xadrez", "13/05/2017", 5);
		ec.devolverItem(dono, requerente, "Xadrez", "13/05/2017", "20/05/2017");
		
		assertEquals(-0.2, requerente.getReputacao(), 2);
		
		ec.devolverItem(dono, requerente, "Xadrez", "13/05/2017", "14/05/2017");
		
		assertEquals(0.5, requerente.getReputacao(), 2);
	}

	@Test
	public void testPermissaoEmprestimo() {
		ec.permissaoEmprestimo(requerente, 5, dono.getItem("Xadrez"));
	}

	@Test
	public void testCriarEmprestimo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarEmprestimosUsuarioEmprestando() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarEmprestimosUsuarioPegandoEmprestado() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarItensNaoEmprestados() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarItensEmprestados() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarEmprestimosItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarTop10Itens() {
		fail("Not yet implemented");
	}

}
