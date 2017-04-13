package com.windsing.book.b003;

import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/14.
 */
public class TestChannel {
    static void test_001() throws Exception{
        Path file_path = Paths.get("E:\\","workspaces\\AllTest\\source","my_img.jpg");
        FileChannel channel = FileChannel.open(file_path);
        out.println(channel.size());
//        channel.map(FileChannel.MapMode.READ_WRITE,0,channel.size());
    }
    public static void main(String[] args) throws Exception{
        test_001();
    }
}
