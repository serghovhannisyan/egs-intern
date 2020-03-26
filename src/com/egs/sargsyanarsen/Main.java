package com.egs.sargsyanarsen;

import com.egs.sargsyanarsen.task2.ReadFromFileIntoArrayList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        new ReadFromFileIntoArrayList(new File("src/com/egs/sargsyanarsen/task2/filee")).go();
    }
}
