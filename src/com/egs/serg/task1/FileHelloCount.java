package com.company.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class F {
    public static void main(String args[]) {
        int b = 0;
        String fileName = "text.txt";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            FileWriter fw = new FileWriter("result.txt");
            while (scanner.hasNext()) {
                Map<String, Integer> wordCount = new HashMap<>();
                String[] words = scanner.nextLine().split(" ");
                for (String word : words) {
                    if ((wordCount.containsKey(word)&&(word.equals("hello")))){
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
                Set<String> wordsInStrig = wordCount.keySet();
                for (String word : wordsInStrig) {
                    if ((word.equals("hello"))) {
                        System.out.println(Integer.toString(wordCount.get(word)) + " hello");
                        fw.write(++b + " line: " + Integer.toString(wordCount.get(word)) + " hello\n");
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
