package emprestimo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.JogoEletronico;
import usuarios.IdUsuario;
import usuarios.Usuario;

public class EmprestimoTest {

	private Emprestimo emprestimo;
	private Usuario dono, requerente;
	
	@Before
	public void inicializa(){
		dono = new Usuario("Bruno", "4002-8922", "brunoRPM@gmail.com");
		requerente = new Usuario("Calcio", "789-6543", "calcio@gmail.com");
		Item item = new JogoEletronico("DBX2", 150.64, "PC");
		emprestimo = new Emprestimo(dono, requerente, "22/01/2017", item, 7);
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
		assertEquals(0, emprestimo.getAtraso());
		
		emprestimo.devolucao("30/01/2017");
		assertEquals(1, emprestimo.getAtraso());
	}

	@Test
	public void testToString() {
		assertEquals("EMPRESTIMO - De: Bruno, Para: Calcio, DBX2, 22/01/2017, 7 dias, ENTREGA: Emprestimo em andamento", emprestimo.toString());
	}

}
