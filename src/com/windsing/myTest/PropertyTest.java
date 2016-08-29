package com.windsing.myTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyTest {

	static String file_path = "myProperties";
	static String file_name = "property_Source.properties";

	public static void main(String[] args) throws Exception {

		// 获取文件
		Properties properties = new Properties();
		File file_dir = new File(System.getProperty("user.dir"), file_path);
		File file = new File(file_dir, file_name);

		System.out.println("文件路径：" + file.getAbsolutePath());

		// 读取并加载文件
		FileInputStream inStream = new FileInputStream(file);
		properties.load(inStream);
		
		//Returns an enumeration of all the keys in this property list
		Enumeration<?> enumeration = properties.propertyNames();
		System.out.println("enum1::" + enumeration);
		
		//输出key and value
		while (enumeration.hasMoreElements()) {
			String strKey = (String) enumeration.nextElement();
			String strValue = properties.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}

}
