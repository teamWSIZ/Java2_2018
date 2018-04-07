package tmp;

import com.google.common.base.Splitter;

public class SplitterExample {
    public static void main(String[] args) {
        String w = "  a, b ,c,,,    , d";

        Iterable<String> splitted =
                Splitter.on(",").omitEmptyStrings().trimResults().split(w);

        System.out.println(splitted);

    }
}
