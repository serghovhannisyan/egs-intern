package com.egs.arsen.task1;

import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean state = true;


        File file = new File("wordFile.txt");
        File fileResult = new File("ResultFile.txt");

        try {
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {

                fileResult.createNewFile();

            }
            boolean exists = file.exists();
            if (exists) {
                System.out.println(" Write your text and pleas put , between words");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (state) {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("exit")) {
                state = false;
            } else {
                try {
                    String s[] = str.split(",");
                    writeToFile(file, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        modify(file, fileResult);
    }

    public static void writeToFile(File file, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(data);
        writer.write(System.lineSeparator());
        writer.flush();
        writer.close();


    }

    public static void modify(File file, File fileResult) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter reade = new BufferedWriter(new FileWriter(fileResult));

        String str;
        String word = "hello";
        int lineNummber = 1;
        while ((str = reader.readLine()) != null) {
            int i = 0;

            i = countOccurences(str, word);

            reade.write(lineNummber + "=" + i + "\n");
            lineNummber++;
        }
        reader.close();
        reade.close();
    }


    static int countOccurences(String str, String word) {

        String a[] = str.split(",");
        int count = 0;
        for (int i = 0; i < a.length; i++) {

            if (word.equals(a[i]))
                count++;
        }return count;
    }

}
