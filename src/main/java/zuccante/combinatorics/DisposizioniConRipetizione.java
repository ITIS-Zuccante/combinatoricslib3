package zuccante.combinatorics;

import java.util.Arrays;

/**
 * DisposizioniConRipetizione semplici - D(n,k)
 * Definizione: Dati n elementi distinti e un numero k<=n si dicono disposizioni di questi n elementi
 * in classe k, tutte le sequenze di lunghezza k che si possono formare scegliendo k elementi tra gli n dati.
 * Si noti che due disposizioni possono differire fra loro per qualche elemento oppure
 * per l'ordine in cui gli stessi elementi sono disposti.
 *
 * Calcolo delle disposizioni semplici.
 *
 * D(n,k) = n(n-1)(n-2)...(n-k+1)
 *
 *
 */
public class DisposizioniConRipetizione {
  private int k;
  private int n;
  private int[] sequenza_finale;
  private int[] sequenza_corrente;
  private char[] alfabeto;
  private int[] uno;

  public DisposizioniConRipetizione(char[] alfabeto, int k){
    this(alfabeto.length, k);
    this.alfabeto = alfabeto;
  }

  public DisposizioniConRipetizione(int n, int k){
    this.k = k;
    this.n = n;
    sequenza_finale = new int[k];
    for (int i = 0; i < k; i++){
      sequenza_finale[i] = this.n -1;
    }
    sequenza_corrente = new int[this.k];
    uno = new int[k];
    uno[k-1] = 1;
  }

  private int[] sommaDisposizioni(int[] disposizione1, int[] disposizione2) {
    int riporto = 0;
    int somma = 0;
    int[] ris = new int[k];

    for(int i = k-1; i >= 0; i--){
      somma = (disposizione1[i]+disposizione2[i]+riporto)% n;
      riporto = (disposizione1[i]+disposizione2[i]+riporto)/ n;
      ris[i] = somma;
    }
    return ris;
  }

  public int[] successiva(int[] permutazione) {
    return sommaDisposizioni(permutazione, uno);
  }

  public boolean hasNext() {
    return !Arrays.equals(sequenza_corrente, sequenza_finale);
  }

  public int[] next() {
    sequenza_corrente = successiva(sequenza_corrente);
    return sequenza_corrente;
  }

  public String getDisposizione(){
    char[] risultato = new char[k];
    for (int i = 0; i < k; i++){
      risultato[i] = alfabeto[sequenza_corrente[i]];
    }
    return new String(risultato);
  }

} // fine classe
