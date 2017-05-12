import java.io.*;

/**
 * Created by Mihnea on 02.05.2017.
 */
public class CopyFileSample {
    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File source = new File("abc");
        File destination = new File("ZooCopy1.txt");
        copy(source,destination);
    }
}

class CopyBufferFileSample {
    public static void copy(File source, File destination) throws IOException {
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[]buffer = new byte[1024];
            int lengthRead;
            while((lengthRead=in.read(buffer))>0) {
                out.write(buffer,0,lengthRead);
                out.flush();
            }
        }
    }
}
