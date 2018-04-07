package tmp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Produkt {
    String serial;
    String nazwa;
    String opis;

    public Produkt(String serial, String nazwa, String opis) {
        this.serial = serial;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "serial='" + serial + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}


public class FilesExample {
    public static void main(String[] args) throws Exception {
        Produkt p = new Produkt("X1002123", "Suszarka", "Super Whrillwind ++");
        Produkt d = new Produkt("X1002124", "Suszarka zwykła", "Whrillwind regular");
        System.out.println(p);
        System.out.println(d);

        List<Produkt> produkts = new ArrayList<>();
        produkts.add(p);
        produkts.add(d);

        System.out.println(produkts);

        //zamiana listy produktów na String
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produkts);

        //zapis do pliku
        System.out.println("Json : " + json);
        System.out.println("Zapisuję do pliku:");
        Files.asCharSink(new File("produkty.json"), Charsets.UTF_8).write(json);

        //odczyt Stringa z pliku
        String odczytany =  Files.asCharSource(new File("produkty.json"), Charsets.UTF_8)
                .read();

        //zamaina json-a na listę produktów
        List<Produkt> odczynataLista = mapper.readValue(odczytany, List.class);
        System.out.println("Odczytana:" + odczynataLista);

    }
}
