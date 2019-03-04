package zuccante.combinatorics;

import java.util.Set;

public class DisposizioniSenzaRipetizioneTest {
  private static final char[] alfabeto = new char[]{'a','b','c','d'};
  private static int lunghezza_sequenze = 4;

  public static void main(String[] args){

    DisposizioniSenzaRipetizione disposizioni = new DisposizioniSenzaRipetizione(alfabeto, lunghezza_sequenze);
    disposizioni.generaTutte();
    Set<DisposizioniSenzaRipetizione.Sequenza> insieme = disposizioni.getSequenze();
    for (DisposizioniSenzaRipetizione.Sequenza s: insieme) {
      System.out.println(s.toString());
    }
  }
}// fine classe
