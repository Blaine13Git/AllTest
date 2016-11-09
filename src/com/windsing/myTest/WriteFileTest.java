package com.windsing.myTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteFileTest {

	public static void saveToFile(String text, String fileName, boolean isClose) throws Exception {
		File file = new File(fileName);
		file.delete();
		file.createNewFile();

		BufferedWriter bf = null;
		FileOutputStream outputStream = new FileOutputStream(file, true);
		OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
		bf = new BufferedWriter(outWriter);
		bf.append(text);
		bf.newLine();
		bf.flush();

		if (isClose) {
			bf.close();
		}
	}

	/*
	 * 结果 :现在，文本文件“javaio-appendfile.txt”内容更新如下： ABC Hello This content will
	 * append to the end of the file
	 */
	public static void write001() {
		try {
			String data = " This content will append to the end of the file";
			String path_name = "D:\\";
			String file_name = "123.txt";
			String URI = path_name+file_name;
			
			File file = new File(URI);
			
			//如果不存在，创建新的文件
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			FileWriter fileWritter = new FileWriter(file.getAbsolutePath(), true);
			
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.newLine();
			bufferWritter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write002() {
		try {
			String content = "This is the content to write into file";
			File file = new File("/users/mkyong/filename.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write003() {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("c:/newfile.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void write004() {
		File file = new File("D:/newfile.txt");
		String content = "This is the text content";

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		int a = 0;
//		while (a < 10) {
//			// TODO Auto-generated method stub
//			try {
//				saveToFile("3", "d:\\123.txt", false);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			a++;
//		}
		write001();

	}

}
