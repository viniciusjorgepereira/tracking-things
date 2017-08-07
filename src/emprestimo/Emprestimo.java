package emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import usuarios.IdUsuario;

public class Emprestimo {
	private IdUsuario dono;
	private IdUsuario requerente;
	private LocalDate dataEmprestimo;
	private String nomeItem;
	private int dias;
	private LocalDate dataDevolucao;
	private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	public Emprestimo(IdUsuario dono, IdUsuario requerente, String dataEmprestimo, String item, int dias) {
		this.dono = dono;
		this.requerente = requerente;
		this.dataEmprestimo = LocalDate.parse(dataEmprestimo, formato);;
		this.nomeItem = item;
		this.dias = dias;
	}
	
	public void setDataEmprestimo(String data) {
		dataEmprestimo = LocalDate.parse(data, formato);
	}
	
	public IdUsuario getDono() {
		return dono;
	}
	
	public IdUsuario getRequerente() {
		return requerente;
	}
	
	public String getDataEmprestimo() {
		String data = formato.format(dataEmprestimo);
		return data;
	}
	
	public String getNomeItem() {
		return nomeItem;
	}
	
	public int getDias() {
		return dias;
	}
	
	public String getDataDevolucao() {
		if (dataDevolucao != null) {
			String data = formato.format(dataDevolucao);
			return data;
		}
		return "Emprestimo em andamento";
	}
	
	public void devolucao(String dataDevolucao) {
		this.dataDevolucao = LocalDate.parse(dataDevolucao, formato);
	}
	
	public int atraso() {
		int atraso = (int) dataEmprestimo.until(dataDevolucao, ChronoUnit.DAYS);
		
		return atraso;
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
				", " + getDataEmprestimo() + ", " + dias + " dias, ENTREGA: " + getDataDevolucao();
	}

	
	
}
