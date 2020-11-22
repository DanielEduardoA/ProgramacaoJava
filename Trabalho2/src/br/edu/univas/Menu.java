package br.edu.univas;

import java.util.Scanner;

public class Menu {
    @SuppressWarnings("resource")
    public int mostrarMenu() {
        int opcao;
        Scanner leitura = new Scanner(System.in);
        System.out.println("Escolha uma opção");
        System.out.println("-------------------------");
        System.out.println("1 - Cadastrar time");
        System.out.println("2 - Editar time");
        System.out.println("3 - Excluir time");
        System.out.println("4 - Cadastrar jogo");
        System.out.println("5 - Editar jogo");
        System.out.println("6 - Excluir jogo");
        System.out.println("7 - Listar classificação do campeonato");
        System.out.println("8 - Sair");
        System.out.println("-------------------------");

        opcao = leitura.nextInt();
        return opcao;
    }
    
    

}
