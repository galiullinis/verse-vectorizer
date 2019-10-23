import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vectorizer {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/txt_files/verse(1).txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        String hs;
        List<Character> lastChars = new ArrayList<>();
        int linesCount = 0;
        // normalize every line in file
        // delete punctuations
        // to get last char to find a rhyme
        while (( s = br.readLine()) != null ){
            linesCount += 1;
            hs = s.replaceAll("\\p{Punct}", "");
            hs = hs.replaceAll("[—»]", "");
            if (hs.charAt(hs.length() - 1) == ' ') {
                hs = hs.substring(0, hs.length() - 1);
            }
            lastChars.add(hs.charAt(hs.length() - 1));
        }
        int rhymeCount = 0;
        for (int i = 0; i < lastChars.size() - 2; i++){
            System.out.println(lastChars.get(i));
            System.out.println(lastChars.get(i+1));
            if (lastChars.get(i).equals(lastChars.get(i+1))){
                rhymeCount++;
            } else if (lastChars.get(i).equals(lastChars.get(i+2))){
                rhymeCount++;
            }
        }
        System.out.println(lastChars);
        System.out.println(rhymeCount);
        System.out.println(linesCount);
        System.out.println((float) Math.round(((float) linesCount/rhymeCount) * 100) / 100);
    }
}