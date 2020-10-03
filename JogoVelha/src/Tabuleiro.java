import java.util.Scanner;

public class Tabuleiro {
	private int jogo[][] = new int[3][3];

	public void mostrarTabuleiro() {
		System.out.println("   a   b   c");
		for (int i = 0; i < 3; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			int linha = i + 1;
			stringBuilder.append(linha);
			stringBuilder.append("  ");
			for (int j = 0; j < 3; j++) {
				stringBuilder.append(mostrarSimbolo(i, j));
				if (j != 2) {
					stringBuilder.append("| ");
				}
			}
			System.out.println(stringBuilder.toString());
			if (i != 2) {
				System.out.println("  ___|___|___");
			}

		}
		System.out.println("\n");
	}

	@SuppressWarnings("resource")
	public void efetuarJogada(int jogador) {
		Scanner scanner = new Scanner(System.in);
		int linha = -1;
		int coluna = -1;
		boolean jogadaValida = true;
		do {
			System.out.println("Digite a posição: ");
			String posicao = scanner.next();
			linha = pegarNumeroLinha(posicao.charAt(0));
			if (linha != -1) {
				coluna = pegarNumeroColuna(posicao.charAt(1));
				jogadaValida = verificarJogadaValida(linha, coluna);
			} else {
				jogadaValida = false;
			}
		} while (!jogadaValida);
		jogo[linha][coluna] = jogador;
	}

	public int verificarVencedor() {
		//verificar vencedor na linha
		for (int i = 0; i < 3; i++) {
			if ((jogo[i][0] == jogo[i][1]) && (jogo[i][0] == jogo[i][2]) && (jogo[i][0] != 0)) {
				return jogo[i][0];
			}
		}
		
		//verificar vencedor na coluna
		for (int j = 0; j < 3; j++) {
			if ((jogo[0][j] == jogo[1][j]) && (jogo[0][j] == jogo[2][j]) && (jogo[0][j] != 0)) {
				return jogo[0][j];
			}
		}
		
		//verificar vencedor na diagonal primária
		if ((jogo[0][0] == jogo[1][1]) && (jogo[0][0] == jogo[2][2]) && (jogo[0][0] != 0)) {
			return jogo[0][0];
		}
		
		//verificar vencedor na diagonal secundária
		if ((jogo[0][2] == jogo[1][1]) && (jogo[0][2] == jogo[2][0]) && (jogo[0][2] != 0)) {
			return jogo[0][2];
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (jogo[i][j] == 0) {
					return 0;
				}
			}
		}
		
		return 3;
	}

	private boolean verificarJogadaValida(int linha, int coluna) {
		return verificarLinhaValida(linha) && verificarColunaValida(coluna) && verificarLinhaColunaVazia(linha, coluna);
	}

	private boolean verificarLinhaValida(int linha) {
		if ((linha < 0) || (linha > 2)) {
			System.out.println("Linha inválida...");
			return false;
		}
		return true;
	}

	private boolean verificarColunaValida(int coluna) {
		if ((coluna < 0) || (coluna > 2)) {
			System.out.println("Coluna inválida...");
			return false;
		}
		return true;
	}

	private int pegarNumeroColuna(char coluna) {
		if (coluna == 'a' || coluna == 'A') {
			return 0;
		} else if (coluna == 'b' || coluna == 'B') {
			return 1;
		} else if (coluna == 'c' || coluna == 'C') {
			return 2;
		} else {
			return -1;
		}
	}

	private int pegarNumeroLinha(char linha) {
		try {
			return Integer.parseInt(String.valueOf(linha)) - 1;
		} catch (NumberFormatException e) {
			System.out.println("Número da linha inválida...");
			return -1;
		}
	}

	private boolean verificarLinhaColunaVazia(int linha, int coluna) {
		if (jogo[linha][coluna] != 0) {
			System.out.println("Já existe uma jogada para esta linha e coluna.");
			return false;
		}
		return true;
	}

	private String mostrarSimbolo(int linha, int coluna) {
		if (jogo[linha][coluna] == 1) {
			return "X ";
		} else if (jogo[linha][coluna] == 2) {
			return "O ";
		} else {
			return "  ";
		}

	}

}
