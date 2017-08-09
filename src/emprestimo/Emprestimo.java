package emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import itens.Item;
import usuarios.IdUsuario;

public class Emprestimo {
	
	private Item item;
	private IdUsuario dono;
	private IdUsuario requerente;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private int dias;
	private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Emprestimo(IdUsuario dono, IdUsuario requerente, String dataEmprestimo, Item item, int dias) {
		this.dias = dias;
		this.dono = dono;
		this.item = item;
		this.requerente = requerente;
		this.dataEmprestimo = LocalDate.parse(dataEmprestimo, formato);;
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
		return formato.format(dataEmprestimo);
	}
	
	public String getNomeItem() {
		return item.getNome();
	}
	
	public int getDias() {
		return dias;
	}
	
	public String getDataDevolucao() {
		if (dataDevolucao != null) {
			return formato.format(dataDevolucao);
		}
		return "Emprestimo em andamento";
	}
	
	public void devolucao(String dataDevolucao) {
		this.dataDevolucao = LocalDate.parse(dataDevolucao, formato);
	}
	
	/**
	 * Metodo que verifica os dias de atraso
	 * @return Retorna a quantidade de dias em atraso
	 */
	public int getAtraso() {
		return (int) dataEmprestimo.until(dataDevolucao, ChronoUnit.DAYS);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());

		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "EMPRESTIMO - De: " + dono.getNome() + ", Para: " + requerente.getNome() + ", " + item.getNome() + 
				", " + getDataEmprestimo() + ", " + dias + " dias, ENTREGA: " + getDataDevolucao();
	}
}
