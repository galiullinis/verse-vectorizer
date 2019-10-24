import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextParser {
    private String path;
    private int textVolume;
    private int punctsCount;
    private int lineLength;
    private float rhymeCoef;

    public TextParser(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTextVolume() {
        return textVolume;
    }

    public void setTextVolume(int textVolume) {
        this.textVolume = textVolume;
    }

    public int getPunctsCount() {
        return punctsCount;
    }

    public void setPunctsCount(int punctsCount) {
        this.punctsCount = punctsCount;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public float getRhymeCoef() {
        return rhymeCoef;
    }

    public void setRhymeCoef(float rhymeCoef) {
        this.rhymeCoef = rhymeCoef;
    }

    public void readText() throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        String hs;
        List<Character> lastChars = new ArrayList<>();
        int linesCount = 0;
        int linesLength = 0;
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
            linesLength += hs.length();
        }

        setLineLength(linesLength/linesCount);
        findRhyme(lastChars, linesCount);
    }

    private void findRhyme(List<Character> lastChars, int linesCount){
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
        float rhymeCoef;
        rhymeCoef = (float) Math.round(((float)rhymeCount/linesCount) * 100) / 100;
        setRhymeCoef(rhymeCoef);
    }
}
