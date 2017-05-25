package com.windsing.book.b003;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by FC on 2017/5/25.
 * 代理：
 * 1、接收请求，使用myServer
 * 2、把接收的请求保存到文档中
 * 3、向服务器发送请求，使用myClient，printWrite向流中写入请求参数
 * 4、接收服务器返回，使用getInputSteam
 */
public class MyHttpProxy {

    public static void myServer() {

        try {
            ServerSocket ss = new ServerSocket(8887);
            while (true) {
                Socket s = ss.accept();
                Thread t = new Thread(new ThreadedEchoHandler(s));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myServer();
    }

    //处理POST请求
    public void doGet(){
        System.out.println(" doGet");
    }

    //处理Get请求
    public void doPost(){
        System.out.println(">> doGPost");
    }

    private static class ThreadedEchoHandler implements Runnable {

        private Socket incoming;

        public ThreadedEchoHandler(Socket socket) {
            incoming = socket;
        }

        @Override
        public void run() {

            try {

                // 获取输入流，使用Scanner进行读取
                InputStream inputStream = incoming.getInputStream();
                Scanner scanner = new Scanner(inputStream);

                while (scanner.hasNextLine()) {
                    String request_http = scanner.findInLine("HTTP/1.1");
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                OutputStream outputStream = incoming.getOutputStream();
                PrintWriter writer =new PrintWriter(outputStream);
                writer.print(1);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    incoming.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
