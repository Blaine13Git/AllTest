package com.windsing.book.b003;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by FC on 2017/5/24.
 */
public class htmlAPI {

    public void doPost(String api_url, Map<Object, Object> args) {
        api_url = "http://test-bgroup-bpi.qichechaoren.com/superapi/ps/getSystemTimestamp";
        try {
            URL url = new URL(api_url);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);//设置为可写入
            OutputStream outputStream = connection.getOutputStream(); //获取写入流

            PrintWriter writer = new PrintWriter(outputStream); //用写入流创建写入对象

            // 判断是否为第一个写入参数
            boolean first = true;
            if (first) first = false;
            else writer.print("&");

            Map<String, String> m = new HashMap<>();
            for (Map.Entry<String, String> me : m.entrySet()) {

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(String api_url, Map<Object, Object> args) {

    }

    public static void main(String[] args) {

    }
}
