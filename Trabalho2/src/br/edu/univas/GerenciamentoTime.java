package br.edu.univas;

import java.util.Scanner;

import br.edu.univas.vo.Time;

@SuppressWarnings("resource")
public class GerenciamentoTime {

    public Time cadastrarTime() {
        Time time = new Time();
        String nome = lerNomeTime();
        time.nome = nome;
        time.estadoOrigem = lerEstadoTime();
        System.out.println("Time cadastrado com sucesso!");
        return time;
    }

    public Time editarTime(Time time) {
        String nome = lerNomeTime();
        time.nome = nome;
        time.estadoOrigem = lerEstadoTime();
        System.out.println("Time alterado com sucesso!");
        return time;
    }

    public Time pesquisarTime(Time[] times, String nome) {
        int posicao = pesquisarTimePorNome(times, nome);
        if (posicao == -1) {
            System.out.println("Time não encontrado");
            return null;
        }
        return times[posicao];
    }

    public int pesquisarTimePorNome(Time[] times, String nome) {
        int posicao = -1;
        for (int j = 0; j < times.length; j++) {
            if (times[j] != null && times[j].nome.equals(nome)) {
                posicao = j;
                break;
            }
        }
        return posicao;
    }

    private String lerNomeTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do time: ");
        return scanner.nextLine();
    }

    private String lerEstadoTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o estado de origem do time: ");
        return scanner.nextLine();
    }
}