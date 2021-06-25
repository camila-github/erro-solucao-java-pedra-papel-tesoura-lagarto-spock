## Exercicio (Java):  Pedra, Papel, Tesoura, Lagarto e Spock

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Introdução a Busca e Substituição em Java 
(https://digitalinnovation.one)


#### Descrição do Desafio:

Pedra-papel-tesoura-lagarto-Spock é uma expansão do clássico método de seleção em jogo de pedra-papel-tesoura. Atua sob o mesmo princípio básico, mas inclui outras duas armas adicionais: o lagarto (formado pela mão igual a uma boca de fantoche) e Spock (formada pela saudação dos vulcanos em Star Trek). Isso reduz as chances de uma rodada terminar em um empate. O jogo foi inventado por Sam Kass e Karen Bryla, como "Rock Paper Scissors Lizard Spock". As regras de vantagem são as seguintes:

- Tesoura corta papel
- Papel cobre pedra
- Pedra derruba lagarto
- Lagarto adormece Spock
- Spock derrete tesoura
- Tesoura prende lagarto
- Lagarto come papel
- Papel refuta Spock
- Spock vaporiza pedra
- Pedra quebra tesoura

Um dia, duas amigas, Fernanda e Marcia, decidiram apostar quem pagaria um almoço para o outro, com esta brincadeira. Sua missão será fazer um algoritmo que, baseado no que eles escolherem, informe quem irá ganhar ou se dará empate.

#### Entrada: 

Haverá diversos casos de teste. O primeiro número a ser lido será um inteiro, representando a quantidade de casos de teste. Cada caso de teste tem duas palavras, representando a escolha de Fernanda e de Marcia, respectivamente.

#### Saída: 

Para cada caso de teste, imprima quem venceu, ou se houve empate.

Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
3 | empate
spock spock | Marcia
tesoura spock | Fernanda
lagarto spock |


#### Java　

```java
//SOLUCAO 1

import java.util.*;

public class PedraPapelTesouraLagartoSpock {
    public static void main(String[] args) {
      Scanner scr = new Scanner(System.in);
      int quantJogadas = scr.nextInt();
        
      scr.nextLine();
      List<Regra> regras = new ArrayList<>();
      regras.add(new Regra("tesoura", "papel"));
      regras.add(new Regra("papel", "pedra"));
      regras.add(new Regra("pedra", "lagarto"));
      regras.add(new Regra("lagarto", "spock"));
      regras.add(new Regra("spock", "tesoura"));
      regras.add(new Regra("tesoura", "lagarto"));
      regras.add(new Regra("lagarto", "papel"));
      regras.add(new Regra("papel", "spock"));
      regras.add(new Regra("spock", "pedra"));
      regras.add(new Regra("pedra", "tesoura"));
        
      for (int i = 0; i < quantJogadas; i++) {
        List<String> jogadas = Arrays.asList(scr.nextLine().split(" "));
            
        if(jogadas.get(0).equals(jogadas.get(1))){
          System.out.println("empate");
        } else {
          boolean primeiroJogador = false;
          for (Regra regra : regras) {
            if (regra.vence.equals(jogadas.get(0)) && 
                regra.perde.equals(jogadas.get(1))) {
                  primeiroJogador = true;
                  break;
            }
          }
           System.out.println(primeiroJogador ? "fernanda" : "marcia");
        }
      }
    }
    
    public static class Regra {
      private String vence, perde;
      public Regra(String vence, String perde) {
        this.vence = vence;
        this.perde = perde;
      }
    }
}

```

