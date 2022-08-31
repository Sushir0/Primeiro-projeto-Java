package floricultura_tura;



import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Floricultura{
	public static Integer errorCount = 0;
	public Usuario usuario;
	public static ArrayList<Produto> produtos = new ArrayList<Produto>();
	public static Scanner leitor = new Scanner(System.in);
	public static Produto produtoaux;
	public static Usuario usulogado;
	public static Integer UI = 9;
	public static Integer ok = 0;
	
	
	
	public static Integer questionJOPInteger(String escrita) {
		Integer numero = null;
		do {
			try {
				numero = Integer.valueOf(JOptionPane.showInputDialog(escrita));
				Floricultura.ok = 1;
			} catch (Exception erro) {
				Floricultura.errorCount++;
				Floricultura.showErroInt();
			}
		} while (Floricultura.ok != 1);
		Floricultura.ok = 0;
		return numero;
	}

	public static Integer questionScanInteger() {
		Integer numero = null;

		do {
			try {
				numero = Integer.valueOf(leitor.nextLine());
				Floricultura.ok = 1;
			} catch (Exception erro) {
				Floricultura.errorCount++;
				Floricultura.showErroInt();
			}
		} while (Floricultura.ok != 1);
		Floricultura.ok = 0;
		return numero;
	}

	public static Double questionJOPDouble(String escrita) {
		Double numero = null;
		do {
			try {
				numero = Double.valueOf(JOptionPane.showInputDialog(escrita));
				Floricultura.ok = 1;
			} catch (Exception erro) {
				Floricultura.errorCount++;
				Floricultura.showErroDouble();
			}
		} while (Floricultura.ok != 1);
		Floricultura.ok = 0;
		return numero;
	}

	public static void showErroInt() {
		if (Floricultura.errorCount >= 5 && Floricultura.errorCount < 10) {
			JOptionPane.showMessageDialog(null, "seu burro, leia antes de digitar, seu animal de 3 pata. você já errou "+Floricultura.errorCount);
		} else if(Floricultura.errorCount >= 10 && Floricultura.errorCount < 15){
			JOptionPane.showMessageDialog(null, "você deve estar brincando né. você já errou "+Floricultura.errorCount);
		}else if(Floricultura.errorCount >= 15){
			JOptionPane.showMessageDialog(null, "desisto. você já errou "+Floricultura.errorCount);
		}else {
			JOptionPane.showMessageDialog(null, "você digitou algo que não é um número inteiro. você já errou "+Floricultura.errorCount);
		}
	}

	public static void showErroDouble() {
		if (Floricultura.errorCount >= 5 && Floricultura.errorCount < 10) {
			JOptionPane.showMessageDialog(null, "seu burro, leia antes de digitar, seu animal de 3 pata. você já errou "+Floricultura.errorCount);
		} else if(Floricultura.errorCount >= 10 && Floricultura.errorCount < 15){
			JOptionPane.showMessageDialog(null, "você deve estar brincando né. você já errou "+Floricultura.errorCount);
		}else if(Floricultura.errorCount >= 15){
			JOptionPane.showMessageDialog(null, "desisto. você já errou "+Floricultura.errorCount);
		}else {
		JOptionPane.showMessageDialog(null, "você digitou algo que não é um número. você já errou "+Floricultura.errorCount);
		}
	}

	public static void comentarios() {
		do {
			if (Floricultura.usulogado == null) { // sem login
				Floricultura.showProduto(produtoaux);
				Floricultura.UI = Floricultura.questionScanInteger();
				if (Floricultura.UI == 1) {
					Usuario.login();
					if (Floricultura.usulogado != null) {
						Comentario.cadastrar(produtoaux);
					} else {
						System.out.println("não foi possível adicionar um comentario.");
					}
				} else if (Floricultura.UI == 2) {
					SubComentario.cadastrarSubP();
				}
			} else { // como usuario ou admin
				Floricultura.showProduto(produtoaux);
				Floricultura.UI = Floricultura.questionScanInteger();
				if (Floricultura.UI == 1) {
					Usuario.login();
					Comentario.cadastrar(produtoaux);
				} else if (Floricultura.UI == 2) {
					SubComentario.cadastrarSubP();
				}
			}

		} while (Floricultura.UI == 1);

	}

	public static void menu_principal() {
		if (Floricultura.usulogado == null) { // sem login
			System.out.println("Menu: ");
			
			
			
			System.out.println("");
			
			System.out.println("1 - Login");
			
			System.out.println("2 - Produtos");
			
			System.out.println("3 - Pesquisar produtos");
			
			System.out.println("4 - Cadastro");
			
			System.out.println("");
			System.out.println("0 - Fechar");
			
			
		} else if (Usuario.admoun()) { // como admin
			System.out.println("Menu / ADM: " + Usuario.getFirstName());
			
			
			System.out.println("");
			
			System.out.println("1 - Adicionar produtos");
			
			System.out.println("2 - Produtos");
			
			
			System.out.println("3 - Pesquisar produtos");
			
			
			System.out.println("4 - Alterar dados");
			
			
			System.out.println("5 - Logout");
			
			
			System.out.println("");
			
			System.out.println("0 - Fechar");
			
		} else { // como usuario
			System.out.println("Menu: / " + Usuario.getFirstName());
			
			System.out.println("");
			System.out.println("1 - Carrinho");
			
			
			System.out.println("2 - Produtos");
			System.out.println("3 - Pesquisar produtos");
			System.out.println("4 - Alterar dados");
			System.out.println("5 - Logout");
			System.out.println("");
			System.out.println("0 - Fechar");
		}
	}

	// lpc = login, produtos e carrinho
	public static void lpc() {
		if (Floricultura.usulogado == null) { // sem login
			Usuario.login();
		} else if (Usuario.admoun()) { // como admin
			Produto.cadastrarProdutos();
		} else { // como usuario
			Usuario.showCarrinho();
			Floricultura.UI = Floricultura.questionScanInteger();
			if (Floricultura.UI == 1) {
				Usuario.limparCarrinho();
			}
			Floricultura.UI = 9;

		}
	}

	public static void showProduto(Produto p) {
		Integer temsub = 0;
		System.out.println("");
		System.out.println(p.id + " item: " + p.nome + " / preço: " + p.preco);
		for (Comentario com : p.comentario) {
			System.out.println();
			System.out.println("  " + com.usuario.nome);
			System.out.println("   Comentario: " + com.texto + "(" + com.ID + ")");
			temsub = 1;
			for (SubComentario sub : com.sub) {
				System.out.println("    " + sub.usuario.nome);
				System.out.println("     Comentario: " + sub.texto);
			}

		}
		if (Floricultura.usulogado == null) { // sem login
			System.out.println();
			System.out.println("1 - Faça login e adicione um comentario");
			if (temsub == 1) {
				System.out.println("2 - Faça login e adicione sub-comentario");

			}
			System.out.println();
			System.out.println("0 - voltar para o menu");

		} else { // como usuario e ADMIN
			System.out.println();
			System.out.println("1 - Adicione um comentario");
			if (temsub == 1) {
				System.out.println("2 - Adicionar sub-comentario");
			}
			System.out.println();
			System.out.println("0 - voltar para o menu");
		}
		temsub = 0;
	}

	// ppp = produto produto produto
	public static void ppp() {
		do { // sem login || como admin e usuario
			System.out.println("Produtos");
			Produto.showProdutos();
			System.out.println();
			System.out.println("1 - pesquisar");
			System.out.println("0 - voltar para o menu");
			Floricultura.UI = Floricultura.questionScanInteger();

			if (Floricultura.UI == 1) {
				Floricultura.pesquisar();
			}
		} while (Floricultura.UI != 0);
		Floricultura.UI = 9;

	}

	public static void pesquisar() {
		if (Floricultura.usulogado == null) { // sem login
			Floricultura.produtoaux = Produto.pesquisa();
			if (Produto.showPesquisa(Floricultura.produtoaux) == null) {
			} else {
				System.out.println("1 - Faça login e coloque no carrinho");
				System.out.println("2 - Ver comentarios");
				System.out.println();
			}
			System.out.println("0 - voltar para o menu");

			Floricultura.UI = Floricultura.questionScanInteger();
			if (Floricultura.UI == 1) {
				Usuario.login();
				Usuario.adicionarAoCarrinho(Floricultura.produtoaux);

			} else if (Floricultura.UI == 2) {
				Floricultura.comentarios();
			}
		} else if (Usuario.admoun()) { // como admin
			Floricultura.produtoaux = Produto.pesquisa();
			if (Produto.showPesquisa(Floricultura.produtoaux) == null) {

			} else {
				System.out.println("1 - Remover Produto");
				System.out.println("2 - Ver comentarios");
				System.out.println();
			}
			System.out.println("0 - voltar para o menu");

			Floricultura.UI = Floricultura.questionScanInteger();
			if (Floricultura.UI == 1) {
				Usuario.login();
				Produto.removerProduto(Floricultura.produtoaux);

			} else if (Floricultura.UI == 2) {
				Floricultura.comentarios();
			}
		} else { // como usuario
			Floricultura.produtoaux = Produto.pesquisa();
			if (Produto.showPesquisa(Floricultura.produtoaux) == null) {

			} else {
				System.out.println("1 - Coloque no carrinho");
				System.out.println("2 - Ver comentarios");
				System.out.println();
			}
			System.out.println("0 - voltar para o menu");

			Floricultura.UI = Floricultura.questionScanInteger();
			if (Floricultura.UI == 1) {
				Usuario.login();
				Usuario.adicionarAoCarrinho(Floricultura.produtoaux);

			} else if (Floricultura.UI == 2) {
				Floricultura.comentarios();
			}
		}
		Floricultura.UI = 9;
	}

	//caa = cadastro alterar alterar
	public static void caa() {
		if (Floricultura.usulogado == null) { // sem login
			Usuario.cadastrar();
		} else { // como amin ou usuario
			Usuario.auxAlt();
		}
	}

	public static Floricultura UIfinal() {
		do {
			Floricultura.menu_principal();
			Floricultura.UI = Floricultura.questionScanInteger();
			switch (Floricultura.UI) {
			case 1:
				Floricultura.lpc();
				break;
			case 2:
				Floricultura.ppp();
				break;
			case 3:
				Floricultura.pesquisar();
				break;
			case 4:
				Floricultura.caa();
				break;
			case 5:
				Usuario.logout();
			}

		} while (Floricultura.UI != 0);
		return null;
	}

	public static void main(String[] args) {
		new Floricultura();
		Usuario.cadastroBase();
		Usuario.cadastroBaseADM();
		Produto.cadastroBase();

		Floricultura.UIfinal();
		System.out.println("Finish");
		Usuario.showUsuario();

	}

	

}
