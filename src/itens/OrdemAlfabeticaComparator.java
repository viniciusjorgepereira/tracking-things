package itens;

import java.util.Comparator;

public class OrdemAlfabeticaComparator implements Comparator<Itens> {

	@Override
	public int compare(Itens iten1, Itens iten2) {
		return iten1.nome.compareTo(iten2.nome);
	}

}
