package konkurs2;

/**
 * Trzech jurorów, Alicja, Bob i Cecylia oceniają konkurs zamków na piasku;
 * Każdy z jurorów podaje numery zamków które najbardziej mu się podobają.
 * W konkursie bierze udział 25 zamków, ponumerowanych 0..24
 *
 * Każdy z jurorów poda tą samą liczbę wytypowanych zamków.
 *
 * Sprawdzić które z zamków zostały wybrane przez wszystkich trzech jurorów równocześnie!
 *
 * Przykład:
 * a = {2, 3, 8, 5, 10}
 * b = {3, 4, 12, 18, 8}
 * c = {8, 6, 5, 4, 3}
 *
 * --> 3, 8
 */

public class Konkurs {


    public static void wspolne(int[] a, int[] b, int[] c) {
        //wypisać elementy występujące w a, b i c jednocześnie
        int[] wynik = new int[25];
        for (int i = 0; i < a.length; i++) {
            int a_wybral = a[i];
            wynik[a_wybral]++;

            int b_wybral = b[i];
            wynik[b_wybral]++;

            int c_wybral = c[i];
            wynik[c_wybral]++;
        }

        for (int i = 0; i < wynik.length; i++) {
            if (wynik[i]==3) System.out.print(i + " ");
        }
        System.out.println("-----");

    }

    public static void przykladyTablic() {
        int[] a = {2, 5, 7, 9}; //tablica z 4ma elementami

        int[] duza = new int[1000]; //tablica z 1000cem zer

        System.out.println(a[2]);   //odczyt
        a[3] = 111; //zapis
        System.out.println(a[111]);
        System.out.println(a.length);   //długość
    }

    public static void main(String[] args) {
        wspolne(new int[]{1,2,3}, new int[]{2,12,22}, new int[]{1,11,21});  //nie ma wspólnych
        wspolne(new int[]{1,2}, new int[]{1,4}, new int[]{1,3});  //1
        wspolne(new int[]{1,2,3}, new int[]{2,3,4}, new int[]{2,3,5});  //2, 3
    }
}
