package com.windsing.book.b003;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by fch96 on 2017/4/18.
 */
public class Socket001 {

    static void test001() throws Exception {
        Socket s = new Socket();
        s.connect(new InetSocketAddress("",13));
    }
    public static void main(String[] args) {

    }
}
