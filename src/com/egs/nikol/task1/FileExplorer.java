package com.egs.nikol.task1;

import java.io.*;

public class FileExplorer {

    public static void fileTransfer(File data, File result) throws IOException {


        String line;
        int count;
        int linesNumber = 1;


        try (BufferedReader reader = new BufferedReader(new FileReader(data)); BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {

            while (true) {
                line = reader.readLine();
                if (line != null) {
                    count = 0;
                    String[] words = line.split(" ");
                    for (String s : words) {
                        if (s.equalsIgnoreCase("hello")) {
                            count++;
                        }
                    }
                } else break;
                writer.write("line " + (linesNumber++) + " has " + count + " <<Hello>> word");
                writer.newLine();
            }
        }
    }
}