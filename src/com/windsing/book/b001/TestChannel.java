package com.windsing.book.b001;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.windsing.book.b001.TestPath.test_002;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/14.
 * 通道：chanel
 */
public class TestChannel {

    static void test_001() throws Exception {
        Path file_path = Paths.get("E:\\", "Code\\eclipseWorkspace\\AllTest\\source", "try.txt");
        FileChannel channel = FileChannel.open(file_path);
        out.println(channel.size());
        channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
        channel.close();
    }

    static void test002() throws IOException, InterruptedException {
//        Path path = Paths.get("E:\\", "Code\\eclipseWorkspace\\AllTest\\source", "my_img.jpg");
        Path file_path = Paths.get(System.getProperty("user.dir")).resolve("source").resolve("try.txt");
        FileChannel fileChannel = FileChannel.open(file_path);

        System.out.println(file_path);

        FileLock fileLock = null;

        while (true) {
            fileLock = fileChannel.tryLock(0, Long.MAX_VALUE, true);
            System.out.println("是否为共享锁：" + fileLock.isShared());

            if (fileLock != null) {
                break;
            } else {
                System.out.println("文件被占用，休眠100s");
                Thread.sleep(100);
            }
        }

        // 从通道中读取文件内容
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);
        int read = fileChannel.read(buffer.compact());
        fileChannel.position();
        System.out.println("buffer.position=" + buffer.position(buffer.limit()));
        for (int i = 0; i < buffer.position(); i++) {

            System.out.println(read);

        }

        fileLock.release();  // 释放文件锁
        fileChannel.close();  // 关闭文件通道
    }


    static void test003() throws IOException, InterruptedException {
        Path file_name = Paths.get(System.getProperty("user.dir")).resolve("source").resolve("try.txt");
        FileInputStream inputStream = new FileInputStream(String.valueOf(file_name));
        FileChannel channel = inputStream.getChannel();
//        FileLock fileLock = channel.tryLock(0,12,true);

//
//        while (true){
//            if(fileLock!=null){
//                break;
//            }else {
//                Thread.sleep(100);
//            }
//        }


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.flip();
//        byte b = buffer.get();
        channel.write(buffer);
        channel.read(buffer);
//        System.out.println(b);

//        fileLock.release();
        inputStream.close();

    }

    static void test004() throws IOException {

        File in = new File("D:\\in.txt");
        File out = new File("D:\\out.txt");

        if (in.createNewFile()) {
            System.out.println("in.txt被创建");
            FileOutputStream is = new FileOutputStream(in);
            byte[] b = "我一定能行的".getBytes();
            is.write(b, 0, b.length);
        }

        if (out.createNewFile()) {
            System.out.println("out.txt被创建");
        }

        FileInputStream is = new FileInputStream(in);
        FileOutputStream os = new FileOutputStream(out);

        FileChannel fis = is.getChannel();
        FileChannel fos = os.getChannel();

        ByteBuffer bytedata = ByteBuffer.allocate(100);  // 分配一个新的字节缓冲区。

        while (fis.read(bytedata) != -1) {
            //通过通道读写交叉进行。
            bytedata.flip();
            fos.write(bytedata);
            bytedata.clear();
        }

        fis.close();
        fos.close();
        is.close();
        os.close();
    }


    public static void main(String[] args) throws Exception {
        test004();
    }
}
