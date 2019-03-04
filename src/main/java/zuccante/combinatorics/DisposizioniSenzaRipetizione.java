package zuccante.combinatorics;

import java.util.*;

public class DisposizioniSenzaRipetizione {
  private int n;
  private int k;
  private char[] alfabeto;
  Set<Sequenza> sequenze;
  Queue<Chiamata> queue;

  public DisposizioniSenzaRipetizione(char[] alfabeto, int k){
    this(alfabeto.length, k);
    this.alfabeto = alfabeto;
  }

  public DisposizioniSenzaRipetizione(int n, int k){
    this.n = n;
    this.k = k;
    this.sequenze = new TreeSet<>();
    this.queue = new PriorityQueue<>();
  }

  void generaTutte(){
    queue.add(new Chiamata(null, -1, null));
    while (!queue.isEmpty()){
      Chiamata chiamata = queue.poll();
      for (int s = 0; s < n; s++) {
        int[] sequenza = new int[k];
        int[] esclusioni = inizializzaEsclusioni();
        if (chiamata.sequenza != null)
          System.arraycopy(chiamata.sequenza, 0, sequenza, 0, k);
        if (chiamata.esclusioni != null)
          System.arraycopy(chiamata.esclusioni, 0, esclusioni, 0, k);
        if (contiene(esclusioni, s)){
          continue;
        }
        int i = chiamata.posizione;
        if (i == k-1){ // sequenza completata
          sequenza[i] = s;
          sequenze.add(new Sequenza(sequenza));
        } else if (0 <= i && i < k-1){
          sequenza[i] = s;
          esclusioni[i] = s;
          queue.add(new Chiamata(sequenza, i+1, esclusioni));
        } else if (i == -1){
          queue.add(new Chiamata(sequenza, i+1, esclusioni));
        }
      }
    }
  }

  private int[] inizializzaEsclusioni(){
    int[] risultato = new int[k];
    for (int i = 0; i < k; i++) {
      risultato[i] = -1;
    }
    return risultato;
  }

  private boolean contiene(int[] esclusioni, int j){
    for (int i = 0; i < esclusioni.length; i++) {
      if (esclusioni[i] == j)
        return true;
    }
    return false;
  }

  public Set<Sequenza> getSequenze() {
    return sequenze;
  }


  class Chiamata implements Comparable<Chiamata>{
    int[] sequenza;
    int posizione;
    int[] esclusioni;

    public Chiamata(int[] sequenza, int posizione, int[] esclusioni) {
      this.sequenza = sequenza;
      this.posizione = posizione;
      this.esclusioni = esclusioni;
    }

    @Override
    public int compareTo(Chiamata chiamata) {
      if (chiamata.posizione == posizione
      && Arrays.equals(chiamata.sequenza, sequenza)
      && Arrays.equals(chiamata.esclusioni, esclusioni)
      )
        return 0;
      else
        return -1;
    }
  }

  class Sequenza implements Comparable<Sequenza>{
    char[] sequenza;

    public Sequenza(char[] sequenza) {
      this.sequenza = sequenza;
    }

    public Sequenza(int[] sequenza) {
      this.sequenza = new char[k];
      for (int j = 0; j < sequenza.length; j++){
        this.sequenza[j] = alfabeto[sequenza[j]];
      }
    }

    @Override
    public int compareTo(Sequenza s) {
      return (new String(sequenza)).compareTo(new String(s.sequenza));
    }

    public String toString(){
      return new String(sequenza);
    }

  }

} // fine classe
