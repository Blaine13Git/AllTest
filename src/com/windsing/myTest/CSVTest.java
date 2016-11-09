package com.windsing.myTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVTest {

	/**
	 * 读取CSV文件
	 */
	public void readCsv() {
		try {
			ArrayList<String[]> csvList = new ArrayList<String[]>(); // 用来保存数据
			String csvFilePath = "D:/log/Alarm20101125.csv";
			CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("SJIS")); // 一般用这编码读就可以了

			reader.readHeaders(); // 跳过表头 如果需要表头的话，不要写这句。

			while (reader.readRecord()) { // 逐行读入除表头的数据
				csvList.add(reader.getValues());
			}
			reader.close();

			for (int row = 0; row < csvList.size(); row++) {
				String cell = csvList.get(row)[0]; // 取得第row行第0列的数据
				System.out.println(cell);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * 写入CSV文件
	 */
	public static void WriteCsv() {
		try {
			String csvFilePath = "D://outtest.csv";
			CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("GBK"));
			String[] contents = { "告警信息", "非法操作", "没有权限", "操作失败" };
			for(int i = 0;i<5;i++){
				wr.writeRecord(contents);
			}
			
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testCSV() throws Exception {
		String[] str = { "省", "市", "区", "街", "路", "里", "幢", "村", "室", "园", "苑", "巷", "号" };
		String inString = "";
		String tmpString = "";

		File inFile = new File("D://in.csv"); // 读取的CSV文件
		inFile.createNewFile();

		File outFile = new File("D://outtest.csv");// 输出的CSV文
		outFile.createNewFile();

		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

		CsvReader creader = new CsvReader(reader, ',');
		CsvWriter cwriter = new CsvWriter(writer, ',');

		while (creader.readRecord()) {
			inString = creader.getRawRecord();// 读取一行数据
			for (int i = 0; i < str.length; i++) {
				tmpString = inString.replace(str[i], "," + str[i] + ",");
				inString = tmpString;
			}
			// 第一个参数表示要写入的字符串数组，每一个元素占一个单元格，第二个参数为true时表示写完数据后自动换行
			cwriter.writeRecord(inString.split(","), true);
			// 注意，此时再用cwriter.write(inString)方法写入数据将会看到只往第一个单元格写入了数据，“，”没起到调到下一个单元格的作用
			// 如果用cwriter.write(String
			// str)方法来写数据，则要用cwriter.endRecord()方法来实现换行
			// cwriter.endRecord();//换行
			cwriter.flush();// 刷新数据
		}
		creader.close();
		cwriter.close();
	}

	public static void main(String[] args) {
		WriteCsv();
	}
}
