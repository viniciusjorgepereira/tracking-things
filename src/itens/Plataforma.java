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
	
	Plataforma(String status) {
		this.status = status;
	}
	
	public String getValor() {
		return this.status;
	}

}
