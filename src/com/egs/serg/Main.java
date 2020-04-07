package com.egs.serg;

import com.egs.arsensargsyan.task2.Constants;
import com.egs.serg.task5.Consumer;
import com.egs.serg.task5.MyArray;
import com.egs.serg.task5.Producer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyArray data = new MyArray();
        Producer p1 = new Producer(data);
        Producer p2 = new Producer(data);
        Consumer c1 = new Consumer(data);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(c1);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(9000);
        p1.terminate();
        p2.terminate();
    }

// Java ClassLoader
// Memory Model - Memory Management
// Java Generics
// Java 8 Stream, Lambda

//    public static void main(String[] args) throws InterruptedException {
//        int[] arr = new int[1000];
//        arr[0] = 30;
//
//        MyRunnable r1 = new MyRunnable(0, 250, arr, new MyRunnable.MyCallback() {
//            @Override
//            public void onResultReady(int sum) {
//                System.out.println(sum);
//            }
//        });
//
//        Thread t1 = new Thread(r1);
//
//        t1.start();
////        t1.join();
//
//        System.out.println("finish");
//
//    }

}

