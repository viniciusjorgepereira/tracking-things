package emprestimo;

import java.util.Date;
import usuarios.IdUsuario;

public class Emprestimo {
	private IdUsuario dono;
	private IdUsuario requerente;
	private Date dataEmprestimo;
	private String nomeItem;
	private int dias;
	
	public Emprestimo(IdUsuario dono, IdUsuario requerente, Date dataEmprestimo, String item, int dias) {
		this.dono = dono;
		this.requerente = requerente;
		this.dataEmprestimo = dataEmprestimo;
		this.nomeItem = item;
		this.dias = dias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
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
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		return true;
	}
}
