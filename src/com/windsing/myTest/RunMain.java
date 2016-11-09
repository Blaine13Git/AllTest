package com.windsing.myTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunMain {
	
	public void execCmd(String cmd) {
		System.out.println("----execCmd:  " + cmd);
		try {
			// 获取当前运行时环境
			Process p = Runtime.getRuntime().exec(cmd);
			
			// 输入流
			InputStream input = p.getInputStream();
			
			// 读取输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line = reader.readLine();
			while (line!= null) {
				// 显示输入的命令
				System.out.println(line);
				//saveToFile(line, "runlog.log", false);
			}
			
			// 错误输出流
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
				//saveToFile(eline, "runlog.log", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunMain  r = new RunMain();
		r.execCmd("adb shell");
	}

}
