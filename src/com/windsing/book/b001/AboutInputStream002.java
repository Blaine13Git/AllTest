package com.windsing.book.b001;

import java.io.*;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 * 
 */
public class AboutInputStream002 {
    static String file_name = "my_img.jpg";

    public static void readImg(String file_name){
        InputStream is = null;
        File file = new File(file_name);

        try {
            is = new FileInputStream(file);
            int content = is.read();
            System.out.print(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readImg(file_name);
    }

}
