package usuarios;

import org.junit.Before;
import org.junit.Test;

public class ExcecoesUsuariosTest {

	private ExcecoesUsuario excecoes;
	
	@Before
	public void inicializar() {
		excecoes = new ExcecoesUsuario();
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUsuarioInvalido() {
		excecoes.usuarioInvalido(false);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUsuarioJaCadastrado() {
		excecoes.usuarioJaCadastrado(true);
	}
}
