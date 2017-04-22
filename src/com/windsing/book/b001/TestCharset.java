package com.windsing.book.b001;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/12.
 */
public class TestCharset {

    /**
     * 字符集別名
     */
    static void test001() {
        Charset cset = Charset.forName("ISO-8859-1");
        Set<String> aliases = cset.aliases();
        for (String s : aliases) {

            out.println(s);
        }


    }

    /**
     * 可用字符集的名字
     */
    static void test002() {
        SortedMap<String, Charset> s = Charset.availableCharsets();
        out.println(s);
        for (String name : s.keySet()) {
            out.println(name);
        }
    }

    static void test003() {
        Charset cset = Charset.forName("ISO-8859-1");
        String s = "asdfgh";
        ByteBuffer buffer = cset.encode(s);

    }

    public static void main(String[] args) {
        test002();
    }
}
