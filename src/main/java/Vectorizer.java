import java.io.*;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vectorizer {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<String> fileNames = Action.parseDirectory("C:\\Users\\User\\IdeaProjects\\xmlParsing\\txt_files");
        Action.createVectors(fileNames, "not_verse");
        long stop = System.currentTimeMillis() - start;
        System.out.println("Spend time: " + stop);
    }
}