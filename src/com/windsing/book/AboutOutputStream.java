package com.windsing.book;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class AboutOutputStream {

    static String file_name = "./source/my_img.jpg";
    static File file = new File(file_name);

    static void write2file() throws Exception {
        OutputStream ops = new FileOutputStream(file);
        OutputStreamWriter opsw = new FileWriter(file);
        opsw.write("1232");
    }

    static void copyFile() throws Exception {
        InputStream inputStream = new FileInputStream(file);
        int num = inputStream.available();
        OutputStream outputStream = new FileOutputStream("./source/copy.jpg");
        int img_byte = 0;
        while (img_byte != -1) {
            img_byte = inputStream.read();
            out.println(img_byte);
            outputStream.write(img_byte);
        }
        outputStream.close();
        inputStream.close();
    }

    static void my_printWriter() throws Exception{
        File f = new File("./source/file_002.txt");
        PrintWriter pw =new PrintWriter("./source/file_002.txt");
        pw.write("test just so so");
        pw.close();

    }

    static void wirteData(){

    }

    static void readData_scanner() throws Exception{
        File f = new File("./source/file_002.txt");
        Scanner s = new Scanner(f);
        String ss = s.nextLine();
        out.print(ss);
    }

    static void readData_bufferedReader() throws Exception{
        File f = new File("./source/file_002.txt");

        Reader in = new FileReader(f);
        BufferedReader br = new BufferedReader(in);
        String s = br.readLine();
        out.print(s);
    }

    public static void main(String[] args) throws Exception {
//        write2file();
//        copyFile();
//        my_printWriter();
//        readData_scanner();
        readData_bufferedReader();
    }

}
