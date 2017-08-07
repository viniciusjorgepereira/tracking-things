package emprestimo;

import usuarios.IdUsuario;

public class Emprestimo {
	private IdUsuario dono;
	private IdUsuario requerente;
	private String dataEmprestimo;
	private String nomeItem;
	private int dias;
	private String dataDevolucao;
	

	public Emprestimo(IdUsuario dono, IdUsuario requerente, String dataEmprestimo, String item, int dias) {
		this.dono = dono;
		this.requerente = requerente;
		this.dataEmprestimo = dataEmprestimo;
		this.nomeItem = item;
		this.dias = dias;
		this.dataDevolucao = "Emprestimo em andamento";
	}
	
	public IdUsuario getDono() {
		return dono;
	}
	
	public IdUsuario getRequerente() {
		return requerente;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public String getNomeItem() {
		return nomeItem;
	}
	
	public int getDias() {
		return dias;
	}
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void devolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
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
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "EMPRESTIMO - De: " + dono.getNome() + ", Para: " + requerente.getNome() + ", " + nomeItem + 
				", " + dataEmprestimo + ", " + dias + " dias, ENTREGA: " + dataDevolucao;
	}

	
	
}
