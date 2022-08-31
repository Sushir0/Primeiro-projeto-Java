package floricultura_tura;

import java.util.Scanner;



public class Proprietario extends Usuario {
	
	public static Scanner leitor = new Scanner(System.in);
	
	
	public static Proprietario cadastrarProdutos() {
		if (Usuario.admoun()) {
			
			Integer j = Floricultura.questionJOPInteger("quantos produtos você deseja cadastrar?");

			for (int i = 0; i < j; i++) {
				Produto.cadastrar();
			}
		}
		return null;
	}

}
