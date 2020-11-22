package br.edu.univas;

import java.util.Scanner;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Time;

public class Main {

    private static Menu menu = new Menu();
    private static GerenciamentoTime gerenciamentoTime = new GerenciamentoTime();
    private static GerenciamentoJogo gerenciamentoJogo = new GerenciamentoJogo();
    private static Jogo[] jogos = new Jogo[50];
    private static Time[] times = new Time[50];
    private static int i = 0;
    private static int j = 0;
    private static Scanner leitura = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = menu.mostrarMenu();
        executarOpcao(opcao);
    }

    public static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarTime();
                break;
            case 2:
                alterarTime();
                break;
            case 3:
                apagarTime();
                break;
            case 4:
                cadastrarJogo();
                break;
            case 5:
                alterarJogo();
                break;
            case 6:
                apagarJogo();
                break;
            case 7:
                listarClassificacao();
                break;
            case 8:
                System.out.println("Finalizando a aplicação.");
                System.exit(0);
                leitura.close();
                break;
            default:
                System.out.println("Opção inválida");
        }
        mostarMenu();
    }

    private static void mostarMenu() {
        int opcao = menu.mostrarMenu();
        executarOpcao(opcao);
    }

    private static void cadastrarTime() {
        Time time = gerenciamentoTime.cadastrarTime();
        times[i] = time;
        i++;
    }

    private static void alterarTime() {
        System.out.println("Digite o nome do time que deseja alterar:");
        String nomeProcurado = leitura.nextLine();
        int posicao = gerenciamentoTime.pesquisarTimePorNome(times, nomeProcurado);
        if (posicao == -1) {
            System.out.println("Time não encontrado.");
        } else {
            times[posicao] = gerenciamentoTime.editarTime(times[posicao]);
        }
    }

    private static void apagarTime() {
        System.out.println("Digite o nome do time que deseja apagar:");
        String nomeProcurado = leitura.nextLine();
        int posicao = gerenciamentoTime.pesquisarTimePorNome(times, nomeProcurado);
        if (posicao == -1) {
            System.out.println("Time não encontrado.");
        } else {
            if (gerenciamentoJogo.pesquisarJogoPorTimes(jogos, nomeProcurado) == -1) {
                times[posicao] = null;
                System.out.println("Time apagado com sucesso!");
            } else {
                System.out.println("Time não pode ser apagado, pois já existe um jogo cadastrado com o time.");
            }
        }
    }

    private static void cadastrarJogo() {
        String nomeTimeMandante = gerenciamentoJogo.lerNomeTimeMandante();
        Time mandante = gerenciamentoTime.pesquisarTime(times, nomeTimeMandante);
        if (mandante != null) {
            String nomeTimeVisitante = gerenciamentoJogo.lerNomeTimeVisitante();
            Time visitante = gerenciamentoTime.pesquisarTime(times, nomeTimeVisitante);
            if (visitante != null) {
                Jogo jogo = gerenciamentoJogo.cadastrarJogo(mandante, visitante);
                jogos[j] = jogo;
                j++;
            }
        }
    }

    private static void alterarJogo() {
        String nomeTimeMandante = gerenciamentoJogo.lerNomeTimeMandante();
        String nomeTimeVisitante = gerenciamentoJogo.lerNomeTimeVisitante();
        Jogo jogo = gerenciamentoJogo.pesquisarJogo(jogos, nomeTimeMandante, nomeTimeVisitante);
        if (jogo != null) {
            gerenciamentoJogo.alterarJogo(jogo);
        }
    }

    private static void apagarJogo() {
        String nomeTimeMandante = gerenciamentoJogo.lerNomeTimeMandante();
        String nomeTimeVisitante = gerenciamentoJogo.lerNomeTimeVisitante();
        int posicao = gerenciamentoJogo.pesquisarJogoPorTimes(jogos, nomeTimeMandante, nomeTimeVisitante);
        if (posicao == -1) {
            System.out.println("Jogo não encontrado.");
        } else {
            jogos[posicao] = null;
        }
    }

    private static void listarClassificacao() {
        ordenarClassificacao();
        for (int i = 0; i < times.length; i++) {
            if (times[i] != null) {
                System.out.println(times[i].nome + "-" + times[i].pontos + " pontos - " + times[i].saldoGols + " de saldo de gols");
            }
        }
    }

    private static void ordenarClassificacao() {
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length; j++) {
                if (times[i] != null && times[j] != null && ((times[i].pontos > times[j].pontos)
                        || (times[i].pontos == times[j].pontos && times[i].saldoGols > times[j].saldoGols))) {
                    Time aux = times[i];
                    times[i] = times[j];
                    times[j] = aux;
                }
            }
        }
    }

}
