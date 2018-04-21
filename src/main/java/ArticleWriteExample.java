import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import tmp.Article;

import java.io.File;

//Zapisuje artykuł na dysk
public class ArticleWriteExample {
    public static void main(String[] args) throws Exception {
        Article a = new Article(
                "Gall Anonim",
                "Historiae Europeica",
                "Lorem ipsum dolor sit"
        );

        //Zamiana na String
        ObjectMapper mapper = new ObjectMapper();
        String artykulTekstowy = mapper.writeValueAsString(a);

        //Zapis do pliku
        Files.asCharSink(new File("articleABC.json"),
                Charsets.UTF_8).write(artykulTekstowy);
    }
}
