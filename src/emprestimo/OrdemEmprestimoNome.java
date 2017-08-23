/**
 * Classe que compara Emprestimos pelo nome do item
 * */
package emprestimo;

import java.util.Comparator;

public class OrdemEmprestimoNome implements Comparator<Emprestimo> {

	/**
	 * Compara o nome dos itens envolvidos nos emprestimos
	 * 
	 * @param emprestimo1 Emprestimo a ser comparado
	 * @param emprestimo2 Emprestimo a ser comparado
	 * 
	 * @return Retorna nome do item mais proximo ao inicio do alfabeto
	 * */
	@Override
	public int compare(Emprestimo emprestimo1, Emprestimo emprestimo2) {
		return emprestimo1.getNomeItem().compareTo(emprestimo2.getNomeItem());
	}
}