package principal;

import easyaccept.EasyAccept;

public class Main {
	public static void main(String[] args) {
		args = new String[] { "principal.Facade", "testes_aceitacao/us1_test.txt", "testes_aceitacao/us2_test.txt",
				"testes_aceitacao/us3_test.txt", "testes_aceitacao/us4_test.txt"};
		EasyAccept.main(args);
	}
}
