package com.windsing.myTest;

import java.io.File;

/**
 * Created by FC on 2017/4/7.
 */
public class TestFiles {

    public static void main(String[] args) {
        File f = new File("TestFiles.txt");
        String short_name = f.getPath();
        String long_name = f.getAbsolutePath();
        System.out.println("short_name >> " + short_name);
        System.out.println("long_name >> " + long_name);
    }
}
