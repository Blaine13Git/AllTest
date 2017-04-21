package com.windsing.book.b003;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by FC on 2017/4/19.
 */
public class TestSocket04 {

    static void test001() throws Exception {
        URL url = new URL("http://dict.youdao.com");
//        url.getContent();

        URLConnection connection = url.openConnection();

        System.out.println(connection.getContentLength());
        System.out.println(connection.getContentType());

        InputStream inputStream = url.openStream();
        Scanner s = new Scanner(inputStream);
        if (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

    }

    public static void main(String[] args) throws Exception {
        test001();
    }

}
