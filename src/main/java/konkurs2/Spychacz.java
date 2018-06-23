package konkurs2;

/**
 * Podczas zabawy na plaży dzieciaki wymyśliły ćwiczenie ze spychaczem.
 * Mają dostępne górki pisaku ułożone w rząd, których wysokości są podane.
 *
 * Dwójka dzieci przy pomocy deski symuluje pracę spychacza.
 * Idą oni wzdłuż rzędu górek pisasku i spychają cały piasek znajdujący się powyżej wysokości
 * spychacza "k". Piasek przesypuje się od razu na następną górkę w rzędzie.
 * Praca kończy się na ostatniej górce gdzie cały pozostały piasek pozostaje
 * (jeśli udało się coś zebrać po drodze).
 *
 *
 * Przykład:
 *
 * int[] a = {3, 1, 0, 2, 0, 4, 1, 2, 0}
 * int k -- maksymalna wysokość górek  = 2
 *
 * wynik:
 *           {2, 2, 0, 2, 0, 2, 2, 2, 1}
 */

public class Spychacz {

    static void zepchnij(int[] a, int k) {

        //wypisać wynik do konsoli
    }

    public static void main(String[] args) {
        zepchnij(new int[]{4,2,0}, 2);      // --> 2,2,2
        zepchnij(new int[]{4,0,0}, 2);      // --> 2,2,0
        zepchnij(new int[]{4,3,0}, 2);      // --> 2,2,3    //góra pisasku na końcu zostaje

        zepchnij(new int[]{3, 1, 0, 2, 0, 4, 1, 2, 0}, 2);      // --> {2, 2, 0, 2, 0, 2, 2, 2, 1}



    }
}
