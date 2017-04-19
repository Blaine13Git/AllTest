package com.windsing.myTest;

/**
 * Created by FC on 2017/4/17.
 */
public class TestThread_Runnable implements Runnable {

    int num = 50;

    public static void main(String[] args) {
        TestThread_Runnable ttr= new TestThread_Runnable();
        TestThread_Runnable ttr2= new TestThread_Runnable();
        new Thread(ttr).start();
        new Thread(ttr2).start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "     "+num--);
        }
    }
}
