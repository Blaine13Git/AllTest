package com.windsing.book.b003;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by FC on 2017/5/24.
 */
public class htmlAPI {

    public static void doPost() throws Exception {
//        api_url = "http://test-bgroup-bpi.qichechaoren.com/superapi/ps/getSystemTimestamp";
        String api_url = "http://dict.youdao.com/";
        URL url = new URL(api_url);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        writer.print("/w/eng/dog/");

        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }


    }

    public void doGet(String api_url, Map<Object, Object> args) {

    }

    public static void main(String[] args) throws Exception{
        doPost();
    }
}
