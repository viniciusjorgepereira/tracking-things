package itens;

import java.util.Comparator;

public class OrdenaPorValorComparator implements Comparator<Item> {

	@Override
	public int compare(Item iten1, Item iten2) {
		return (int) ((iten1.preco - iten2.preco) * 100);
	}
}
