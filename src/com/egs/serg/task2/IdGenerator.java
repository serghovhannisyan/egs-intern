package com.egs.serg.task2;

public class IdGenerator {

    private static long id = 0;

    public static long nextId() {
        id++;
        return id;
    }
}