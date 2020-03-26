package com.egs.nikol.task1;

import java.io.*;

public class FileExplorer {

    public static void fileTransfer(File data, File result) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(data));
        BufferedWriter writer = new BufferedWriter(new FileWriter(result));
        String line;
        int count;
        int linesNumber = 1;
        while (true) {
            line = reader.readLine();
            if (line != null) {

                count = 0;
                try {
                    String[] words = line.split(" ");
                    for (String s : words) {
                        if (s.equalsIgnoreCase("hello")) {
                            count++;
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                writer.write("line " + (linesNumber++) + " has " + count + " <<Hello>> word");
                writer.newLine();
            } else {
                reader.close();
                writer.close();
                break;
            }


        }
    }
}
