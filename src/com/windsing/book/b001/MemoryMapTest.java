package com.windsing.book.b001;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;

/**
 * Created by FC on 2017/4/21.
 */
public class MemoryMapTest {

    public static void main(String[] args) {

    }

    public static long checksumInputStream(Path filename) throws Exception {

        try (InputStream in = Files.newInputStream(filename)) {
            CRC32 crc = new CRC32();
            int c;
            while ((c = in.read()) != -1) {
                crc.update(c);
            }
            return crc.getValue();
        }
    }
}
