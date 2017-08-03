package emprestimo;

import java.util.Date;
import usuarios.IdUsuario;

public class Emprestimo {
	private IdUsuario nomeDono;
	private IdUsuario nomeRequerente;
	private Date dataEmprestimo;
	private String nomeItem;
	private int dias;
	
	public Emprestimo(IdUsuario nomeDono, IdUsuario nomeRequerente, Date dataEmprestimo, String item, int dias) {
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.dataEmprestimo = dataEmprestimo;
		this.nomeItem = item;
		this.dias = dias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((nomeDono == null) ? 0 : nomeDono.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		result = prime * result + ((nomeRequerente == null) ? 0 : nomeRequerente.hashCode());
		return result;
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
		if (nomeDono == null) {
			if (other.nomeDono != null)
				return false;
		} else if (!nomeDono.equals(other.nomeDono))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		if (nomeRequerente == null) {
			if (other.nomeRequerente != null)
				return false;
		} else if (!nomeRequerente.equals(other.nomeRequerente))
			return false;
		return true;
	}
}
