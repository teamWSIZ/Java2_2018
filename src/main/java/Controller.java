import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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

    public void initialize() throws Exception {
        Image image = new Image(getClass().getResourceAsStream("down.png"), 64, 64, true, true);
        start.setGraphic(new ImageView(image));

        loadUsername();

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

    public void saveUsername() throws Exception {
        String text = username.getText();
        Files.asCharSink(new File("user_data.json"), Charsets.UTF_8).write(text);
    }

    public void loadUsername() {
        String zPliku = null;
        try {
            zPliku = Files.asCharSource(new File("user_data.json"), Charsets.UTF_8)
                    .read();
        } catch (IOException e) {
        }
        username.setText(zPliku);
    }

}
