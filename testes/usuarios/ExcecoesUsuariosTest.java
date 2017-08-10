package usuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExcecoesUsuariosTest {

	//*Atributos
	private ExcecoesUsuario excecoes;
	
	//*Inicializacao
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
