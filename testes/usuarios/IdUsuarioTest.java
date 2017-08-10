package usuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdUsuarioTest {

	private IdUsuario id;
	private IdUsuario id2;
	
	@Before
	public void inicializar() {
		id = new IdUsuario("Jorge", "2222-2222");
		id2 = new IdUsuario("Jorge", "2222-2222");
	}
	
	@Test
	public void testHashCode1() {
		assertEquals(1892427139, id.hashCode());
	}
	
	@Test
	public void testHashCode2() {
		assertEquals(1892427139, id2.hashCode());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, id.equals(id2));
	}
}
