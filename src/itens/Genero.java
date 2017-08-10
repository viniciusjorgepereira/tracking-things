/**
 * Enum com todos os generos possiveis no sistema
 * */

package itens;

public enum Genero {

	ACAO("ACAO"),
	ANIMACAO("ANIMACAO"),
	AVENTURA("AVENTURA"),
	COMEDIA("COMEDIA"),
	DOCUMENTARIO("DOCUMENTARIO"),
	DRAMA("DRAMA"),
	EROTICO("EROTICO"),
	FAROESTE("FAROESTE"),
	FICCAO("FICCAO"),
	MUSICAL("MUSICAL"),
	POLICIAL("POLICIAL"),
	ROMANCE("ROMANCE"),
	SUSPENSE("SUSPENSE"),
	TERROR("TERROR"),
	OUTRO("OUTRO");
	
	private final String status;
	
	/**
	 * Constroi um genero
	 * */
	Genero(String status) {
		this.status = status;
	}
	
	/**
	 * Recupera valor do genero
	 * */
	public String getValor() {
		return this.status;
	}
}
