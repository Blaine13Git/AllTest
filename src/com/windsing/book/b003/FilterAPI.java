package com.windsing.book.b003;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FC on 2017/5/18.
 */
public class FilterAPI {

    public static List<String> api_lists;

    /**
     * 读取文件并去掉参数部分，写入到List<String>中
     * 不使用Set集合是因为得到的结果不全
     *
     * @param file_name
     * @return
     * @throws Exception
     */
    public static List<String> getAPIS(String file_name) throws Exception {
        api_lists = new ArrayList<>();

        InputStream in = new FileInputStream(getFile(file_name));
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            boolean split_args = true;
            if (split_args && line.contains("?")) {
                String short_line = line.split("\\?")[0];
                api_lists.add(short_line);
            } else {
                api_lists.add(line);
            }
        }
        System.out.println("API个数：" + api_lists.size());
        return api_lists;
    }

    public static File getFile(String file_name) {
        String user_dir = System.getProperty("user.dir");
        String file_dir = user_dir + "/othersFiles/";
        File file = new File(file_dir + file_name);
        return file;
    }

    /**
     * 去除重复并打印出结果
     *
     * @param api_lists
     */
    public static void show_api(List<String> api_lists) {
        // 去重
        for (int i = 0; i < api_lists.size(); i++) {
            for (int j = i + 1; j < api_lists.size(); j++) {
                if (api_lists.get(i).equals(api_lists.get(j))) {
                    api_lists.remove(j);
                    j -= 1; // list长度减一的时候，元素都向前移动了一个位置，所以j也要向前移动一个位置，保证没有漏比较的元素。
                }
            }
        }

        // 打印出结果
        System.out.println(api_lists.size());
        for (int i = 0; i < api_lists.size(); i++) {
            System.out.println(api_lists.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        getAPIS("test.txt");
        show_api(api_lists);
    }


}
