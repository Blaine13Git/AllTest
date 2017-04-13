package com.windsing.book.b001;

import java.io.*;

import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/9.
 */
public class AboutFiles {

    static String file_name = "./source/file_001.txt";

    public static void just_try(){
        File f = new File(file_name);
        out.print(f.getPath());

        // OutputStreamWriter is a bridge from character streams to byte streams
        OutputStreamWriter osw = null;
        try {
            osw = new FileWriter(f);
            osw.write("hello");
            osw.append("123");
    //            osw.write(System.in.read());
            InputStreamReader isr = new InputStreamReader(System.in);
            osw.write(isr.read());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test_001() throws Exception{
        InputStream i= new FileInputStream("./source/file_001.txt");
        DataInputStream d = new DataInputStream(i);
        int s = d.read();
        out.print(s);

    }

    public static void test_002() throws Exception{
        File f = new File("./source/file_001.txt");
        InputStream inputStream = new FileInputStream(f);
        InputStreamReader i = new InputStreamReader(inputStream);
        char s = (char)i.read();
        out.print(s);
    }

    public static void test_003() throws Exception{
        File f = new File("./source/file_001.txt");
        InputStream inputStream = new FileInputStream(f);
        char s = (char)inputStream.read();
        out.print(s);
    }

    public static void test_004() throws Exception{
        File f = new File("./source/file_001.txt");
        Reader reader = new FileReader(f);
        BufferedReader br = new BufferedReader(reader);
        String s_l = br.readLine();
        out.print(s_l);
    }

    public static void main(String[] args) throws Exception{
        test_004();
    }

}
