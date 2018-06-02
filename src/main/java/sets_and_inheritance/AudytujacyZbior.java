package sets_and_inheritance;


import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.util.HashSet;

class MyAuditingSet<E> extends HashSet<E> {
//add
    //remove
}



public class AudytujacyZbior {

    public static void main(String[] args) throws Exception {
        String jakisNapis = "jakisNapis\n";

        Files.asCharSink(new File("audyt.log"), Charsets.UTF_8, FileWriteMode.APPEND)
                .write(jakisNapis);
    }
}
