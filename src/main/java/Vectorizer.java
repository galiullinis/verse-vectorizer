import java.io.*;
import java.util.List;

public class Vectorizer {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<String> fileNames = Action.parseDirectory("C:\\Users\\User\\IdeaProjects\\vectorizer\\src\\main\\resources\\txt_files");
        Action.createVectors(fileNames, "not_verse");
        long stop = System.currentTimeMillis() - start;
        System.out.println("Spend time: " + stop);
    }
}