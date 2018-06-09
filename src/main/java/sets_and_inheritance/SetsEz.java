package sets_and_inheritance;

import java.util.HashSet;
import java.util.Set;

public class SetsEz {
    public static void main(String[] args) {
        Set<Integer> liczby = new HashSet<>();

        liczby.add(10);
        liczby.add(15);
        liczby.add(1);
        liczby.add(15);

        System.out.println(liczby);
        System.out.println(liczby.contains(10));
        System.out.println(liczby.contains(7));
    }
}
