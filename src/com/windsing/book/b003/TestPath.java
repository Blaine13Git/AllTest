package com.windsing.book.b003;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/13.
 */
public class TestPath {

    static void test_001() {
        String root_path = System.getProperty("user.dir");
//        out.println(root_path);

        Path new_path = Paths.get("E:\\","Code\\eclipseWorkspace\\AllTest\\source\\","test.txt");
        out.println(new_path);
        out.println(new_path.getRoot());
        out.println(new_path.toFile());


    }
    static void test_002() {
        Path new_path = Paths.get("E:\\","Code\\eclipseWorkspace\\AllTest\\");
        out.println(new_path);

        Path path1 = new_path.resolve("source");
        Path path2 = new_path.resolveSibling("source");
        out.println(path1);
        out.println(path2);

    }

    static void test_003()throws Exception{
        Path file_path = Paths.get("E:\\","Code\\eclipseWorkspace\\AllTest\\source","try.txt");
        byte[] bytes = Files.readAllBytes(file_path);
        String content = new String(bytes, Charset.defaultCharset());
        out.println(content);
        long count = Files.size(file_path);
        out.println(count);

        boolean b = Files.exists(file_path);
        out.println(b);
    }

    public static void main(String[] args) throws Exception{
        test_003();
    }

}
