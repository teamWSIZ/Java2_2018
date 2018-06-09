package sets_and_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza {

    public static void main(String[] args) {
        List<String> wymagane = Arrays.asList("ciasto", "mozzarella", "salami",
                "oregano");

        List<String> dostepne = Arrays.asList("oregano", "mozzarella", "pieczarki"
                , "boczek", "cebula");

        List<String> brakujace = new ArrayList<>();

        //zadanie: wypisać których z "potrzebnych" składników narazie brakuje
        //zadanie2: stworzyć List<String> brakujace ... która będzie zawierała brakujące składniki

        for(String s : wymagane) {
            System.out.println("--> "  + s);
            /// pytanie: czy "s" jest wewnątrz "dostępne" ???
            int x = 0;
            for(String r : dostepne) {
                if (s.equals(r)) {
                    x++;
                }
            }
            if (x==0) {
                System.out.println("brakuje: "  + s);
                brakujace.add(s);
            }
        }

        System.out.println("Brakujące składniki:" + brakujace);
    }

}
