package com.egs.nikol.task1;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {


        try {
            File file = new File(Main.class.getResource("file.txt").toURI());

            File result = new File(Main.class.getResource("result.txt").toURI());
            FileExplorer.fileTransfer(file, result);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
