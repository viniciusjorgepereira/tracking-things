/**
 * Classe que compara a reputacao de dois usuarios
 * */

package usuarios;

import java.util.Comparator;

public class MenorReputacaoComparator implements Comparator<Usuario> {

	/**
	 * Metodo que compara duas reputacoes
	 * 
	 * @param o1 Usuario para comparacao
	 * @param o2 Usuario para comparacao
	 * 
	 * @return A menor reputacao entre os usuarios comparados
	 * */
	@Override
	public int compare(Usuario o1, Usuario o2) {
		if (o1.getReputacao() < o2.getReputacao()) {
			return -1;
		}
		else if (o1.getReputacao() == o2.getReputacao()) {
			return 0;
		}
		return 1;
	}
}
