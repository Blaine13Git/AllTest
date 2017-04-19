package com.windsing.myTest;

/**
 * Created by FC on 2017/4/17.
 */
public class TestThread extends Thread {

    int num = 100;

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "     " + num--);
        }
    }


    public static void main(String[] args) {
        TestThread tt = new TestThread();
        TestThread tt2 = new TestThread();
        tt.start();
        tt2.start();


    }
}
