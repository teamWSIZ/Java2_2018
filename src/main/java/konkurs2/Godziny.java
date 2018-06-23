package konkurs2;

/**
 * Zadanie: mamy zegar pokazujący wyłącznie godziny (liczby całkowite 0,1,2...,11;
 * godzina 12  oznacza ponownie godzinę 0
 *
 * Napisać funkcję która wyliczy ile godzin (całych) minęło od godziny "from" do godziny
 * "to".
 *
 * Przykłady
 * 2, 5  --> 3
 * 2, 11 --> 9
 * 11, 1 --> 2
 * 10, 3 --> 5
 */

public class Godziny {

    public static int ileGodzin(int from, int to) {
        if (from < to) {
            return to - from;
        } else {
            return 12 - (from - to);
        }
    }

    public static void main(String[] args) {
        System.out.println(ileGodzin(2,5)); //3
        System.out.println(ileGodzin(2,11)); //9
        System.out.println(ileGodzin(11,1)); //2
        System.out.println(ileGodzin(10,3)); //5
    }
}
