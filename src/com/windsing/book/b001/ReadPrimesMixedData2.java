package com.windsing.book.b001;

import java.nio.file.*;
import java.nio.channels.ReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by FC on 2017/4/21.
 */

public class ReadPrimesMixedData2 {

    public static void main(String[] args) {
        Path file = Paths.get(System.getProperty("user.dir")).resolve("source").resolve("try.txt");
        if (!Files.exists(file)) {
            System.out.println(file + " does not exist. Terminating program.");
            System.exit(1);
        }

        try (ReadableByteChannel inCh = Files.newByteChannel(file)) {
            ByteBuffer buf = ByteBuffer.allocateDirect(256);
            buf.position(buf.limit());  // Set the position for the loop operation
            int strLength = 0;  // Stores the string length
            byte[] strChars = null;  // Array to hold the bytes for the string

            while (true) {
                if (buf.remaining() < 8) {  // Verify enough bytes for string length
                    if (inCh.read(buf.compact()) == -1)
                        break;  // EOF reached
                    buf.flip();
                }
                strLength = (int) buf.getDouble();                             // Get the string length

                // Verify enough bytes for complete string
                if (buf.remaining() < 2 * strLength) {
                    if (inCh.read(buf.compact()) == -1) {
                        System.err.println("EOF found reading the prime string.");
                        break;                                                     // EOF reached
                    }
                    buf.flip();
                }
                strChars = new byte[2 * strLength];                              // Array for string bytes
                buf.get(strChars);                                             // Get the bytes

                if (buf.remaining() < 8) {                                      // Verify enough bytes for prime value
                    if (inCh.read(buf.compact()) == -1) {
                        System.err.println("EOF found reading the binary prime value.");
                        break;                          // EOF reached
                    }
                    buf.flip();
                }

                System.out.printf("String length: %3s  String: %-12s  Binary Value: %3d%n",
                        strLength, ByteBuffer.wrap(strChars).asCharBuffer(), buf.getLong());
            }

            System.out.println("\nEOF reached.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
