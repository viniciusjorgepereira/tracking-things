package principal;

import org.junit.Before;
import org.junit.Test;

public class ExcecoesEntradasTest {

	private ExcecoesEntradas excecoes;
	
	@Before
	public void inicializar() {
		excecoes = new ExcecoesEntradas();
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos1() {
		excecoes.dadosInvalidos("", "4002-8922");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos2() {
		excecoes.dadosInvalidos("Vinicius", "");
	}

	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos3() {
		excecoes.dadosInvalidos("     ", "4002-8922");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos4() {
		excecoes.dadosInvalidos("Vinicius", "    ");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos5() {
		excecoes.dadosInvalidos(null, "1234");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos6() {
		excecoes.dadosInvalidos("Vinicius", null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos7() {
		excecoes.dadosInvalidos("Vinicius", "1234-1234", "");
	}

	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos8() {
		excecoes.dadosInvalidos("Jorge", "1234-1234", "    ");
	} 
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos9() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos10() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "", "Mensagem do erro");
	}	

	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos11() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "   ", "Mensagem do erro");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos12() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", null, "Mensagem do erro");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos13() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", "", "Erro ali", "Errou aqui");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos14() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", "   ", "Erro ali", "Errou aqui");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos15() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", null, "Erro ali", "Errou aqui");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNumeroInvalido() {
		excecoes.numeroInvalido("Mensagem de erro", -1);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos1() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", "");
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos2() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", "    ");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos3() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testValorInvalido() {
		excecoes.valorInvalido("preco", "-50");
	}

}
