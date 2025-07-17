package src.modos_de_jogo;

import java.util.Scanner;

public class JogoInfinito {
    private char[][] matriz;
    private int jogador1;
    private int jogador2;
    private char simbolo;
    private char resultado;
    private int pecasXNoTabuleiro = 0;
    private int pecasONoTabuleiro = 0;
    int[] posicaoAtualX = new int[2];
    int[] posicaoAtualO = new int[2];
    int[] posicaoX1 = {-1, -1};
    int[] posicaoX2 = {-1, -1};
    int[] posicaoX3 = {-1, -1};
    int[] posicaoO1 = {-1, -1};
    int[] posicaoO2 = {-1, -1};
    int[] posicaoO3 = {-1, -1};

    public void inicializaçãoMatriz() {
        this.matriz = new char[3][3];
        this.jogador1 = 1;
        this.jogador2 = 0;
        valoresNaMatriz();
    }

    private void valoresNaMatriz() {
        int contador = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Character.forDigit(contador, 10);
                contador++;
            }
        }
    }

    public void printTabuleiro() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public void mudaJogador() {
        if (jogador1 == 1 && simbolo == 'X') {
            jogador1 = 0;
            jogador2 = 1;
            simbolo = 'O';
        }else if (jogador2 == 1 && simbolo == 'O') {
            jogador2 = 0;
            jogador1 = 1;
            simbolo = 'X';
        }
    }

    public boolean jogada(int posicao) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(matriz[i][j]) == posicao) {
                    if (matriz[i][j] == 'X' || matriz[i][j] == 'O') {
                        System.out.println("Esta posição já está ocupada. Escolha outra!");
                        return false; // Jogada inválida
                    }
                    matriz[i][j] = simbolo; // Atribui o simbolo ('X' ou 'O')

                    if (simbolo == 'X') {
                        posicaoAtualX[0] = i;
                        posicaoAtualX[1] = j;
                        pecasXNoTabuleiro++;
                    }

                    if (simbolo == 'O') {
                        posicaoAtualO[0] = i;
                        posicaoAtualO[1] = j;
                        pecasONoTabuleiro++;
                    }

                    resultado = verificaResultado();

                    if (resultado == 'N') {
                        transferenciaValorDeVariavel();
                    }
                    return true;
                }
            }
        }
        System.out.println("Esta posição já está ocupada. Escolha outra!");
        return false;
    }

    public void transferenciaValorDeVariavel() {
        int linhaRemover;
        int colunaRemover;

        if (simbolo == 'X') {
            posicaoX1[0] = posicaoX2[0];
            posicaoX1[1] = posicaoX2[1];

            posicaoX2[0] = posicaoX3[0];
            posicaoX2[1] = posicaoX3[1];

            posicaoX3[0] = posicaoAtualX[0];
            posicaoX3[1] = posicaoAtualX[1];

            if (pecasXNoTabuleiro > 2) {
                linhaRemover = posicaoX1[0];
                colunaRemover = posicaoX1[1];

                if (linhaRemover != -1 && colunaRemover != -1) {
                    int numeroCasa = linhaRemover * 3 + colunaRemover + 1;
                    matriz[linhaRemover][colunaRemover] = Character.forDigit(numeroCasa, 10);
                    pecasXNoTabuleiro--; // Decrementa, pois uma peça foi removida
                }
            }
        }

        if (simbolo == 'O') {
            posicaoO1[0] = posicaoO2[0];
            posicaoO1[1] = posicaoO2[1];

            posicaoO2[0] = posicaoO3[0];
            posicaoO2[1] = posicaoO3[1];

            posicaoO3[0] = posicaoAtualO[0];
            posicaoO3[1] = posicaoAtualO[1];

            if (pecasONoTabuleiro > 2) {
                linhaRemover = posicaoO1[0];
                colunaRemover = posicaoO1[1];

                if (linhaRemover != -1 && colunaRemover != -1) {
                    int numeroCasa = linhaRemover * 3 + colunaRemover + 1;
                    matriz[linhaRemover][colunaRemover] = Character.forDigit(numeroCasa, 10);
                    pecasONoTabuleiro--;
                }
            }
        }
    }

    public char verificaResultado() { // Retorna 'X', 'O', 'E' (Empate) ou 'N' (Nenhum)
        // Verificação de linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2]) {
                if (matriz[i][0] == 'X' || matriz[i][0] == 'O') { // Garante que não é '1', '2', etc.
                    return matriz[i][0]; // Retorna 'X' ou 'O'
                }
            }
        }

        // Verificação de colunas
        for (int j = 0; j < 3; j++) {
            if (matriz[0][j] == matriz[1][j] && matriz[1][j] == matriz[2][j]) {
                if (matriz[0][j] == 'X' || matriz[0][j] == 'O') {
                    return matriz[0][j]; // Retorna 'X' ou 'O'
                }
            }
        }

        // Verificação de diagonais
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            if (matriz[0][0] == 'X' || matriz[0][0] == 'O') {
                return matriz[0][0]; // Retorna 'X' ou 'O'
            }
        }
        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
            if (matriz[0][2] == 'X' || matriz[0][2] == 'O') {
                return matriz[0][2]; // Retorna 'X' ou 'O'
            }
        }

        return 'N';
    }


    public void limparTela() {
        System.out.print("\n\n\n\n\n\n");
    }

    public void executarJogo() {
        Scanner scanner = new Scanner(System.in);

        String player1;
        String player2;
        int posicao;
        simbolo = 'X';
        boolean jogoTerminou = false;
        boolean jogadaFeita;


        System.out.println("""
                           =-==-=-==-=-==-=-==-=-==-=-==-=-==
                            Bem vindo ao jogo da velha!
                            Cadastre os jogadores abaixo
                           =-==-=-==-=-==-=-==-=-==-=-==-=-==""");
        System.out.print("""
                         Player 1:
                         --> """);
        player1 = scanner.nextLine();
        System.out.print("""
                         Player 2: 
                         --> """);
        player2 = scanner.nextLine();
        System.out.println("Aperte enter para iniciar o jogo");
        scanner.nextLine();

        limparTela();
        inicializaçãoMatriz();
        while (!jogoTerminou) {
            printTabuleiro();
            if (jogador1 == 1) {
                System.out.println("Sua vez de jogar " + player1);
            }else if (jogador2 == 1){
                System.out.println("Sua vez de jogar " + player2);
            }
            System.out.println("Qual posição deseja jogar?");
            posicao = -1;

            while (true) {
                if (scanner.hasNextInt()) {
                    posicao = scanner.nextInt();

                    if (posicao >= 1 && posicao <= 9) {
                        break;
                    } else {
                        System.out.println("Por favor, digite um número entre 1 e 9.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.next(); // Consome a entrada inválida
                }
            }
            jogadaFeita = jogada(posicao);
            if (jogadaFeita) {

                if (resultado == 'X' || resultado == 'O') {
                    limparTela();
                    printTabuleiro();
                    System.out.println("\nParabéns, " + (resultado == 'X' ? player1 : player2) + " (" + resultado + ") você venceu!");
                    jogoTerminou = true;
                }else {
                    limparTela();
                    mudaJogador();
                }
            }else{
                System.out.println("Posição inválida. Tente novamente!");
            }

        }
        System.out.println("Jogo encerrado. Obrigado por jogar!\n");
        System.out.println("Aperte enter para voltar ao menu do jogo");
        scanner.nextLine();
    }
}
