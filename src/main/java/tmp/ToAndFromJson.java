package tmp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.Arrays.asList;

@Data
@AllArgsConstructor
@NoArgsConstructor
class P {
    int a, b;
}

public class ToAndFromJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper m = new ObjectMapper();
        List<P> w = asList(new P(1, 2), new P(2, 3));
        String json = m.writeValueAsString(w);

        List<P> ww = m.readValue(json, new TypeReference<List<P>>(){});

        for(P x : ww) System.out.println(x);

    }
}
