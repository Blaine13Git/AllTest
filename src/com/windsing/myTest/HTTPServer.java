package com.windsing.myTest;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fch96 on 2017/5/26.
 */
public class HTTPServer {

    public static Map<String, Servlet> servletCache = new HashMap<>();

    public static void main(String[] args) {
        int port;
        ServerSocket serverSocket;

        try {
            port = Integer.parseInt(args[0]);

        } catch (Exception e) {
            port = 8080;
            e.printStackTrace();
        }

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                try {
                    final Socket socket = serverSocket.accept();
                    System.out.println(socket.getInetAddress());
                    System.out.println(socket.getPort());
                    service(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void service(Socket socket) throws Exception {
        InputStream socketIn = socket.getInputStream();
        Thread.sleep(500);

        // 从客户端读取
        int size = socketIn.available();
        byte[] requestBuffer = new byte[size];
        socketIn.read(requestBuffer);
        String request = new String(requestBuffer);
        System.out.println(request);


        //提取第一行
        String firstLineOfRequest = request.substring(0, request.indexOf("\n"));
        String[] parts = firstLineOfRequest.split(" ");
        String uri = parts[1];

        if ("/".equals(uri)) uri = "index.html";
        if (uri.indexOf("servlet") != -1) {
            doServletService(socket, uri, requestBuffer);
        } else {
            doFileRespone(socket, uri);
        }

    }

    private static void doFileRespone(Socket socket, String uri) throws Exception {
        uri = "root/" + uri;

        String contentType;
        if (uri.indexOf("htm")!=-1) contentType = "text/html";
        else if(uri.indexOf("jpg")!=-1 || uri.indexOf("jpeg")!=-1) contentType ="img/jpg";
    }

    private static void doServletService(Socket socket, String uri, byte[] requestBuffer) throws Exception {

        String servletName = null;
        String params = null;
        if (uri.indexOf("?") != -1) {
            servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.indexOf("?"));
            params = uri.substring(uri.indexOf("?") + 1);
        } else {
            servletName = uri.substring(uri.indexOf("servlet/") + 8);
        }

        Servlet servlet = servletCache.get(servletName);

        // 使用反射reflection创建实例
        if (servlet == null) {
            servlet = (Servlet) Class.forName(servletName).newInstance();
            servlet.init();
            servletCache.put(servletName, servlet);
        }

        servlet.service(params, requestBuffer, socket.getOutputStream());
        Thread.sleep(1000);
        socket.close();

    }
}
