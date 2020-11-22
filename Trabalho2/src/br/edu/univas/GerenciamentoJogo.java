package br.edu.univas;

import java.util.Scanner;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Time;

@SuppressWarnings("resource")
public class GerenciamentoJogo {

    public Jogo cadastrarJogo(Time mandante, Time visitante) {
        Jogo jogo = new Jogo();
        jogo.mandante = mandante;
        jogo.visitante = visitante;

        jogo.golsMandante = lerGolsTimeMandante();
        jogo.golsVisitante = lerGolsTimeVisitante();

        if (jogo.golsMandante > jogo.golsVisitante) {
            mandante.pontos += 3;
        } else if (jogo.golsVisitante > jogo.golsMandante) {
            visitante.pontos += 3;
        } else {
            mandante.pontos += 1;
            visitante.pontos += 1;
        }

        mandante.saldoGols = (mandante.saldoGols + jogo.golsMandante) - jogo.golsVisitante;
        visitante.saldoGols = (visitante.saldoGols + jogo.golsVisitante) - jogo.golsMandante;

        System.out.println("Jogo cadastrado com sucesso!");
        return jogo;
    }

    public Jogo alterarJogo(Jogo jogo) {
        int golsTimeMandante = lerGolsTimeMandante();
        int golsTimeVisitante = lerGolsTimeVisitante();

        if (jogo.golsMandante > jogo.golsVisitante && golsTimeMandante < golsTimeVisitante) {
            jogo.mandante.pontos -= 3;
            jogo.visitante.pontos += 3;
        } else if (jogo.golsVisitante > jogo.golsMandante && golsTimeVisitante < golsTimeMandante) {
            jogo.visitante.pontos -= 3;
            jogo.mandante.pontos += 3;
        } else if (jogo.golsMandante == jogo.golsVisitante && golsTimeMandante > golsTimeVisitante) {
            jogo.mandante.pontos += 2;
            jogo.visitante.pontos -= 1;
        } else if (jogo.golsVisitante == jogo.golsMandante && golsTimeVisitante > golsTimeMandante) {
            jogo.visitante.pontos += 2;
            jogo.mandante.pontos -= 1;
        } else if (jogo.golsMandante > jogo.golsVisitante && golsTimeMandante == golsTimeVisitante) {
            jogo.mandante.pontos -= 2;
            jogo.visitante.pontos += 1;
        } else if (jogo.golsVisitante > jogo.golsMandante && golsTimeVisitante == golsTimeMandante) {
            jogo.visitante.pontos -= 2;
            jogo.mandante.pontos += 1;
        } 

        jogo.mandante.saldoGols = golsTimeMandante - golsTimeVisitante;
        jogo.visitante.saldoGols = golsTimeVisitante - golsTimeMandante;

        jogo.golsMandante = golsTimeMandante;
        jogo.golsVisitante = golsTimeVisitante;

        System.out.println("Jogo alterado com sucesso!");
        return jogo;
    }

    public Jogo pesquisarJogo(Jogo[] jogos, String nomeMandante, String nomeVisitante) {
        int posicao = pesquisarJogoPorTimes(jogos, nomeMandante, nomeVisitante);
        if (posicao == -1) {
            System.out.println("Jogo não encontrado");
            return null;
        }
        return jogos[posicao];
    }

    public int pesquisarJogoPorTimes(Jogo[] jogos, String nomeMandante, String nomeVisitante) {
        int posicao = -1;
        for (int j = 0; j < jogos.length; j++) {
            if (jogos[j] != null && jogos[j].mandante.nome.equals(nomeMandante) && jogos[j].visitante.nome.equals(nomeVisitante)) {
                posicao = j;
                break;
            }
        }
        return posicao;
    }

    public int pesquisarJogoPorTimes(Jogo[] jogos, String nomeTime) {
        int posicao = -1;
        for (int j = 0; j < jogos.length; j++) {
            if (jogos[j] != null && (jogos[j].mandante.nome.equals(nomeTime) || jogos[j].visitante.nome.equals(nomeTime))) {
                posicao = j;
                break;
            }
        }
        return posicao;
    }

    public String lerNomeTimeMandante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do time mandante: ");
        return scanner.nextLine();
    }

    public String lerNomeTimeVisitante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do time visitante: ");
        return scanner.nextLine();
    }

    private int lerGolsTimeMandante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o número de gols do time mandante: ");
        return scanner.nextInt();
    }

    private int lerGolsTimeVisitante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o número de gols do time visitante: ");
        return scanner.nextInt();
    }

}