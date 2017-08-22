package emprestimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmprestimoController {
	private ArrayList<Emprestimo> emprestimosOrdenados;

	public String listarEmprestimosUsuarioEmprestando(List<Emprestimo> emprestimos) {
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return listagemEmprestimos("Emprestimos: ");
		}
		return "Nenhum item emprestado";
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(List<Emprestimo> emprestimos) {
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return listagemEmprestimos("Emprestimos pegos: ");
		}
		return "Nenhum item pego emprestado";
	}

	private void ordenaEmprestimos(List<Emprestimo> emprestimos) {
		emprestimosOrdenados = new ArrayList<>(emprestimos);
		Collections.sort(emprestimosOrdenados, new OrdemEmprestimoNome());
	}

	private String listagemEmprestimos(String msg) {
		String saida = msg;
		for (Emprestimo emprestimo : this.emprestimosOrdenados) {
			saida += emprestimo.toString() + "|";
		}
		return saida;
	}
}
