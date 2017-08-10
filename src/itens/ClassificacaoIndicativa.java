/**
 * Enum que relaciona as classificacoes indicativas.
 * Elas podem ser livre, dez anos, doze anos, quatorze
 * anos, dezesseis anos e dezoito anos.
 * */

package itens;

public enum ClassificacaoIndicativa {

	LIVRE("LIVRE"),
	DEZ_ANOS("DEZ_ANOS"),
	DOZE_ANOS("DOZE_ANOS"),
	QUATORZE_ANOS("QUATORZE_ANOS"),
	DEZESSEIS_ANOS("DEZESSEIS_ANOS"),
	DEZOITO_ANOS("DEZOITO_ANOS");

	private final String status;

	/**
	 * Constroi o status da classificacao indicativa
	 * */
	ClassificacaoIndicativa(String status) {
		this.status = status;
	}

	/**
	 * Retorna o valor atual do status do enum
	 * 
	 * @return O status atual do enum
	 * */
	public String getValor() {
		return this.status;
	}
}
