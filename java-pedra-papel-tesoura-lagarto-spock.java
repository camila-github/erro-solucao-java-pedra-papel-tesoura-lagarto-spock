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