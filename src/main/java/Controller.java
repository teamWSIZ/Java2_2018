import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tmp.Article;

import java.io.File;
import java.io.IOException;


public class Controller {
    @FXML
    TextField in;

    @FXML
    TextField out;

    @FXML
    Button start;

    @FXML
    Stage stage;

    @FXML
    TextField username;
    @FXML
    TextField title;
    @FXML
    TextArea content;

    @FXML
    ComboBox<Article> combo;

    public void initialize() throws Exception {
        Image image = new Image(getClass().getResourceAsStream("down.png"), 64, 64, true, true);
        start.setGraphic(new ImageView(image));

        loadArticle();

        ///filling combo
        ObservableList<Article> data =
                FXCollections.observableArrayList(
                        new Article("aa", "aa", "aa"),
                        new Article("bb", "aa", "aa"),
                        new Article("cc", "aa", "aa")
                );
        combo.setItems(data);
        combo.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });


    }


    public void openFromFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Otwórz plik...");
        File f = chooser.showOpenDialog(stage);
        if (f!=null) {
            //ładowanie z pliku...
        }
    }

    public void checkIt() {
        String wpisany = in.getText();
        if (countWordsInString(wpisany)!=2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Zły input");
            alert.setHeaderText("Złe dane");
            alert.setContentText("Wprowadzono złe dane; " +
                    "wymagany format to dwa słowa oddzielone przecinkiem");

            alert.showAndWait();
        }
    }

    private int countWordsInString(String w) {
        Iterable<String> splitted =
                Splitter.on(",").omitEmptyStrings().trimResults().split(w);

        int x = 0;
        for(String s : splitted) {
            x++;
        }
        return x;
    }

    public void saveArticle() throws Exception {
        String user = username.getText();
        String artTitle = title.getText();
        String artContent = content.getText();

        Article a = new Article(user, artTitle, artContent);

        //kopia z przykładu zapisywania
        //Zamiana na String
        ObjectMapper mapper = new ObjectMapper();
        String artykulTekstowy = mapper.writeValueAsString(a);

        //Zapis do pliku
        Files.asCharSink(new File("articleABC.json"),
                Charsets.UTF_8).write(artykulTekstowy);

    }

    public void loadArticle() throws Exception {
        //przekopiowane z przykładu:
        //Wczytać string z dysku
        String loaded = Files.asCharSource(
                new File("articleABC.json"), Charsets.UTF_8)
                .read();

        //Zamienić string na Article
        ObjectMapper mapper = new ObjectMapper();
        Article a = mapper.readValue(loaded, Article.class);

        //wrzucanie treści wczytanego artykułu do GUI
        username.setText(a.getAuthor());
        title.setText(a.getTitle());
        content.setText(a.getContent());
    }

}
