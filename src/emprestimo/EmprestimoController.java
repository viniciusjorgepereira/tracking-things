package emprestimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmprestimoController {
	private ArrayList<Emprestimo> emprestimosOrdenados;
	
	public String listarEmprestimosUsuarioEmprestando(List<Emprestimo> emprestimos) {
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return "Emprestimos: " + listagemEmprestimos();
		}
		return "Nenhum item emprestado";
	}

	private void ordenaEmprestimos(List<Emprestimo> emprestimos) {
		emprestimosOrdenados = new ArrayList<>(emprestimos);
		Collections.sort(emprestimosOrdenados, new OrdemEmprestimoNome());
	}
	
	private String listagemEmprestimos() {
		String saida = "";
		for(Emprestimo emprestimo: this.emprestimosOrdenados) {
			saida += emprestimo.toString() + "|";
		}
		return saida;
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(List<Emprestimo> emprestimos) {
		ordenaEmprestimos(emprestimos);
		if (emprestimos.size() > 0) {
			ordenaEmprestimos(emprestimos);
			return "Emprestimos pegos: " + listagemEmprestimos();			
		}
		return "Nenhum item pego emprestado";
	}
}
