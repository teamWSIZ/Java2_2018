package tmp;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SplitterExample {

    static String readWebpage(String url) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
            sb.append('\n');
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String w = "a,c,b";

        Iterable<String> splitted =
                Splitter.on(",").trimResults().omitEmptyStrings().split(w);

        int x = 0;
        for(String s : splitted) {
            System.out.println("Teraz s = " + s);
            x++;
        }

        System.out.println(splitted);
        System.out.println("Liczba słów:" + x);

        System.out.println(readWebpage("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html"));
        
    }
}
