package itens;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ordenadores.OrdenadorDeItens;

public class InventarioTest {

	private OrdenadorDeItens inventario;
	private ArrayList<Item> itens;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	
	@Before
	public void inicializa() {
		inventario = new OrdenadorDeItens();
		itens = new ArrayList<>();
		item1 = new JogoEletronico("DBX2", 159.67, "PC");
		item2 = new JogoTabuleiro("Xadrez", 10.99);
		item3 = new Series("Mr.Robot", 98.56, 600, "Serie finalizada", "DOZE_ANOS", "EROTICO", 99);
		item4 = new Filmes("Sei la", 45.96, 240, "LIVRE", "ACAO", 2046);
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		inventario.adicionaItens(itens);
	}
	
	@Test
	public void testAdicionaItens() {
		itens.add(item4);
		inventario.adicionaItens(itens);
		
		assertEquals("JOGO ELETRONICO: DBX2, R$ 159.67, Nao emprestado, PC|"
				+ "JOGO DE TABULEIRO: Xadrez, R$ 10.99, Nao emprestado, COMPLETO|"
				+ "SERIE: Mr.Robot, R$ 98.56, Nao emprestado, 600 min, DOZE_ANOS, EROTICO, Temporada 99|"
				+ "FILME: Sei la, R$ 45.96, Nao emprestado, 240 min, LIVRE, ACAO, 2046|",
				inventario.listaItensString());
	}

	@Test
	public void testListarItensOrdenadosPorNome() {
		assertEquals("JOGO ELETRONICO: DBX2, R$ 159.67, Nao emprestado, PC|"
				+ "SERIE: Mr.Robot, R$ 98.56, Nao emprestado, 600 min, DOZE_ANOS, EROTICO, Temporada 99|"
				+ "JOGO DE TABULEIRO: Xadrez, R$ 10.99, Nao emprestado, COMPLETO|",
				inventario.listarItensOrdenadosPorNome());
	}

	@Test
	public void testListarItensOrdenadosPorValor() {
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 10.99, Nao emprestado, COMPLETO|"
				+ "SERIE: Mr.Robot, R$ 98.56, Nao emprestado, 600 min, DOZE_ANOS, EROTICO, Temporada 99|"
				+ "JOGO ELETRONICO: DBX2, R$ 159.67, Nao emprestado, PC|", inventario.listarItensOrdenadosPorValor());
	}

	@Test
	public void testListaItensString() {
		assertEquals("JOGO ELETRONICO: DBX2, R$ 159.67, Nao emprestado, PC|"
				+ "JOGO DE TABULEIRO: Xadrez, R$ 10.99, Nao emprestado, COMPLETO|"
				+ "SERIE: Mr.Robot, R$ 98.56, Nao emprestado, 600 min, DOZE_ANOS, EROTICO, Temporada 99|", inventario.listaItensString());
	}

}
