import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vectorizer {
    public static void main(String[] args) throws IOException {

        TextParser textParser = new TextParser("txt_files/verse(1).txt");
        textParser.readText();
        System.out.println(textParser.getLineLength());
        System.out.println(textParser.getRhymeCoef());
    }
}