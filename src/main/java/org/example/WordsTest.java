package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordsTest {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Map<String, Integer> wordsNumbers = new HashMap<>();
        File file = new File("files/words.txt");
        System.out.println("File exists: " + file.exists());

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = String.valueOf(scanner.nextLine());
                while (str.contains("  ")) str = str.strip().replace("  ", " ");
                Collections.addAll(words, str.split(" "));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String tempStr : words) {
            if (!wordsNumbers.containsKey(tempStr)) {
                wordsNumbers.put(tempStr, 1);
            } else {
                wordsNumbers.put(tempStr, wordsNumbers.get(tempStr) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordsNumbers.entrySet()) {
            System.out.println("Word = " + entry.getKey() + ", repeats = " + entry.getValue());
        }
    }
}
