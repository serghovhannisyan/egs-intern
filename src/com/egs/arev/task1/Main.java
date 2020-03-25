package com.egs.arev.task1;

import java.io.*;

public class Main {
    private static String SOURCE_PATH = "source.txt";
    private static String RESULT_PATH = "result.txt";

    public static void main(String[] args) throws IOException {
        countOfHello(SOURCE_PATH, RESULT_PATH);
    }

    static void countOfHello(String path, String result_path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(result_path));) {
            String line = reader.readLine();
            String[] words;
            int count = 0;
            int l = 1;
            while (line != null) {
                words = line.split(" ");
                for (String word : words) {
                    if (word.equals("Hello")) {
                        count++;
                    }
                }
                writer.write("line" + Integer.toString(l) + "-" + Integer.toString(count) + "\n");
                count = 0;
                l++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
