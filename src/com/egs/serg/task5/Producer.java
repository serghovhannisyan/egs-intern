package com.egs.serg.task5;

import java.util.Random;

public class Producer implements Runnable {

    private final MyArray data;
    private volatile boolean isRunning = true;

    public Producer(MyArray data) {
        this.data = data;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (isRunning) {
            try {
                data.add(r.nextInt(100));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Producer finished");
    }

    public void terminate() {
        isRunning = false;
    }
}
