package testy;


class BB {
    String cn;

    void zaloguj() {
        cn = "zalogowany";
    }

    void dodaj() {
        String ccc = "abc";

        System.out.println(cn);
    }
}


public class Obiekty {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.zaloguj();
        bb.dodaj();
    }
}
