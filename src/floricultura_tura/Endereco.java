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
		endereco.cidade = "São Jerônimo";
		endereco.rua = "rua";
		endereco.numero = Integer.valueOf("0");
		endereco.complemento = "moro em baixo da ponte de são jerônimo para triunfo";
		lista.add(endereco);
		return endereco;
	}

	public static Endereco cadastrar() {
		Endereco endereco = new Endereco();
		endereco.cidade = JOptionPane.showInputDialog("qual a sua cidade?");
		endereco.rua = JOptionPane.showInputDialog("qual sua rua?");
		endereco.numero = Floricultura.questionJOPInteger("Qual o seu número?");
		Integer	SN = Floricultura.questionJOPInteger("possui algum complemento? (se sim 1 senão 0)");
		
		
		if (SN == 1) {
			endereco.complemento = JOptionPane.showInputDialog("Qual o complemento da sua casa?");
		} else if (SN == 0) {
		} else {
			System.out.println("não entendi o que você digitou, então coloquei como não :/");
		}
		System.out.println();
		lista.add(endereco);
		return endereco;
	}

}
