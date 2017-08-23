/**
 * Classe que campara nome dos Usuarios
 * */

package usuarios;

import java.util.Comparator;

public class OrdemAlfabeticaComparator implements Comparator<Usuario>{

	/**
	 * Compara nome de dois usuarios
	 * 
	 * @param o1 Usuario para comparacao
	 * @param o2 Usuario para comparacao
	 * 
	 * @return O nome com a menor letra
	 * */
	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
