package itens;

public enum Genero {

	ACAO("Ação"), 
	ANIMACAO("Animação"), 
	AVENTURA("Aventura"),
	COMEDIA("Comédia"),
	DOCUMENTARIO("Documentário"),
	DRAMA("Drama"),
	EROTICO("Erótico"),
	FAROESTE("Faroeste"),
	FICCAO("Ficção"),
	MUSICAL("Musical"),
	POLICIAL("Policial"),
	ROMANCE("Romance"),
	SUSPENSE("Suspense"),
	TERROR("Terror"),
	OUTRO("Outro");

	private final String status;
	
	private Genero(String status) {
		this.status = status;
	}
	
	public String getValor() {
		return status;
	}
}
