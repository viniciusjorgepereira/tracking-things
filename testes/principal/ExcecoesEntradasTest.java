package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExcecoesEntradasTest {

	private ExcecoesEntradas excecoes;
	
	@Before
	public void inicializar() {
		excecoes = new ExcecoesEntradas();
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: nome vazio
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos1() {
		excecoes.dadosInvalidos("", "4002-8922");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: telefone vazio
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos2() {
		excecoes.dadosInvalidos("Vinicius", "");
	}

	/**
	 * Testa a excecao quando o parametro e invalido: nome com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos3() {
		excecoes.dadosInvalidos("     ", "4002-8922");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: telefone com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos4() {
		excecoes.dadosInvalidos("Vinicius", "    ");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: nome null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos5() {
		excecoes.dadosInvalidos(null, "1234");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: telefone null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos6() {
		excecoes.dadosInvalidos("Vinicius", null);
	}
	
	
	/**
	 * Testa a excecao quando o parametro e invalido: email vazio
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos7() {
		excecoes.dadosInvalidos("Vinicius", "1234-1234", "");
	}

	/**
	 * Testa a excecao quando o parametro e invalido: email com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos8() {
		excecoes.dadosInvalidos("Jorge", "1234-1234", "    ");
	} 
	
	/**
	 * Testa a excecao quando o parametro e invalido: email null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos9() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", null);
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: entrada vazia
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos10() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "", "Mensagem do erro");
	}	

	/**
	 * Testa a excecao quando o parametro e invalido: entrada com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos11() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "   ", "Mensagem do erro");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: entrada null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos12() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", null, "Mensagem do erro");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: entrada2 vazia
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos13() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", "", "Erro ali", "Errou aqui");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: entrada2 com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos14() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", "   ", "Erro ali", "Errou aqui");
	}
	
	/**
	 * Testa a excecao quando o parametro e invalido: entrada2 null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testDadosInvalidos15() {
		excecoes.dadosInvalidos("Jorge", "4002-8922", "entrada1", null, "Erro ali", "Errou aqui");
	}
	
	/**
	 * Testa a excecao quando o numero e invalido: numero negativo
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testNumeroInvalido() {
		excecoes.numeroInvalido("Mensagem de erro", -1);
	}

	/**
	 * Testa a excecao quando uma entrada passada e invalida: entrada vazia
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos1() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", "");
	}

	/**
	 * Testa a excecao quando uma entrada passada e invalida: entrada com espacos
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos2() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", "    ");
	}
	
	/**
	 * Testa a excecao quando uma entrada passada e invalida: entrada null
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testOutrosDadosInvalidos3() {
		excecoes.outrosDadosInvalidos("Mensagem de erro", null);
	}
	
	/**
	 * Testa a excecao quando o valor a ser passado e invalido: valor negativo
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testValorInvalido() {
		excecoes.valorInvalido("preco", "-50");
	}

}
