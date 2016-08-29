package com.windsing.myTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileTest {
	
	/*
	 * 文件写入
	 */
	public static void toWrite() throws IOException {
		File file = new File("D:\\123.csv");

		file.delete();
		file.createNewFile();
		
		FileOutputStream outPut = new FileOutputStream(file);
		OutputStreamWriter pw = new OutputStreamWriter(outPut, "UTF-8");
		
		pw.write("123\n");
		pw.write("345");
		pw.write("789");

		pw.close();
		outPut.close();
	}
	
	/**
	 * 文件读取
	 */
	@SuppressWarnings("resource")
	public static void toRead() throws Exception{
		File file = new File("D:\\123.csv");
		
		FileReader in = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(in);
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		toWrite();
		toRead();
	}

}
