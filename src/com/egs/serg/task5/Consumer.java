package com.egs.serg.task5;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

    private final MyArray data;

    public Consumer(MyArray data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                data.remove();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
