/**
 * Classe que gera o cartao do tipo Caloteiro
 * implementa a interface CartaoFidelidade
 * */

package cartoes;

public class CartaoCaloteiro implements CartaoFidelidade {
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
