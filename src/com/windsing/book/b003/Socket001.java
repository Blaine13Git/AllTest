package com.windsing.book.b003;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fch96 on 2017/4/18.
 */
public class Socket001 {

    static void test001() throws Exception {
//        s.connect(new InetSocketAddress("dict.youdao.com", 80), 5000);
        Socket s = new Socket("www.qccr.com", 80);
        s.setSoTimeout(5000);
        OutputStream outputStream = s.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.print("Get / HTTP/1.1\r\n");
        writer.flush();


//        StringBuilder sb = new StringBuilder();
//        InputStreamReader ir = new InputStreamReader(inputStream);
//        for (int c = ir.read(); c != -1; c = ir.read()) {
//            sb.append(c);
//        }
//        System.out.println(sb.toString());


        InputStream inputStream = s.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        outputStream.close();
        inputStream.close();
        s.close();
    }

    public static void main(String[] args) throws Exception {

        test001();

    }
}
