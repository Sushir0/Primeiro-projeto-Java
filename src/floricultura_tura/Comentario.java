package floricultura_tura;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Comentario {
	public Integer ID;
	public Usuario usuario;
	public String texto;
	public static Scanner leitor = new Scanner(System.in);
	public static Integer count = 0;
	public static ArrayList<Comentario> lista = new ArrayList<Comentario>();
	public ArrayList<SubComentario> sub = new ArrayList<SubComentario>();
	public static Integer pesquisa = 0;

	public Comentario() {
		sub = new ArrayList<SubComentario>();
	}

	public static Comentario cadastrar(Produto pesq) {
		for (Produto p : Produto.produtos) {
			if (p.id == pesq.id) {

				Comentario novoComentario = new Comentario();
				novoComentario.texto = JOptionPane.showInputDialog("O que desejas comentar?");
				if(novoComentario.texto == null) {
					return null;
				}
				novoComentario.ID = count;
				novoComentario.usuario = Usuario.getLogin();
				count++;
				p.comentario.add(novoComentario);

				return novoComentario;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		
	}
}
