package com.egs.serg;

public class MyRunnable implements Runnable {

    private final int from;
    private final int to;
    private final int[] arr;
    private int sum;
    private MyCallback callback;

    public MyRunnable(int from, int to, int[] arr) {
        this.from = from;
        this.to = to;
        this.arr = arr;
    }

    public MyRunnable(int from, int to, int[] arr, MyCallback callback) {
        this.from = from;
        this.to = to;
        this.arr = arr;
        this.callback = callback;
    }

    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            sum += arr[i];
        }

        callback.onResultReady(sum);

//        System.out.println(sum);
    }

    public int getSum() {
        return sum;
    }


    public interface MyCallback {
        void onResultReady(int sum);
    }
}
