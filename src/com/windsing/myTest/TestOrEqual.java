package com.windsing.myTest;

/**
 * Created by FC on 2017/4/8.
 */
public class TestOrEqual {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        a |= b; // a = a|b 只要有一个1就是1，两个都是0才是0
        System.out.println(a);

    }

}
