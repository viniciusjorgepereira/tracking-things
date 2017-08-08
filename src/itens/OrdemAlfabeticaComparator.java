package itens;

import java.util.Comparator;

public class OrdemAlfabeticaComparator implements Comparator<Item> {

	@Override
	public int compare(Item iten1, Item iten2) {
		return iten1.nome.compareTo(iten2.nome);
	}
}
