
package emprestimo;

import java.util.Comparator;

public class OrdemEmprestimoNome implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimo1, Emprestimo emprestimo2) {
		return emprestimo1.getNomeItem().compareTo(emprestimo2.getNomeItem());
	}
}