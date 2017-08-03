package itens;

import java.util.Date;

public class Emprestimo {
	private String emprestador;
	private String emprestando;
	private String item;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private int dias;
	
	public Emprestimo(String emprestador, String emprestando, int dias, Date dataEmprestimo, Date dataDevoluco) {
		this.emprestador = emprestador;
		this.emprestando = emprestando;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (emprestador == null) {
			if (other.emprestador != null)
				return false;
		} else if (!emprestador.equals(other.emprestador))
			return false;
		if (emprestando == null) {
			if (other.emprestando != null)
				return false;
		} else if (!emprestando.equals(other.emprestando))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	
}
