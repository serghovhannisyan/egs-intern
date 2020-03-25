package com.egs.sargsyanarsen;

import com.egs.sargsyanarsen.task2.ReadFromFileIntoArrayList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        new ReadFromFileIntoArrayList(new File("arsen-sargsyan-resources/fileArrayList")).go();
    }
}
