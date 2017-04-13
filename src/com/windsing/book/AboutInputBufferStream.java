package com.windsing.book;

import java.io.*;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 * 
 */
public class AboutInputBufferStream {
    static String pathname = "./source/my_img.jpg";
    static File file = new File(pathname);

    public static void for_buffer(int size) {
        long start_time = System.currentTimeMillis();

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(inputStream, size);
//        BufferedInputStream bis2 = new BufferedInputStream(size);
        try {
            int content = bis.read();
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }


        long ent_time = System.currentTimeMillis();
        System.out.println("use_time >> " + (ent_time - start_time));
    }

    public static void main(String[] args) {
        for_buffer(1024);
    }

}
