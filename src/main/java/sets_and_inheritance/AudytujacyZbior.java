package sets_and_inheritance;


import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class MyAuditingSet<E> extends HashSet<E> {
    @Override
    public boolean add(E e) {
        try {
            Files.asCharSink(new File("audyt.log"), Charsets.UTF_8, FileWriteMode.APPEND)
                    .write("Dodaję element " + e + "\n");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        try {
            Files.asCharSink(new File("audyt.log"), Charsets.UTF_8, FileWriteMode.APPEND)
                    .write("Usuwam element " + o + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.remove(o);
    }
}



public class AudytujacyZbior {

    public static void main(String[] args) throws Exception {
//        String jakisNapis = "jakisNapis\n";
//
//        Files.asCharSink(new File("audyt.log"), Charsets.UTF_8, FileWriteMode.APPEND)
//                .write(jakisNapis);

        long start = System.currentTimeMillis();
        Set<Integer> s = new MyAuditingSet<>();
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            if (i%2==0) {
                s.add(r.nextInt(1000));
            } else {
                s.remove(r.nextInt(1000));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("100000 modyfikacji zajęło: " + (end-start) + " ms");

    }
}
