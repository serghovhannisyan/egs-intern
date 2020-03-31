package com.egs.serg;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("after sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
