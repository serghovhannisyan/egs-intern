package com.egs.serg;

public class Main {

    static volatile int x;
    volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(x);
    }

    static synchronized void increment() {
        x++;
    }


}
