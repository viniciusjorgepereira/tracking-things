package usuarios;

import java.util.Comparator;

public class OrdemAlfabeticaComparator implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
