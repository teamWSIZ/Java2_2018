package konkurs2;

import java.util.Arrays;

/**
 * W skrytkach typu "multicache" popularnej zabawy geocache,
 *
 * https://www.geocaching.pl/map.php
 *
 * w każdej z odnalezionych skrytek znajdują sie wstazówki o położeniu kolejnej skrytki.
 *
 * Niech nasza mapa będzie tablicą liczb całkowitych, np
 *
 * int[] a = {5, 0, 2, 1, 4, 3}
 *
 * przy czym wszystkie liczby w tablicy są mniejsze niż a.length
 *
 * Nasza podróż po mapie wygląda następująco: rozpoczynamy w lokacji o położeniu "0"; odczytujemy z
 * a[0] położenie następnej skrytki i tam wędrujemy; w powyższym przykładzie jest to "5"; będąc w "5" otwieramy
 * skrytkę i znadujemy "3", co oznacza, że następnym etapem naszej podróży jest "3". Podróżujemy do czasu aż dotrzemy
 * do miejsca w którym już byliśmy.
 *
 * Zadanie polega na sprawdzeniu, czy podczas naszej podróży odwiedziliśmy wszystkie miejsca, tj.
 * 0, 1, 2, 3... , a.length-1
 *
 * (W przykładie powyższym odpowiedź jest "Nie"; odwiedzone miejsca to {0, 5, 3, 1, 0...})
 *
 */

public class MultiGeocache {


    static void znajdzWszystkie(int[] a) {
        rozwiazanieNiePatrzTu(a);
    }

    public static void main(String[] args) {
        znajdzWszystkie(new int[]{5,0,2,1,4,3});    //--> Nie
        znajdzWszystkie(new int[]{1,3,4,5,0,2});    //--> Tak
        znajdzWszystkie(new int[]{0,1,2,3,4,5});    //--> Nie
        znajdzWszystkie(new int[]{1,0,2,3,4,5});    //--> Nie
    }

    static void rozwiazanieNiePatrzTu(int[] a) {
        int n = a.length;
        boolean[] visited = new boolean[n]; // wypełnione samymi 'false'
        int at = 0;
        for (int i = 0; i <= n; i++) {
            visited[at] = true;
            at = a[at];
            if (visited[at]) break; //kończymy pętlę jak trafimy na skrytkę już odwiedzoną
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("Nie odwiedzono skrytki " + i + "! tablica odwiedzonych:" +
                        Arrays.toString(visited));
                return;
            }
        }
        System.out.println("Wszystkie skrytki zostały znalezione!");
    }

}
