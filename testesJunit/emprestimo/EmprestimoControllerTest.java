package emprestimo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import usuarios.Usuario;

public class EmprestimoControllerTest {

	private EmprestimoController ec;
	Usuario dono = new Usuario("Samara", "1234-5615", "samararinoa@gmail.com");
	Usuario requerente = new Usuario("Alguem", "1698-532", "alguem_ai@gmail.com");
	List<Item> todosItens;
	
	@Before
	public void testEmprestimoController() {
		ec = new EmprestimoController();
		dono.cadastrarJogoTabuleiro("Xadrez", 10.0);
		dono.cadastrarEletronico("DBX2", 150.0, "PC");
		ec.registrarEmprestimo(dono, requerente, "DBX2", "28/08/2017", 1);
		todosItens = new ArrayList<>(dono.getTodosItens());
	}

	@Test
	public void testRegistrarEmprestimo() {
		ec.registrarEmprestimo(dono, requerente, "Xadrez", "13/05/2017", 5);
		
		assertEquals(2, ec.getEmprestimosSistema().size());
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
	public void testListarEmprestimosUsuarioEmprestando() {
		ec.registrarEmprestimo(dono, requerente, "Xadrez", "13/05/2017", 5);
		assertEquals("Emprestimos: EMPRESTIMO - De: Samara, Para: Alguem, DBX2, 28/08/2017, 1 dias, ENTREGA: Emprestimo em andamento|EMPRESTIMO - De: Samara, Para: Alguem, Xadrez, 13/05/2017, 5 dias, ENTREGA: Emprestimo em andamento|", ec.listarEmprestimosUsuarioEmprestando(dono));
	}

	@Test
	public void testListarEmprestimosUsuarioPegandoEmprestado() {
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: Samara, Para: Alguem, DBX2, 28/08/2017, 1 dias, ENTREGA: Emprestimo em andamento|", ec.listarEmprestimosUsuarioPegandoEmprestado(requerente));;
	}

	@Test
	public void testListarItensNaoEmprestados() {
		assertEquals("JOGO ELETRONICO: DBX2, R$ 150.0, Emprestado, PC|JOGO DE TABULEIRO: Xadrez, R$ 10.0, Nao emprestado, COMPLETO|", ec.listarItensNaoEmprestados(todosItens));;
	}

	@Test
	public void testListarItensEmprestados() {
		assertEquals("Dono do item: Samara, Nome do item emprestado: DBX2|", ec.listarItensEmprestados());;
	}

	@Test
	public void testListarEmprestimosItem() {
		assertEquals("Nenhum emprestimos associados ao item", ec.listarEmprestimosItem("Xadrez"));
	}

	@Test
	public void testListarTop10Itens() {
		assertEquals("1) 1 emprestimos - JOGO ELETRONICO: DBX2, R$ 150.0, Emprestado, PC|", ec.listarTop10Itens(todosItens));;
	}

}
