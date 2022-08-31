package floricultura_tura;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Usuario {

	public Integer id;
	public String nome;
	protected String email;
	protected String senha;
	public Endereco endereco;
	public static Scanner leitor = new Scanner(System.in);
	private static ArrayList<Usuario> lista = new ArrayList<Usuario>();
	private static ArrayList<Proprietario> admlist = new ArrayList<Proprietario>();
	public ArrayList<Produto> carrinho = new ArrayList<Produto>();
	public static Integer count = 0;

	public Usuario() {
		carrinho = new ArrayList<Produto>();
	}
	
	public static String getFirstName() {
		String[] nome = Floricultura.usulogado.nome.split(" ");
		return nome[0];
	}
	
	public static Usuario cadastroBase() {
		Usuario usuarioNovo1 = new Usuario();
		usuarioNovo1.nome = "Ciro Roberto";
		usuarioNovo1.email = "sushiro";
		usuarioNovo1.senha = "123";
		usuarioNovo1.id = count;
		count++;
		usuarioNovo1.endereco = Endereco.cadastroBase();
		lista.add(usuarioNovo1);

		Usuario usuarioNovo2 = new Usuario();
		usuarioNovo2.nome = "Amanda Carolina";
		usuarioNovo2.email = "carolzinha";
		usuarioNovo2.senha = "123";
		usuarioNovo2.id = count;
		count++;
		usuarioNovo2.endereco = Endereco.cadastroBase();
		lista.add(usuarioNovo2);

		Usuario usuarioNovo3 = new Usuario();
		usuarioNovo3.nome = "Thainá";
		usuarioNovo3.email = "thaininha";
		usuarioNovo3.senha = "123";
		usuarioNovo3.id = count;
		count++;
		usuarioNovo3.endereco = Endereco.cadastroBase();
		lista.add(usuarioNovo3);

		Usuario usuarioNovo4 = new Usuario();
		usuarioNovo4.nome = "Vanius";
		usuarioNovo4.email = "sorzinho";
		usuarioNovo4.senha = "123";
		usuarioNovo4.id = count;
		count++;
		usuarioNovo4.endereco = Endereco.cadastroBase();
		lista.add(usuarioNovo4);

		return null;
	}
	
	public static Usuario cadastroBaseADM() {
		Proprietario ADMNovo1 = new Proprietario();
		ADMNovo1.email = "sushiro";
		ADMNovo1.senha = "123";
		admlist.add(ADMNovo1);

		Proprietario ADMNovo2 = new Proprietario();
		ADMNovo2.email = "carolzinha";
		ADMNovo2.senha = "123";
		admlist.add(ADMNovo2);

		Proprietario ADMNovo3 = new Proprietario();
		ADMNovo3.email = "taininha";
		ADMNovo3.senha = "123";
		admlist.add(ADMNovo3);

		return null;
	}

	public static void showCarrinho() {
		System.out.println("Carrinho de " + Floricultura.usulogado.nome);
		System.out.println();
		double i = 0;
		for (Produto car : Floricultura.usulogado.carrinho) {

			System.out.println(car.id + " - " + car.nome + " / " + car.preco);
			i = i + car.preco;
		}
		System.out.println("total da compra: " + i);
		System.out.println("1 - Limpar o carrinho");
		System.out.println("0 - Voltar para o menu");
	}

	public static Usuario logout() {
		Floricultura.usulogado = null;
		return null;
	}

	public static boolean admoun() {
		for (Proprietario adm : admlist) {
			if (adm.email == Floricultura.usulogado.email) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static Usuario limparCarrinho() {
		Floricultura.usulogado.carrinho.clear();
		return null;
	}

	public static Usuario adicionarAoCarrinho(Produto produto) {
		if (Floricultura.usulogado != null) {

			for (Usuario usu : lista) {
				if (usu.id == Floricultura.usulogado.id) {
					usu.carrinho.add(produto);
				}
			}
		} else {
			System.out.println("Usuario não logado com sucesso, erro ao adicionar ao carrinho");
		}
		return null;
	}

	public static Usuario auxAlt() {
		System.out.println("Alterar dados: ");
		System.out.println("");
		System.out.println("1 - Nome: " + Floricultura.usulogado.nome);
		if (Usuario.admoun()) {
		} else {
			System.out.println("2 - Email: " + Floricultura.usulogado.email);
			System.out.println("3 - Senha: " + Floricultura.usulogado.senha);
		}
		System.out.println("4 - Endereço");
		System.out.println();
		System.out.println("0 - Voltar para o menu");
		Integer aux = Floricultura.questionScanInteger();
		Usuario auxAlt = Floricultura.usulogado;
		String ALT;
		switch (aux) {
		case 1:
			ALT = JOptionPane.showInputDialog("Qual o nome?");
			auxAlt.nome = ALT;
			break;
		case 2:
			if(Usuario.admoun()) {				
				JOptionPane.showMessageDialog(null, "Administradores não podem trocar o email");
			}else {
			ALT = JOptionPane.showInputDialog("Qual o email?");
			
			
			auxAlt.email = ALT.toLowerCase();
			}
			
			break;
		case 3:
			if(Usuario.admoun()){
				JOptionPane.showMessageDialog(null, "Administradores não podem trocar a senha");
			}else {
			ALT = JOptionPane.showInputDialog("Qual a senha?");
			auxAlt.senha = ALT;
			}
			break;
		case 4:
			System.out.println("Alterar endereço: ");
			System.out.println("");
			System.out.println("1 - Cidade: " + Floricultura.usulogado.endereco.cidade);
			System.out.println("2 - Rua: " + Floricultura.usulogado.endereco.rua);
			System.out.println("3 - Numero: " + Floricultura.usulogado.endereco.numero);
			System.out.println("4 - Complemento: " + Floricultura.usulogado.endereco.complemento);
			aux = Floricultura.questionScanInteger();
			switch (aux) {
			case 1:
				ALT = JOptionPane.showInputDialog("Qual a cidade");
				auxAlt.endereco.cidade = ALT;
				break;
			case 2:
				ALT = JOptionPane.showInputDialog("Qual a rua?");
				auxAlt.endereco.rua = ALT;
				break;
			case 3:
				ALT = String.valueOf(Floricultura.questionJOPInteger("Qual o núermo?"));
				auxAlt.endereco.numero = Integer.valueOf(ALT);
				break;
			case 4:
				ALT = JOptionPane.showInputDialog("Qual o complemtento?");
				auxAlt.endereco.complemento = ALT;
				break;
			}
			break;
		}

		Usuario.alterarDados(auxAlt.nome, auxAlt.email, auxAlt.senha);
		return null;
	}

	public static Usuario alterarDados(String nome, String email, String senha) {
		for (Usuario alt : lista) {
			if (alt == Floricultura.usulogado) {
				alt.nome = nome;
				alt.email = email;
				alt.senha = senha;
				Floricultura.usulogado = alt;
			}
		}
		return null;
	}

	public static Usuario login() {
		if (Floricultura.usulogado == null) {
			String emailLido = JOptionPane.showInputDialog("qual o seu email???");
			String emailL = emailLido.toLowerCase();
			String senhaL = JOptionPane.showInputDialog("qual a sua senha?");
			
			Usuario.getLogin(emailL, senhaL);
			if (Floricultura.usulogado == null) {
				JOptionPane.showMessageDialog(null, "desculpe, não foi possível acessar sua conta");
			}
			return null;
		} else {
			return null;
		}
	}

	public static Usuario getLogin() {
		for (Usuario pess : lista) {
			if (pess != null) {
				if (pess.email.equals(Floricultura.usulogado.email) && pess.senha.equals(Floricultura.usulogado.senha)) {
					Floricultura.usulogado = pess;
					return pess;
				}
			}
		}
		return null;
	}

	public static Usuario getLogin(String email, String senha) {

		for (Usuario pess : lista) {
			if (pess != null) {
				if (pess.email.equals(email) && pess.senha.equals(senha)) {
					Floricultura.usulogado = pess;
					return pess;
				}
			}
		}
		return null;
	}

	public static Usuario cadastrar() {

		Usuario usuarioNovo = new Usuario();
		usuarioNovo.nome = JOptionPane.showInputDialog("qual seu nome?");
		String emailL = JOptionPane.showInputDialog("qual o seu email?");
		usuarioNovo.email = emailL.toLowerCase();
		usuarioNovo.senha = JOptionPane.showInputDialog("qual sua senha?");
		usuarioNovo.id = count;
		count++;
		usuarioNovo.endereco = Endereco.cadastrar();
		System.out.println("");
		lista.add(usuarioNovo);
		Usuario.getLogin(usuarioNovo.email, usuarioNovo.senha);
		return usuarioNovo;

	}

	public static void showUsuario() {
		for (Usuario usu : Usuario.lista) {
			System.out.println("");
			System.out.println("id: " + usu.id);
			System.out.println("nome: " + usu.nome);
			System.out.println("email: " + usu.email);
			System.out.println("senha: " + usu.senha);
			System.out.println("cidade: " + usu.endereco.cidade);
			System.out.println("rua: " + usu.endereco.rua);
			System.out.println("numero: " + usu.endereco.numero);
			System.out.println(usu.endereco.complemento);
			// for ( Produto car : Index.usulogado.carrinho) {
			// System.out.println(car.nome);
			// }
		}
	}

}
