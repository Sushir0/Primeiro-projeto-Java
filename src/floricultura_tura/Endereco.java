package floricultura_tura;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Endereco {
	public String cidade;
	public String rua;
	public Integer numero;
	public String complemento;
	public static Scanner leitor = new Scanner(System.in);
	public static ArrayList<Endereco> lista = new ArrayList<Endereco>();

	public static Endereco cadastroBase() {
		Endereco endereco = new Endereco();
		endereco.cidade = "S�o Jer�nimo";
		endereco.rua = "rua";
		endereco.numero = Integer.valueOf("0");
		endereco.complemento = "moro em baixo da ponte de s�o jer�nimo para triunfo";
		lista.add(endereco);
		return endereco;
	}

	public static Endereco cadastrar() {
		Endereco endereco = new Endereco();
		endereco.cidade = JOptionPane.showInputDialog("qual a sua cidade?");
		endereco.rua = JOptionPane.showInputDialog("qual sua rua?");
		endereco.numero = Floricultura.questionJOPInteger("Qual o seu n�mero?");
		Integer	SN = Floricultura.questionJOPInteger("possui algum complemento? (se sim 1 sen�o 0)");
		
		
		if (SN == 1) {
			endereco.complemento = JOptionPane.showInputDialog("Qual o complemento da sua casa?");
		} else if (SN == 0) {
		} else {
			System.out.println("n�o entendi o que voc� digitou, ent�o coloquei como n�o :/");
		}
		System.out.println();
		lista.add(endereco);
		return endereco;
	}

}
