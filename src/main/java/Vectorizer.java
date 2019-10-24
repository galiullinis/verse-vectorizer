import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vectorizer {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        TextParser textParser = new TextParser("src/main/resources/txt_files/verse(7).txt");
        textParser.readText();
        System.out.println(textParser.getLineLength());
        System.out.println(textParser.getRhymeCoef());
        System.out.println(textParser.getTextVolume());
        long stop = System.currentTimeMillis() - start;
        System.out.println("Spend time: " + stop);
    }
}