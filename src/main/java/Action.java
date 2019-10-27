import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public interface Action {

    static List<String> parseDirectory(String dirName){
        File dir = new File(dirName);
        File []arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        List<String> fileNames = new ArrayList<>();
        for (File file : lst) {
            if (file.getName().endsWith(".txt")) {
                fileNames.add(dirName + "\\" + file.getName());
            }
        }
        if (fileNames.size() == 0) {
            System.out.println("In the directory '" + dirName + "' no txt files founded!");
        };
        return fileNames;
    }

    static void createVectors(List<String> files, String classification) throws IOException {
        Map<VectorAttributes, String> attrMap = new HashMap<>();
        TextParser textParser = new TextParser();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("data.txt"), true));
        int count = 0;
        for (String file : files){
            count += 1;
            textParser.setPath(file);
            textParser.readText();

            attrMap.put(VectorAttributes.TEXT_VOLUME, String.valueOf(textParser.getTextVolume()));
            attrMap.put(VectorAttributes.LINE_LENGTH, String.valueOf(textParser.getLineLength()));
            attrMap.put(VectorAttributes.PUNCT_TO_WORDS, String.valueOf(textParser.getPunctsCount()));
            attrMap.put(VectorAttributes.RHYME, String.valueOf(textParser.getRhymeCoef()));

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(attrMap.get(VectorAttributes.TEXT_VOLUME));
            stringBuilder.append(' ');
            stringBuilder.append(attrMap.get(VectorAttributes.LINE_LENGTH));
            stringBuilder.append(' ');
            stringBuilder.append(attrMap.get(VectorAttributes.PUNCT_TO_WORDS));
            stringBuilder.append(' ');
            stringBuilder.append(attrMap.get(VectorAttributes.RHYME));
            stringBuilder.append(' ');

            bufferedWriter.write(stringBuilder + classification);
            bufferedWriter.newLine();

            System.out.println("File '" + file + "' parsed successfully!");
        }
        System.out.println("Added " + count + " signs!");
        bufferedWriter.close();
    }

}

