package com.windsing.myTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.csvreader.CsvWriter;

public class LineTest {

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/*
	 * 删除空白行
	 */

	public static void test001() throws Exception {

		String fileName = "D:\\qb_mem2.txt";

		// Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Pattern p = Pattern.compile("\\n");

		FileReader fileReader = new FileReader(fileName);// 读取文件
		BufferedReader bufferedReader = new BufferedReader(fileReader, 8184);// 缓冲区每次读取8M

		String line = "";

		String csvFilePath = "D://outtest.csv";
		CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("GBK"));

		while ((line = bufferedReader.readLine()) != null) {
			line = line.replace("\\n", "1");
			System.out.println(line);
			String[] memNum = line.split("\\s+");
			wr.writeRecord(memNum);// 把字符串数组写入csv文件
		}

		wr.close();
		fileReader.close();
		bufferedReader.close();

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test001();
	}

}
