<p align="center">
<img src="Images/ifsc-logo.png" width="180" height="180">
</p>

**INSTITUTO FEDERAL DE SANTA CATARINA** Análise e Desenvolvimento de Sistemas - 1ª fase  
ALG786201 - Pensamento Computacional e Algoritmos  
**Professor:** Ramon Mayor Martins  
**Discentes:** Eduardo Cardoso Oliveira e Talles Souza da Cruz

---

<h1 align="center">Jogo da Velha em Java</h1>

## Tópicos

- [Introdução](#1-introdução)
- [Como Rodar o Jogo](#como-rodar-o-jogo)
- [Objetivos da Atividade](#2-objetivos-da-atividade)
- [Descrição da Atividade](#3-descrição-das-atividades)
- [Estrutura do jogo](#4-estrutura-do-jogo)
- [Conclusão](#5-conclusão)

## 1. Introdução

<p align="justify"> &emsp; O projeto se refere à atividade avaliativa da disciplina de Pensamento Computacional e Algoritmos.</p>
<p align="justify"> &emsp; Foi desenvolvido um jogo na linguagem de programação Java, utilizando os conceitos de Algoritmo e Programação Orientada a Objetos.</p>

### Tecnologias utilizadas

<p display="inline-block">
<img width="32" src="Images/git.png" alt="GitLogo.png">
<img width="32" src="Images/github(1).png" alt="GitHubLogo.png">
<img width="32" src="Images/java.png" alt="JavaLogo.png">
</p>

## Como Rodar o Jogo

Para executar o jogo em seu ambiente local, siga os passos abaixo:

1.  **Pré-requisitos:** Certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado em sua máquina.
2.  **Clonar o Repositório:**
    Abra seu terminal ou prompt de comando e execute:
    ```bash
    git clone [https://github.com/SouzaTalles/jogo-da-velha-JAVA.git]
    ```
3.  **Entrar na pasta do projeto:**
    ```bash
    cd jogo-da-velha-JAVA/
    ```
4.  **Executar o Jogo:**
    Você pode rodar o jogo diretamente executando o seguinte comando na raiz do projeto:
    ```bash
    java -cp out/production/jogo-da-velha-JAVA/ src.main.JogoDaVelha
    ```
    * **Nota:** Caso os arquivos `.class` não estejam presentes ou você deseje recompilar o projeto, você pode abri-lo em um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA ou Eclipse e executar a classe `JogoDaVelha` diretamente.

## 2. Objetivos da Atividade

<p align="justify"> &emsp; A atividade realizada tem como objetivo principal o exercício das habilidades de pensamento computacional e algoritmos, bem como a utilização da linguagem de programação Java.</p>

## 3. Descrição das Atividades

<p align="justify"> &emsp; Foi desenvolvido um jogo da velha para ser jogado diretamente no terminal.</p>
<p align="justify"> &emsp; Este projeto possui três modos de jogo: Jogador contra Jogador, Jogador contra Computador e um Modo Infinito.</p>
<p align="justify"> &emsp; No primeiro modo, temos um tabuleiro padrão de jogo da velha 3x3, em que os jogadores jogam um de cada vez e ganha quem conseguir fazer uma sequência de peças iguais na diagonal, horizontal ou vertical.</p>
<p align="justify"> &emsp; Já o segundo modo é contra o computador, o jogador escolhe se vai começar a rodada ou não. O computador joga automaticamente toda vez que chega sua vez e então retorna para o jogador. </p>
<p align="justify"> &emsp; Por fim, o terceiro modo, chamado Modo Infinito, traz um jogo um pouco diferente. É um modo de jogador contra jogador, porém cada um possui apenas 3 peças durante todo o jogo. O objetivo continua o mesmo: fazer uma **sequência** em diagonal, horizontal ou vertical, porém, depois de colocar todas as suas três peças, o jogador irá retirar automaticamente a primeira peça que colocou e irá reposicioná-la em algum outro lugar do tabuleiro. </p>

## 4. Estrutura do jogo

### 4.1 A arquitetura
```
jogo-da-velha-JAVA/ 📂
    ├── Images/ 🖼️
    ├── out/ 
    │   └── production/ 
    │       └── jogo-da-velha-JAVA/ 📁
    │           └── src/ 
    │               ├── main/ 
    │               │   └── JogoDaVelha.class
    │               └── modos_de_jogo/ 
    │                   ├── Creditos.class
    │                   ├── JogoBase.class
    │                   ├── JogoDaVelhaComputador.class
    │                   └── JogoInfinito.class
    ├── README.md
    └── src/ 
        ├── main/ 
        │   └── JogoDaVelha.java 
        └── modos_de_jogo/ 
            ├── Creditos.java 
            ├── JogoBase.java 
            ├── JogoDaVelhaComputador.java 
            └── JogoInfinito.java
```

O projeto "Jogo da Velha JAVA" é estruturado em pacotes, seguindo princípios de Programação Orientada a Objetos para modularidade e organização.

* **`src/main`**: Este pacote contém a classe principal que serve como ponto de entrada para o jogo:
    * `JogoDaVelha.java`: A classe principal que apresenta o menu de seleção de modos de jogo (Jogador vs. Jogador, Jogador vs. Computador, Modo Infinito e Créditos) e orquestra a execução dos diferentes modos.

* **`src/modos_de_jogo`**: Este pacote agrupa as classes que implementam a lógica para cada modo de jogo e funcionalidades auxiliares:
    * `JogoBase.java`: Define a lógica fundamental do jogo da velha para o modo Jogador vs. Jogador, incluindo a inicialização do tabuleiro, impressão, verificação de resultados (vitória, empate) e gerenciamento de jogadas e mudança de jogador.
    * `JogoDaVelhaComputador.java`: Estende ou adapta a lógica de `JogoBase` para o modo Jogador vs. Computador, incorporando a inteligência artificial básica para as jogadas do computador (atualmente aleatórias).
    * `JogoInfinito.java`: Implementa as regras específicas do "Modo Infinito", onde os jogadores têm um número limitado de peças e as mais antigas são removidas para novas jogadas.
    * `Creditos.java`: Exibe as informações sobre os criadores do jogo e a disciplina.

As classes compartilham funcionalidades como `inicializaçãoMatriz()`, `printTabuleiro()`, `verificaResultado()`, `jogada()` e `limparTela()`.

### 4.2 Fluxo de Gameplay

O jogo começa com o menu principal na classe `JogoDaVelha.java`. A partir daí, o fluxo se desdobra conforme a opção escolhida pelo usuário:

1.  **Menu Principal**:
    * Ao iniciar, o console exibe um menu com as opções: "Jogador vs Jogador", "Jogador vs Computador", "Modo Infinito", "Créditos" e "Sair".
    * O usuário insere um número correspondente à opção desejada.
    * Entradas inválidas são detectadas e o usuário é solicitado a tentar novamente.

2.  **Modo Jogador vs Jogador (`JogoBase.java`)**:
    * Os jogadores inserem seus nomes.
    * O tabuleiro 3x3 é inicializado com números de 1 a 9.
    * Os jogadores se revezam inserindo a posição desejada (1-9).
    * A cada jogada, o tabuleiro é atualizado e verificado se há um vencedor ou empate.
    * Mensagens informam sobre posições ocupadas ou jogadas inválidas.
    * O jogo termina quando há um vencedor ou um empate, e uma mensagem final é exibida.
    * Ao final, o usuário pode apertar "enter" para retornar ao menu principal.

3.  **Modo Jogador vs Computador (`JogoDaVelhaComputador.java`)**:
    * O jogador insere seu nome e escolhe jogar com 'X' ou 'O'.
    * O tabuleiro é inicializado.
    * As jogadas se alternam entre o jogador humano e o computador.
    * O computador faz jogadas aleatórias, escolhendo posições vazias.
    * O fluxo de verificação de vitória/empate e mensagens é similar ao `JogoBase`.
    * Ao final, o usuário pode apertar "enter" para retornar ao menu principal.

4.  **Modo Infinito (`JogoInfinito.java`)**:
    * Similar ao modo Jogador vs. Jogador no início, com cadastro de nomes e inicialização do tabuleiro.
    * A diferença principal é que, após cada jogador colocar suas três primeiras peças, a peça mais antiga é automaticamente removida do tabuleiro para permitir uma nova jogada.
    * O objetivo de formar uma sequência de três peças ainda se mantém.
    * O fluxo de verificação de vitória e mensagens é o mesmo.
    * Ao final, o usuário pode apertar "enter" para retornar ao menu principal.

5.  **Créditos (`Creditos.java`)**:
    * Exibe os nomes dos desenvolvedores e a disciplina.
    * Aguarda o usuário pressionar "enter" para retornar ao menu principal.

6.  **Sair**:
    * Encerra a aplicação.

## 5. Conclusão

<p align="justify"> &emsp; A realização da referida atividade avaliativa foi de grande proveito, pois proporcionou pôr em prática todos os conhecimentos obtidos durante o semestre na disciplina. Desta forma, foi um grande exercício das habilidades.</p>
<p align="justify"> &emsp; O projeto foi concluído com sucesso, atendendo às diretrizes desejadas, que era a criação de um jogo da velha com alguns modos de jogo. Há muitas possibilidades de expansão, sendo algumas delas a implementação de novas dificuldades no modo de jogo contra o computador, aumentar o tamanho **do tabuleiro**, dentre outros.</p>
