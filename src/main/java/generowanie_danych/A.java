package generowanie_danych;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.HashSet;
import java.util.Set;


public class A {

    //https://en.wikipedia.org/wiki/Birthday_problem
    public static void main(String[] args) {
        int nosob = 10_000_000;
        Set<String> osoby = new HashSet<>();

        DataFactory df = new DataFactory();
        for (int i = 0; i < nosob; i++) {
//            String name = df.getFirstName() + " "+ df.getLastName() + " city: " + df.getCity();
            Person p = new Person(df.getFirstName(), df.getLastName(), df.getEmailAddress());
//            System.out.println(p);
            osoby.add(p.imie + p.nazwisko);
        }

        //zadanie: wygenerujemy 50.000 osób; czy powtarza się imie+nazwisko?

        System.out.println("Unikalnych: " + osoby.size() + " z " + nosob);

    }
}
