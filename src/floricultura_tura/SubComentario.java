package floricultura_tura;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SubComentario extends Comentario {
	public Comentario comentario;
	public Integer ID;
	public String texto;
	public Usuario usuario;
	public static Integer count = 0;
	public static Scanner leitor = new Scanner(System.in);
	public static ArrayList<SubComentario> lista = new ArrayList<SubComentario>();

	public static Comentario cadastrarSubP() {
		Usuario.login();
		Comentario.pesquisa = Floricultura.questionJOPInteger("qual comentario você deseja comentar? digite o numero ao final do comentario");

		ArrayList<Produto> produtos = Produto.produtos;
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);

			for (Comentario com : p.comentario) {
				if (com.ID == Comentario.pesquisa) {
					SubComentario.cadastrarSubCom(com);
					return com;
				}
			}
		}
		return null;
	}

	public static Comentario cadastrarSubCom(Comentario com) {

		SubComentario novoSubcomentario = new SubComentario();

		novoSubcomentario.texto = JOptionPane.showInputDialog("O que desejas comentar sobre o comentario?");
		novoSubcomentario.ID = count;
		
		novoSubcomentario.usuario = Usuario.getLogin();

		count++;
		com.sub.add(novoSubcomentario);

		return novoSubcomentario;
	}

}
