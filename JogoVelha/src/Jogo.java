public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador jogador = new Jogador();
	private String jogador1 = "";
	private String jogador2 = "";

	public void jogar() {
		lerNomesJogadores();
		jogador.mostrarSimbolosJogadores(jogador1, jogador2);
		tabuleiro.mostrarTabuleiro();
		int numeroJogador = 1;
		int vencedor = 0;
		while (vencedor == 0) {
			System.out.println("Jogador " + numeroJogador);
			tabuleiro.efetuarJogada(numeroJogador);
			numeroJogador = retornarProximoJogador(numeroJogador);
			tabuleiro.mostrarTabuleiro();
			vencedor = tabuleiro.verificarVencedor();
		}
		mostrarVencedor(vencedor);
	}

	private int retornarProximoJogador(int jogador) {
		if (jogador == 1) {
			return 2;
		} else {
			return 1;
		}
	}

	private void lerNomesJogadores() {
		int numeroJogador = 1;
		jogador1 = jogador.lerNomeJogador(numeroJogador);
		jogador2 = jogador.lerNomeJogador(++numeroJogador);
	}

	private void mostrarVencedor(int vencedor) {
		switch (vencedor) {
		case 1:
			System.out.println("Vencedor jogador 1: " + jogador1);
			break;
		case 2:
			System.out.println("Vencedor jogador 2: " + jogador2);
			break;
		case 3:
			System.out.println("Deu velha");
			break;
		}
	}
}