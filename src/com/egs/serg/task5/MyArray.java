package com.egs.serg.task5;

import java.util.LinkedList;

public class MyArray {

    LinkedList<Integer> data = new LinkedList<>();

    public synchronized void add(Integer value) {
        while (data.size() == 4) {
            try {
                System.out.println("Storage is full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Adding data " + value);
        data.add(value);
        notifyAll();
    }

    public synchronized Integer remove() {
        while (data.size() == 0) {
            try {
                System.out.println("Storage is empty");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer value = data.remove();
        System.out.println("Removing data " + value);
        notifyAll();
        return value;
    }
}
