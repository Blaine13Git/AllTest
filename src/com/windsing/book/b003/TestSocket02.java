package com.windsing.book.b003;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by FC on 2017/4/19.
 */
public class TestSocket02 {

    static void test001() throws Exception {
        Socket s = new Socket();
        s.connect(new InetSocketAddress("baidu.com", 80), 1000);
    }

    static void test002(String hostname) throws Exception {
        System.out.println("Localhost:" + InetAddress.getLocalHost());
        InetAddress byName = InetAddress.getByName(hostname);
        System.out.println("InetAddress.getByName:>>" + byName);

        InetAddress[] allByName = InetAddress.getAllByName(hostname);
        for (InetAddress i : allByName) {
            System.out.println("all:>>" + i);
        }
    }

    public static void main(String[] args) throws Exception {
        test002("baidu.com");
    }

}
