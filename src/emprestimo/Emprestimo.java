/**
 * Classe que cria e manipula emprestimos.
 * */

package emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import itens.Item;
import usuarios.Usuario;

public class Emprestimo {
	
	private Item item;
	private Usuario dono;
	private Usuario requerente;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private int dias;
	private boolean emprestimoAtivo;
	private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Constroi um emprestimo
	 * 
	 * @param dono Representa o usuario dono do item
	 * @param requerente Representa o usuario requerente do Item
	 * @param dataEmprestimo Data que o emprestimo foi feito
	 * @param item O item emprestado
	 * @param dias Os dias totais para o emprestimo
	 * */
	public Emprestimo(Usuario dono, Usuario requerente, String dataEmprestimo, Item item, int dias) {
		this.dias = dias;
		this.dono = dono;
		this.item = item;
		this.requerente = requerente;
		this.dataEmprestimo = LocalDate.parse(dataEmprestimo, formato);
		this.item.setStatus(true);
		this.emprestimoAtivo = true;
	}
	
	public Usuario getDono() {
		return dono;
	}
	
	public Usuario getRequerente() {
		return requerente;
	}
	
	public String getNomeDono() {
		return dono.getNome();
	}
	
	public String getTelefoneDono() {
		return dono.getTelefone();
	}
	
	public String getNomeRequerente() {
		return requerente.getNome();
	}
	
	public String getTelefoneRequerente() {
		return requerente.getTelefone();
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
	
	public Item getItem() {
		return item;
	}
	
	public boolean getStatus() {
		return emprestimoAtivo;
	}
	
	/**
	 * Pega a informacao se o item ja foi devolvido, se ja tiver sido devolvido 
	 * retorna a data de devolucao
	 * 
	 * @return Uma string com a data de devolucao formatada
	 * */
	public String getDataDevolucao() {
		if (this.emprestimoAtivo == false) {
			return formato.format(dataDevolucao);
		}
		return "Emprestimo em andamento";
	}
	
	/**
	 * Seta a data de devolucao do item
	 * 
	 * @param dataDevolucao Uma string representando a data de devolucao
	 * */
	public void devolucao(String dataDevolucao) {
		this.dataDevolucao = LocalDate.parse(dataDevolucao, formato);
		this.item.setStatus(false);
		this.emprestimoAtivo = false;
	}
	
	/**
	 * Metodo que verifica os dias de atraso
	 * @return Retorna a quantidade de dias em atraso
	 */
	public int getAtraso() {
		return (int) dataEmprestimo.until(dataDevolucao, ChronoUnit.DAYS) - this.dias;
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

	/**
	 * Metodo equals. Checka se um emprestimo e igual ao
	 * outro se tiverem o mesmo item, dono, requerente e data
	 * de emprestimo.
	 * 
	 * @param obj Objeto a ser comparado
	 * 
	 * @return Retorna um boolean informando se e o mesmo ou nao
	 * */
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

	/**
	 * Retorna uma representacao do emprestimo em string
	 * 
	 * @return Uma string com os dados do emprestimo
	 * */
	@Override
	public String toString() {
		return "EMPRESTIMO - De: " + dono.getNome() + ", Para: " + requerente.getNome() + ", " + item.getNome() + 
				", " + getDataEmprestimo() + ", " + dias + " dias, ENTREGA: " + getDataDevolucao();
	}

}
