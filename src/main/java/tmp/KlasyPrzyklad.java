package tmp;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class OurUser {
    String username;
    String alias;
    int age;

    public OurUser() {
    }

    public OurUser(String username, String alias, int age) {
        this.username = username;
        this.alias = alias;
        this.age = age;
    }

    @Override
    public String toString() {
        return "OurUser{" +
                "username='" + username + '\'' +
                ", alias='" + alias + '\'' +
                ", age=" + age +
                '}';
    }
}

public class KlasyPrzyklad {
    public static void main(String[] args) throws Exception{
        OurUser u1 = new OurUser();
        u1.username = "waynbot";
        u1.alias = "incognito";
        u1.age = -1;

        OurUser u2 = new OurUser();
        u2.username = "Xi Jinping";
        u2.alias = "xij";
        u2.age = 64;

        OurUser u4 = new OurUser("Nicolás Maduro", "niki", 55);

        //pokazywanie userów (działa dzięki funkcji .toString)
        System.out.println(u1);
        System.out.println(u2);

        //tworzenie listy userów
        List<OurUser> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u4);

        System.out.println(users);


        ///Zapis do pliku
        String w = "Abra kadabra!!";
        Files.asCharSink(new File("abra.txt"),
                Charsets.UTF_8).write(w);


    }
}
