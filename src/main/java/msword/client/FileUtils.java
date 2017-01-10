package msword.client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {

    public static File createTempFile(String prefix, String postfix, byte[] content) throws IOException {
        File file = File.createTempFile(prefix, postfix);
        OutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(content);
        stream.flush();
        stream.close();
        return file;
    }

}