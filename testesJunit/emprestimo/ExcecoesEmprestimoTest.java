package emprestimo;

import org.junit.Before;
import org.junit.Test;

import itens.Item;
import itens.JogoEletronico;
import usuarios.IdUsuario;
import usuarios.Usuario;

public class ExcecoesEmprestimoTest {
	private ExcecoesEmprestimo excecaoEmprestimo;
	private Emprestimo emprestimo;
	private Usuario dono, requerente;
	private Item item;
	
	
	@Before
	public void inicializa() {
		dono = new Usuario("Bruno", "4987984", "bruno@gmail.com");
		requerente = new Usuario("Calcio", "97987979", "calcio@gmail.com");
		item = new JogoEletronico("Mario", 205.75, "NINTENDO_3DS");
		emprestimo = new Emprestimo(dono, requerente, "14/09/2017", item, 7);
		excecaoEmprestimo = new ExcecoesEmprestimo();
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
