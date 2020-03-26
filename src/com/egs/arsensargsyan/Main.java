package com.egs.arsensargsyan;

import com.egs.arsensargsyan.task1.ReadHello;
import com.egs.arsensargsyan.task2.ReadFromFileIntoArrayList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
//        new ReadHello().go();
        new ReadFromFileIntoArrayList(new File("src/com/egs/arsensargsyan/task2/filee")).go();
    }
}
