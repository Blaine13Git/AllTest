package com.windsing.book.b003;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

/**
 * Created by FC on 2017/5/26.
 */
public class PostTest {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(args[0]))) {
            properties.load(in);
        }

        String url = properties.remove("url").toString();
        String result = doPost(url, properties);
        System.out.println(result);
    }

    public static String doPost(String urlString, Map<Object, Object> nameValuePairs) throws Exception{

        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);


        return null;
    }
}
