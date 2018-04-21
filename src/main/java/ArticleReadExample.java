import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import tmp.Article;

import java.io.File;

//Wczytuje artykuł z dysku
public class ArticleReadExample {
    public static void main(String[] args) throws Exception {

        //Wczytać string z dysku
        String loaded = Files.asCharSource(
                new File("article1.json"), Charsets.UTF_8)
                .read();

        //Zamienić string na Article
        ObjectMapper mapper = new ObjectMapper();
        Article a = mapper.readValue(loaded, Article.class);

        //wykorzystywać już instancję Article
        System.out.println("Treść artykułu to:" + a.getContent());

    }
}
