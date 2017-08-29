/**
 * Classe que gera o cartao do tipo Caloteiro
 * implementa a interface CartaoFidelidade
 * */

package cartoes;

import java.io.Serializable;

public class CartaoCaloteiro implements CartaoFidelidade, Serializable {
	private static final long serialVersionUID = 1L;
	private final String tipo = "Caloteiro";
	private final boolean emprestimo = false;
	private final int dias = 0;
	
	
	@Override
	public String getTipoCartao() {
		return tipo;
	}

	@Override
	public boolean permissaoEmprestimo() {
		return emprestimo;
	}

	@Override
	public int diasMaximoEmprestimo() {
		return dias;
	}

}
