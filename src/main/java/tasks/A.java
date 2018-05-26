package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class A {
    public static void main(String[] args) {
        List<Integer> w = Arrays.asList(-10, 2, 7, 4, 6, 12);

        //znaleźć największą...
        int najwieksza = -1000;

        for(int x : w) {
            //x to kolejne elementy listy `w`
//            System.out.println(x);
            najwieksza = Math.max(najwieksza, x);
        }

        System.out.println(najwieksza);

        //niech `w` oznacza cenę akcji spółki WWW; znaleźć największy wzrost
        //tejże ceny (z dnia na dzień);
        //testy
        // (2, 7, 4, 6, 12) --> 6
        // (-10, 2, 7, 4, 6, 12) --> 12
        // (1,2,3,4) --> 1
        // (0,10) --> 10
        // (4,3,2,2) --> 0

        int wzrost = -1000000;
        int poprzednia = 1000000;
        for(int x : w) {
            wzrost = Math.max(wzrost, x - poprzednia);
            poprzednia = x;
        }
        System.out.println("# " + wzrost);


        //znaleźć rosnący podciąg z `w`; czyli np.
        // (2, 7, 4, 6, 12) --> 2, 7, 12
        // (-10, 2, 7, 4, 6, 12) --> -10, 2, 7, 12
        // (1,2,3,4) --> 1,2,3,4
        // (0,10) --> 0,10
        // (4,3,2,2) --> 4

        int best = -1_000_000;
        List<Integer> wynik = new ArrayList<>();
        for(int x : w) {
            if (x > best) {
                wynik.add(x);
                best = x;
            }
        }
        System.out.println(wynik);

    }
}
