package com.windsing.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 * 
 */
public class AboutInputStream {
	
	public static void main(String[] args) {
		String pathname = "";
		File file = new File(pathname);
		try {
			FileInputStream fis = new FileInputStream(file);
			/**
			 * 传入的参数如果是一个文件，会进行安全检查
			 * 安全管理器是允许应用程序实施安全策略的类。
			 * 它允许应用程序在执行可能不安全或敏感的操作之前确定操作是什么以及是否在允许执行操作的安全上下文中尝试。
			 */
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
