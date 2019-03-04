package zuccante.combinatorics;

public class DisposizioniConRipetizioneTest {
  private static final char[] alfabeto = new char[]{'a','b','c','d'};
  private static int lunghezza_sequenze = 3;

  public static void main(String[] args){

    DisposizioniConRipetizione disposizioni = new DisposizioniConRipetizione(alfabeto, lunghezza_sequenze);
    while (disposizioni.hasNext()) {
      System.out.println(disposizioni.getDisposizione());
      disposizioni.next();
    }
    System.out.println(disposizioni.getDisposizione());
  }
}// fine classe
