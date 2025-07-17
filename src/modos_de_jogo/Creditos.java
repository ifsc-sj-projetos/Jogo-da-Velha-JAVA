package src.modos_de_jogo;

import java.util.Scanner;

public class Creditos {
    Scanner scanner = new Scanner(System.in);

    public void exibirCreditos() {
        System.out.println("-=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=");
        System.out.println("Jogo feito por: Eduardo Cardoso e Talles Souza");
        System.out.println("Disciplina: Pensamento Computacional e Algoritmos");
        System.out.println("-=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=\n");

        System.out.println("Aperte enter para sair");
        scanner.nextLine();

        limparTela();
    }

    public void limparTela() {
        System.out.print("\n\n\n\n\n\n");
    }
}
