package src.modos_de_jogo;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelhaComputador {

    private char[][] matriz;
    private char simboloJogador;
    private char simboloComputador;
    private final Random random = new Random(); // Para as jogadas aleatórias do computador

    public void inicializaçãoMatriz() {
        // Lógica do Jogo Base
        this.matriz = new char[3][3];
        valoresNaMatriz();
    }

    private void valoresNaMatriz() {
        // Lógica do Jogo Base
        int contador = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Character.forDigit(contador, 10);
                contador++;
            }
        }
    }

    public void printTabuleiro() {
        // Lógica do Jogo Base
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public char verificaResultado() {
        // Lógica do Jogo Base
        // Verificação de linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2]) {
                if (matriz[i][0] == 'X' || matriz[i][0] == 'O') {
                    return matriz[i][0];
                }
            }
        }

        // Verificação de colunas
        for (int j = 0; j < 3; j++) {
            if (matriz[0][j] == matriz[1][j] && matriz[1][j] == matriz[2][j]) {
                if (matriz[0][j] == 'X' || matriz[0][j] == 'O') {
                    return matriz[0][j];
                }
            }
        }

        // Verificação de diagonais
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            if (matriz[0][0] == 'X' || matriz[0][0] == 'O') {
                return matriz[0][0];
            }
        }
        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
            if (matriz[0][2] == 'X' || matriz[0][2] == 'O') {
                return matriz[0][2];
            }
        }

        // Verificação de empate
        int numCasasOcupadas = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 'X' || matriz[i][j] == 'O') {
                    numCasasOcupadas++;
                }
            }
        }
        if (numCasasOcupadas == 9) {
            return 'E';
        }
        return 'N';
    }

    public boolean jogada(int posicao, char simboloAtual) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(matriz[i][j]) == posicao) {
                    if (matriz[i][j] == 'X' || matriz[i][j] == 'O') {
                        // Mensagem de jogada inválida
                        if (simboloAtual == simboloJogador) {
                            System.out.println("Esta posição já está ocupada. Escolha outra!");
                        }
                        return false;
                    }
                    matriz[i][j] = simboloAtual;
                    return true;
                }
            }
        }
        // Mensagem de jogada inválida
        if (simboloAtual == simboloJogador) {
            System.out.println("Esta posição já está ocupada. Escolha outra!");
        }
        return false;
    }

    public void limparTela() {
        // Lógica do Jogo Base
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void executarJogo() {
        Scanner scanner = new Scanner(System.in);

        String playerNome;
        int posicao;
        char resultado = 0;
        boolean jogoTerminou = false;
        boolean jogadaFeita;
        char jogadorAtual;

        // You can let the user choose if they want to be 'X' or 'O' here
        System.out.println("""
                           =-==-=-==-=-==-=-==-=-==-=-==-=-==
                            Bem vindo ao jogo da velha contra o computador!
                            Digite seu nome abaixo
                           =-==-=-==-=-==-=-==-=-==-=-==-=-==""");
        System.out.print("""
                         Seu nome:
                         --> """);
        playerNome = scanner.nextLine();

        System.out.print("Deseja jogar com 'X' ou 'O'? (Digite X ou O): ");
        String escolha = scanner.nextLine().toUpperCase();
        switch (escolha) {
            case "X" -> {
                simboloJogador = 'X';
                simboloComputador = 'O';
                jogadorAtual = 'X'; // O Jogador começa
            }
            case "O" -> {
                simboloJogador = 'O';
                simboloComputador = 'X';
                jogadorAtual = 'X'; // O Computador começa
            }
            default -> {
                System.out.println("Escolha inválida. Jogando com 'X' para você e 'O' para o computador.");
                simboloJogador = 'X';
                simboloComputador = 'O';
                jogadorAtual = 'X'; // O Jogador começa. Manda aquela mensagem de erro se o jogador escolher errado
            }
        }

        System.out.println("Aperte enter para iniciar o jogo");
        scanner.nextLine();

        limparTela();
        inicializaçãoMatriz();
        while (!jogoTerminou) {
            printTabuleiro();

            if (jogadorAtual == simboloJogador) {
                System.out.println("Sua vez de jogar " + playerNome + " (" + simboloJogador + ")");
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
                        scanner.next();
                    }
                }
                jogadaFeita = jogada(posicao, simboloJogador);
                if (jogadaFeita) {
                    resultado = verificaResultado();
                    if (resultado != 'N') {
                        jogoTerminou = true;
                    } else {
                        limparTela();
                        jogadorAtual = simboloComputador; // Muda para a vez do computador
                    }
                }
            } else { // Vez do computador
                System.out.println("Vez do computador (" + simboloComputador + ")");
                // Colocando a lógica do computador para jogar
                jogadaFeita = jogadaComputador(simboloComputador); // Chamando o método que faz a jogada do computador
                if (jogadaFeita) {
                    resultado = verificaResultado();
                    if (resultado != 'N') {
                        jogoTerminou = true;
                    } else {
                        limparTela();
                        jogadorAtual = simboloJogador; // Muda para a vez do jogador
                    }
                }
            }

            if (jogoTerminou) {
                limparTela();
                printTabuleiro();
                if (resultado == simboloJogador) {
                    System.out.println("\nParabéns, " + playerNome + " (" + simboloJogador + ") você venceu!");
                } else if (resultado == simboloComputador) {
                    System.out.println("\nO computador (" + simboloComputador + ") venceu! Mais sorte na próxima vez.");
                } else if (resultado == 'E') {
                    System.out.println("\n🤝🤝 Velha! Ninguém venceu. 🤝🤝");
                }
            }
        }
        System.out.println("Jogo encerrado. Obrigado por jogar!\n");
        System.out.println("Aperte enter para voltar ao menu do jogo");
        scanner.nextLine();
        scanner.nextLine(); // Para esperar o usuário pressionar enter antes de sair
    }

    private boolean jogadaComputador(char simboloComputador) {
        // Lógica para a jogada do computador escolher uma posição aleatória do tabuleiro
        int posicaoComputador;
        boolean valido = false;
        while (!valido) {
            posicaoComputador = random.nextInt(9) + 1; // Gera um número entre 1 e 9
            valido = jogada(posicaoComputador, simboloComputador);
        }
        return true; // Coputador fez uma jogada válida
    }
}
