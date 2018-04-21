package tmp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Przykład zapisu i odczytu z dysku danych (list obiektów typu Produkt)
 */

//Prosta klasa zawierająca jakieś dane
class Produkt {
    String serial;
    String nazwa;
    String opis;

    public Produkt() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return Objects.equals(serial, produkt.serial) &&
                Objects.equals(nazwa, produkt.nazwa) &&
                Objects.equals(opis, produkt.opis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serial, nazwa, opis);
    }
}



public class FilesExample {
    public static void main(String[] args) throws Exception {
        Produkt p = new Produkt("X1002123", "Suszarka", "Super Whrillwind ++");
        Produkt d = new Produkt("X1002124", "Suszarka zwykła", "Whrillwind regular");
        Produkt e = new Produkt("X1002125", "Smartphone", "Samsung Galaxy S9 G960F Dual SIM Midnight Black");

        List<Produkt> produkts = new ArrayList<>();
        produkts.add(p);
        produkts.add(d);
        produkts.add(e);

        System.out.println("Nazwy i opisy dostępnych produktów:");
        for(Produkt pp : produkts) {
            System.out.println(pp.getNazwa() + " opis:" + pp.getOpis());
        }

        System.out.println("-------------------------");


        //zamiana listy produktów na String
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produkts);

        System.out.println("Json z kolekcją produktów: " + json);

        //zamina json-a na listę produktów
        List<Produkt> odczynataLista = mapper.readValue(json, new TypeReference<List<Produkt>>(){});
        System.out.println("Odczytana                 :" + odczynataLista);


        for(Produkt pp : odczynataLista) {
            System.out.println(pp.nazwa);
        }


        //zapis do pliku
        System.out.println("Zapisuję do pliku:");
        Files.asCharSink(new File("produkty.json"), Charsets.UTF_8)
                .write(json);


        //odczyt Stringa z pliku
        String odczytany =  Files.asCharSource(new File("produkty.json"), Charsets.UTF_8)
                .read();

        System.out.println("Json odczytany z pliku: " + odczytany);


    }
}
