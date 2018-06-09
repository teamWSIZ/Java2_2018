package generowanie_danych;

import org.fluttercode.datafactory.impl.DataFactory;



public class A {

    public static void main(String[] args) {
        DataFactory df = new DataFactory();
        for (int i = 0; i < 50; i++) {
//            String name = df.getFirstName() + " "+ df.getLastName() + " city: " + df.getCity();
            Person p = new Person(df.getFirstName(), df.getLastName(), df.getEmailAddress());
            System.out.println(p);
        }

        //zadanie: wygenerujemy 50.000 osób; czy powtarza się imie+nazwisko?


    }
}
