package itens;

public enum ClassificacaoIndicativa {

	LIVRE("LIVRE"),
	DEZ_ANOS("DEZ_ANOS"),
	DOZE_ANOS("DOZE_ANOS"),
	QUATORZE_ANOS("QUATORZE_ANOS"),
	DEZESSEIS_ANOS("DEZESSEIS_ANOS"),
	DEZOITO_ANOS("DEZOITO_ANOS");

	private final String status;

	ClassificacaoIndicativa(String status) {
		this.status = status;
	}

	public String getValor() {
		return this.status;
	}
}
