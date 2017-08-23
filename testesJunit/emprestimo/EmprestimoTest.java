package emprestimo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.JogoEletronico;
import usuarios.IdUsuario;

public class EmprestimoTest {

	private Emprestimo emprestimo;
	private IdUsuario idDono, idRequerente;
	
	@Before
	public void inicializa(){
		idDono = new IdUsuario("Bruno", "4002-8922");
		idRequerente = new IdUsuario("Calcio", "789-6543");
		Item item = new JogoEletronico("DBX2", 150.64, "PC");
	}
	
	@Test
	public void testGetDataEmprestimo() {
		assertEquals("22/01/2017", emprestimo.getDataEmprestimo());
	}

	@Test
	public void testDevolucao() {
		emprestimo.devolucao("10/09/2017");
		assertEquals("EMPRESTIMO - De: Bruno, Para: Calcio, DBX2, 22/01/2017, 7 dias, ENTREGA: 10/09/2017", emprestimo.toString());
	}

	@Test
	public void testGetAtraso() {
		emprestimo.devolucao("25/01/2017");
		assertEquals(3, emprestimo.getAtraso());
	}

	@Test
	public void testToString() {
		assertEquals("EMPRESTIMO - De: Bruno, Para: Calcio, DBX2, 22/01/2017, 7 dias, ENTREGA: Emprestimo em andamento", emprestimo.toString());
	}

}
