package tmp;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Produkt p = new Produkt("aa", "bb", "cc");
        String json = mapper.writeValueAsString(p);

        Produkt p2 = mapper.readValue(json, Produkt.class);
        System.out.println(p2);


    }
}
