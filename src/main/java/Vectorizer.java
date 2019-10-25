import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vectorizer {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        TextParser textParser = new TextParser("src/main/resources/txt_files/verse(9).txt");
        textParser.readText();
        System.out.println(textParser.getLineLength());
        System.out.println(textParser.getRhymeCoef());
        System.out.println(textParser.getTextVolume());
        System.out.println(textParser.getPunctsCount());

        StringBuilder data = new StringBuilder();
        data.append(textParser.getRhymeCoef());
        data.append(' ');
        data.append(textParser.getLineLength());
        data.append(' ');
        data.append(textParser.getTextVolume());
        data.append(' ');
        data.append(textParser.getPunctsCount());
        data.append(' ');
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        new File("test_file.txt")));
        bufferedWriter.write(data + "first_data");
        bufferedWriter.newLine();
        bufferedWriter.write(data + "second_data");
        bufferedWriter.close();
        long stop = System.currentTimeMillis() - start;
        System.out.println("Spend time: " + stop);
    }
}