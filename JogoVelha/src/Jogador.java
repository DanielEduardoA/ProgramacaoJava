import java.util.Scanner;

public class Jogador {

	public void mostrarSimbolosJogadores(String Jogador1, String Jogador2) {
		System.out.println("\n");
	    System.out.println("Jogador 1 - "+Jogador1+": Seu símbolo é: " + mostarSimbolo(1));
	    System.out.println("Jogador 2 - "+Jogador2+": Seu símbolo é: " + mostarSimbolo(2));
	    System.out.println("\n");
	}
	
	@SuppressWarnings("resource")
	public String lerNomeJogador(int numeroJogador) {
		String nomeJogador = "";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Digite o nome do Jogador " + numeroJogador + ":");
			nomeJogador = scanner.nextLine();
		} while (nomeJogador.isEmpty());
		return nomeJogador;
	}
	
	private char mostarSimbolo(int numeroJogador) {
		if (numeroJogador == 1) {
			return 'X';
		} else {
			return 'O';
		}
	}

}
