package floricultura_tura;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Produto {
	public String nome;
	public Double preco;
	public Integer id;
	public ArrayList<Comentario> comentario = new ArrayList<Comentario>();
	public static Scanner leitor = new Scanner(System.in);
	public static Integer count = 0;
	public static ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Produto() {
		comentario = new ArrayList<Comentario>();
	}
	
	public static Produto cadastroBase() {
		Produto produtoNovo1 = new Produto();
		produtoNovo1.nome = "Arvore";
		produtoNovo1.preco = 1.99;
		produtoNovo1.id = count;
		count++;
		produtos.add(produtoNovo1);
		
		Produto produtoNovo2 = new Produto();
		produtoNovo2.nome = "suporte de plantas de Macramé";
		produtoNovo2.preco = 25.00;
		produtoNovo2.id = count;
		count++;
		produtos.add(produtoNovo2);
		
		Produto produtoNovo3 = new Produto();
		produtoNovo3.nome = "Gata corrompida das trevas trevosas (Blue)";
		produtoNovo3.preco = 1000000000.60;
		produtoNovo3.id = count;
		count++;
		produtos.add(produtoNovo3);
		return null;
	}

	
	public static Produto cadastrarProdutos() {
		if (Usuario.admoun()) {
			
			Integer j = Floricultura.questionJOPInteger("quantos protudos você deseja cadastrar?");

			for (int i = 0; i < j; i++) {
				Produto.cadastrar();
			}
		}
		return null;
	}

	public static void showProdutos() {
		for (Produto p : produtos) {
			System.out.println("");
			System.out.println(p.id + " item: " + p.nome + " / preço: " + p.preco);

		}
	}

	public static void showProdutoComentario() {
		for (Produto p : produtos) {

			System.out.println("");
			System.out.println(p.id);
			System.out.println(p.nome);
			System.out.println(p.preco);

			for (Comentario com : p.comentario) {

				System.out.println(com.usuario.nome);
				System.out.println("comentario: " + com.texto);
			}
		}

	}


	public static Produto pesquisa() {
		
		String pesquisa = JOptionPane.showInputDialog("qual produto você deseja pesquisar?");

		for (Produto pesq : produtos) {
			if (pesq.nome.equals(pesquisa)) {

				return pesq;
			}
		}

		return null;
	}

	public static Produto showPesquisa(Produto pesq) {
		if (pesq == null) {
			System.out.println("item não encontrado");
			return null;
		} else {

			System.out.println("");
			System.out.println(pesq.id + ") " + pesq.nome + " / " + pesq.preco);

			for (Comentario com : pesq.comentario) {

				System.out.println(com.usuario.nome);
				System.out.println("comentario: " + com.texto);
			}
			
		}
		return pesq;
	}

	public static Produto cadastrar() {

		System.out.println("");
		Produto produtoNovo = new Produto();
		produtoNovo.nome = JOptionPane.showInputDialog("qual o produto");
		produtoNovo.preco = Floricultura.questionJOPDouble("qual o preço?");
		
		produtoNovo.id = count;
		count++;
		produtos.add(produtoNovo);
		return produtoNovo;

	}
	
	public static Produto removerProduto(Produto pesq) {
		if(pesq == null) {
			System.out.println("item não encontrado");
			return null;
		}else {
			Produto.produtos.remove(pesq);
			return null;
		}	
	}

}
