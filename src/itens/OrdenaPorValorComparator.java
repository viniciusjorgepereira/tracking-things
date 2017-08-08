package itens;

import java.util.Comparator;

public class OrdenaPorValorComparator implements Comparator<Itens> {

	@Override
	public int compare(Itens iten1, Itens iten2) {
		return (int) ((iten1.preco - iten2.preco) * 100);
	}
}
