/**
 * Enum que guarda as plataformas do jogos
 * eletronicos
 * */

package itens;

public enum Plataforma {

	PC("PC"),
	MAC("MAC"),
	PS3("PS3"),
	PS4("PS4"),
	XBOX360("XBOX360"),
	XBOX_ONE("XBOX_ONE"),
	NINTENDO_3DS("NITENDO_3DS"),
	OUTRO("OUTRO");
	
	private final String status;
	
	/**
	 * Constroi um tipo de plataforma
	 * */
	Plataforma(String status) {
		this.status = status;
	}
	
	/**
	 * Resgata valor da plataforma
	 * 
	 * @return Valor atual da plataforma
	 * */
	public String getValor() {
		return this.status;
	}

}
