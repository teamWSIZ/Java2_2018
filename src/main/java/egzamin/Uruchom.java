package egzamin;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class Uruchom {
    public static void main(String[] args) throws Exception {

        //tworzenie instancji
        YouTubeVideo filmik1 = new YouTubeVideo("Filmik1",
                "https://youtube.com/1", "gg");
        YouTubeVideo filmik2 = new YouTubeVideo("Filmik2",
                "https://youtube.com/1", "gg");

        System.out.println(filmik1);
        System.out.println(filmik2);

        //Zapis do pliku

        Files.asCharSink(new File("important.txt"), Charsets.UTF_8)
                .write("Abra kadabra");

        //Odczyt z pliku

        String odczytany =
                Files.asCharSource(new File("important.txt"),
                        Charsets.UTF_8).read();

        System.out.println("odczytałem: " + odczytany);


    }
}
