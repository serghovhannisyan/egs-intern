package com.egs.serg;

public class Test {

    public synchronized void f() {
        try {
            System.out.println(Thread.currentThread().getName() + " before");
//            Thread.sleep(2000);
            wait();
            System.out.println(Thread.currentThread().getName() + " after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void f2() {
        notifyAll();
    }
}
