package com.egs.arsensargsyan.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadHello {

    private static final String PATH_FILE = "src/com/egs/arsensargsyan/task1/readFile";
    private static final String RESULT_FILE = "src/com/egs/arsensargsyan/task1/result";

    private Map<Integer, Integer> resultMap = new HashMap<>();

    public void go() {
        try {
            resultMap = read("hello");
            write(resultMap);
        } catch (IOException e) {
            System.out.println("File read or write Error ");
            return;
        }
        System.out.println("File read and write done successfully");
    }

    private Map<Integer, Integer> read(final String word) throws IOException {
        String line;
        int numberLine = 0;
        int numberHello = 0;
        String[] lineToWords;
        try (BufferedReader bRed = new BufferedReader(new FileReader(PATH_FILE))) {
            while ((line = bRed.readLine()) != null) {
                numberLine++;
                lineToWords = line.split(" ");
                for (String s : lineToWords) {
                    if (s.equals(word)) {
                        numberHello++;
                    }
                }
                resultMap.put(numberLine, numberHello);
                numberHello = 0;

            }

        }
        return resultMap;
    }

    private void write(Map<Integer, Integer> map) throws IOException {
        try (BufferedWriter bWri = new BufferedWriter(new FileWriter(RESULT_FILE))) {
            bWri.write(map.toString());
        }
    }
}
