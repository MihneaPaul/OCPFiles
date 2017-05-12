import java.io.File;

/**
 * Created by Mihnea on 01.05.2017.
 */
public class ReadFileInformation {
    public static void main(String[] args) {
        File file = new File("C:\\Fast\\Files\\");
        System.out.println("File Exists: "+file.exists());
        if(file.exists()) {
            System.out.println("Absolute path: "+file.getAbsolutePath());
            System.out.println("Is directory: "+file.isDirectory());
            System.out.println("Parent path: "+file.getParent());
            if(file.isFile()) {
                System.out.println("File size: "+file.length());
                System.out.println("File Last Modified: "+file.lastModified());
            } else {
                for(File subfile : file.listFiles()) {
                    System.out.println("\t"+subfile.getName());
                }
            }
        }
    }
}
