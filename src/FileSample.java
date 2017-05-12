/**
 * Created by Mihnea on 01.05.2017.
 */
import java.io.File;
public class FileSample {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\Mihnea\\IdeaProjects\\OCPFiles\\abc");
        File parent = new File("C:\\Users\\Mihnea\\IdeaProjects");
        File child = new File(parent,"OCPFiles\\abc");
        System.out.println(child.exists());
    }
}
