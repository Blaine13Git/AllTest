package com.windsing.book.b003;

import com.sun.corba.se.impl.legacy.connection.SocketFactoryAcceptorImpl;
import jdk.net.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by FC on 2017/4/19.
 */
public class TestSocket03 {

    static void test001() throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        int i = 0;
        while (true) {
            Socket s = ss.accept();
            System.out.println(">>> " + i);
            Thread t = new Thread(new ThreadedEchoHandler(s));
            t.start();
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        test001();
    }

}

class ThreadedEchoHandler implements Runnable {

    private Socket incoming;

    public ThreadedEchoHandler(Socket socket) {
        incoming = socket;
    }

    @Override
    public void run() {

        try {

            InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            printWriter.println("Hello! Enter BYE to Exit");

            boolean done = false;

            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                printWriter.println("Echo:" + line);
                if (line.contains("BYE")) done = true;
            }

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