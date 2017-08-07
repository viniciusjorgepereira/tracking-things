package emprestimo;

public class Emprestimo {
	private String nomeDono;
	private String nomeRequerente;
	private String dataEmprestimo;
	private String nomeItem;
	private int dias;
	private String dataDevolucao;
	

	public Emprestimo(String nomeDono, String nomeRequerente, String dataEmprestimo, String item, int dias) {
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.dataEmprestimo = dataEmprestimo;
		this.nomeItem = item;
		this.dias = dias;
		this.dataDevolucao = "Emprestimo em andamento";
	}
	
	public String getDono() {
		return nomeDono;
	}
	
	public String getRequerente() {
		return nomeRequerente;
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
		result = prime * result + ((nomeDono == null) ? 0 : nomeDono.hashCode());
		result = prime * result + ((nomeRequerente == null) ? 0 : nomeRequerente.hashCode());
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
		if (nomeDono == null) {
			if (other.nomeDono != null)
				return false;
		} else if (!nomeDono.equals(other.nomeDono))
			return false;
		if (nomeRequerente == null) {
			if (other.nomeRequerente != null)
				return false;
		} else if (!nomeRequerente.equals(other.nomeRequerente))
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
		return "EMPRESTIMO - De: " + nomeDono + ", Para: " + nomeRequerente + ", " + nomeItem + 
				", " + dataEmprestimo + ", " + dias + " dias, ENTREGA: " + dataDevolucao;
	}

	
	
}
