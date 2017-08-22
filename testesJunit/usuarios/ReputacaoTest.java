package usuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReputacaoTest {
	private Reputacao reputacaoTest;
	
	@Before
	public void testReputacao() {
		reputacaoTest = new Reputacao(15.0);
	}

	@Test
	public void testAcrescimoCinco() {
		reputacaoTest.acrescimoCinco(15.0);
		assertEquals(reputacaoTest.getReputacao(), 15.75, 2);
	}

	@Test
	public void testAcrescimoDez() {
		reputacaoTest.acrescimoDez(10.0);;
		assertEquals(reputacaoTest.getReputacao(), 15.1, 1);
	}

	@Test
	public void testDiminuirReputacao() {
		reputacaoTest.diminuirReputacao(7, 10.0);
		assertEquals(reputacaoTest.getReputacao(), 14.3, 1);
	}

}
