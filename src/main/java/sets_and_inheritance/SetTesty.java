package sets_and_inheritance;

import java.util.*;

import static com.google.common.primitives.Ints.asList;


class BBSet<E> extends HashSet<E> {
    @Override
    public boolean add(E o) {
        System.out.println("Dodajemy do zbioru element: " + o);
        return super.add(o);
    }
}


public class SetTesty {
    public static void main(String[] args) {
        /*
         * Dana jest lista liczb,
         * trzeba znaleźć trzy największe z nich, ale unikalne;
         *
         * przykład:
         * 1, 1, 2, 2, 3, 3, 4, 4   --> 4, 3, 2
         */

        Set<Integer> visited = new BBSet<>();  //

        System.out.println(visited.size()); //ile elementów
        System.out.println(visited.contains(5));    //czy element "5" jest w zbiorze

        visited.add(7);     //dorzucamy "7" do zbioru
        visited.add(5);
        visited.remove(7);  //wyrzucamy "7" ze zbioru

        System.out.println(visited.contains(5));  //true
        visited.add(4);
        visited.add(4);
        visited.add(4);
        System.out.println(visited);
        ///
        System.out.println("-----------------");

        List<Integer> w = asList(4, 5, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        //sortowanie listy:
//        Collections.sort(w);
        //obrócenie listy
//        Collections.reverse(w);


        //rozwiązanie
        //unikalne elementy
        Set<Integer> ww = new HashSet<>();
        for(int x : w) {
            ww.add(x);
        }
        System.out.println(ww);
        ArrayList<Integer> listaUnikalnych = new ArrayList<>(ww);
        Collections.sort(listaUnikalnych);
        Collections.reverse(listaUnikalnych);
        for (int i = 0; i < 3; i++) {
            System.out.println("-->" + listaUnikalnych.get(i));
        }

    }
}
