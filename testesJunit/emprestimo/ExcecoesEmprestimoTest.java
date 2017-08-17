package emprestimo;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.JogoEletronico;
import usuarios.IdUsuario;

public class ExcecoesEmprestimoTest {
	ExcecoesEmprestimo excecaoEmprestimo;
	Emprestimo emprestimo;
	IdUsuario idDono, idRequerente;
	Item item;
	
	
	@Before
	public void inicializa() {
		idDono = new IdUsuario("Bruno", "4987984");
		idRequerente = new IdUsuario("Calcio", "97987979");
		item = new JogoEletronico("Mario", 205.75, "NINTENDO_3DS");
		excecaoEmprestimo = new ExcecoesEmprestimo();
		emprestimo = new Emprestimo(idDono, idRequerente, "12/05/2017", item, 7);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEmprestimoInvalido() {
		excecaoEmprestimo.emprestimoInvalido(null);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testPeriodoInvalido() {
		excecaoEmprestimo.periodoInvalido(0, 1);
	}
	
	@Test
	public void testEmprestimoValido() {
		excecaoEmprestimo.emprestimoInvalido(emprestimo);
	}

	@Test
	public void testPeriodoValido() {
		excecaoEmprestimo.periodoInvalido(7, 7);
	}
}
