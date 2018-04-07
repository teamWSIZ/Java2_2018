package tmp;

import com.google.common.base.Splitter;

import java.util.ArrayList;

public class SplitterExample {
    public static void main(String[] args) {
        String w = "  a, b ,c,,,    , d";

        Iterable<String> splitted =
                Splitter.on(",").omitEmptyStrings().trimResults().split(w);

        int x = 0;
        for(String s : splitted) {
            x++;
        }

        System.out.println(splitted);
        System.out.println("Liczba słów:" + x);

    }
}
