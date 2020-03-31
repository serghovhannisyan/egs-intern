package com.egs.serg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class MySynchronizedArray {

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    private List<String> arr = new ArrayList<>();

    synchronized void add(String value) {
        // not important work

//        arr.add(value);
    }

    synchronized void remove(String value) {
        arr.remove(value); // t1
    }

//    static synchronized void f3() {
//        // t2
//    }

    void f5() {
        System.out.println("asdasdsad");
        System.out.println("asdasdsadsdfsdfsdf");
        synchronized (this) {
            arr.add("");
        }
    }

//    static void f6() {
//        System.out.println("asdasdsad");
//        System.out.println("asdasdsadsdfsdfsdf");
//        synchronized (MySynchronizedArray.class) {
//            arr.remove("");
//        }
//    }

    public void f1() {
        synchronized (this) {

        }
    }

    public void f2() {
        synchronized (this) {

        }
    }

    static void f3() {
        synchronized (String.class) {

        }
    }

    public void f4() {
        synchronized (lock2) {
            arr.add("");
        }
    }

}
