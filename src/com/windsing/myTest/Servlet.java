package com.windsing.myTest;

import java.io.OutputStream;

/**
 * Created by fch96 on 2017/5/26.
 */
public class Servlet {

    public void init() {
        System.out.println("已经初始化完成！");
    }

    public void service(String params, byte[] requestBuffer, OutputStream output) {
        try{
            String num = params.substring(params.indexOf("=")+1);
            double result = Math.sqrt(Double.valueOf(num));

            String responseFirstLine = "HTTP/1.1 200 OK\r\n";
            output.write(responseFirstLine.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
