import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;

public class Controller {
    @FXML
    TextField in;

    @FXML
    TextField out;

    @FXML
    Button start;

    @FXML
    Stage stage;

    public void initialize() {
        //mała ikonka (do zmiany)
        Image image = new Image(getClass().getResourceAsStream("down.png"), 64, 64, true, true);
        start.setGraphic(new ImageView(image));

    }


    public void loadWords(File file) {
        try {
            String result = Files.asCharSource(file, Charsets.UTF_8).read();
            Files.asCharSink(new File("aaa.txt"), Charsets.UTF_8, FileWriteMode.APPEND).write(result);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openFromFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Otwórz plik...");
        File f = chooser.showOpenDialog(stage);
        if (f!=null) loadWords(f);
    }


    public void serializeTest() {
        User u = new User("Abra", "Kadabra");
        Gson gson = new Gson();
        String json = gson.toJson(u);
        System.out.println(json);
        System.out.println("--------------");
        User uu = gson.fromJson(json, User.class);
        System.out.println(uu);

        List<User> w = Arrays.asList(new User("a", "A"), new User("b", "BB"), new User("c", "CCC"));
        String ss = gson.toJson(w);
        System.out.println(ss);
        Set<User> ww = gson.fromJson(ss, Set.class);
        System.out.println(ww);
    }

    public int MX = 200_000;

    public void writeLargeFile() {
        try {
            List<Ent> ents = new ArrayList<>();
            for (int i = 0; i < MX; i++) {
                Ent e = new Ent();
                e.setName(randomUUID().toString());
                List<String> ww = new ArrayList<>();
                for (int j = 0; j < 25; j++) ww.add(randomUUID().toString());
                e.setEnts(ww);
                ents.add(e);
            }
            Gson gson = new Gson();
            long st = currentTimeMillis();
            String json = gson.toJson(ents);
            long js = currentTimeMillis();
            Files.asCharSink(new File("aaa.txt"), Charsets.UTF_8).write(json);
            long en = currentTimeMillis();
            System.out.println(format("Creation: %d [ms], write: %d [ms]; size: %d [kB]", js-st, en-js,
                    json.length()/1000));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readLargeFile() {
        try {
            Gson gson = new Gson();
            long st = currentTimeMillis();
            String json = Files.asCharSource(new File("aaa.txt"), Charsets.UTF_8).read();
            long rd = currentTimeMillis();
            List<Ent> ents = gson.fromJson(json, List.class);
            long js = currentTimeMillis();
            System.out.println(format("Read: %d [ms], parse: %d [ms], size: %d [kB], elems: %d",
                    rd-st, js-rd, json.length()/1000, ents.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeJackson() {
        try {
            List<Ent> ents = new ArrayList<>();
            for (int i = 0; i < MX; i++) {
                Ent e = new Ent();
                e.setName(randomUUID().toString());
                List<String> ww = new ArrayList<>();
                for (int j = 0; j < 25; j++) ww.add(randomUUID().toString());
                e.setEnts(ww);
                ents.add(e);
            }
            ObjectMapper mapper = new ObjectMapper();
            long st = currentTimeMillis();
            String json = mapper.writeValueAsString(ents);
            long js = currentTimeMillis();
            Files.asCharSink(new File("aaa.txt"), Charsets.UTF_8).write(json);
            long en = currentTimeMillis();
            System.out.println(format("Creation: %d [ms], write: %d [ms]; size: %d [kB]", js-st, en-js,
                    json.length()/1000));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readJackson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            long st = currentTimeMillis();
            String json = Files.asCharSource(new File("aaa.txt"), Charsets.UTF_8).read();
            long rd = currentTimeMillis();
            List<Ent> ents = mapper.readValue(json, List.class);
            long js = currentTimeMillis();
            System.out.println(format("Read: %d [ms], parse: %d [ms], size: %d [kB], elems: %d",
                    rd-st, js-rd, json.length()/1000, ents.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
