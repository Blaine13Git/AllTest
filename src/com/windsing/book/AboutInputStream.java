package com.windsing.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 */
public class AboutInputStream {
	

	public static void main(String[] args) {
		String pathname = "";
		File file = new File(pathname);
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis2 = new FileInputStream(pathname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
