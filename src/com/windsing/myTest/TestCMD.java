package com.windsing.myTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestCMD {
	
	/**
	 * 执行cmd命令，且输出信息到控制台
	 * @param cmd
	 */
	public static void execCmd(String cmd) {
		
		System.out.println("----execCmd:  " + cmd);
		
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			
			// 正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println("line:"+line);
			}
			
			// 错误输出流
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		//execCmd("adb shell dumpsys meminfo com.twl.qichechaoren_business | grep 'TOTAL' | tee /sdcard/qb_mem2.xls");
		//execCmd("adb shell dumpsys meminfo com.twl.qichechaoren_business >> /sdcard/qb_mem.txt");
		//execCmd("adb shell dumpsys meminfo com.twl.qichechaoren_business | tee /sdcard/qb_mem2.txt");
		//execCmd("adb shell dumpsys meminfo com.twl.qichechaoren_business | sed -n '8,9p' | tee /sdcard/qb_mem2.txt");
		
		/*
		 * ----execCmd:  adb shell dumpsys meminfo com.twl.qichechaoren_business >> D:/Work/logs/qb_mem2.txt
		 * /system/bin/sh: can't create D:/Work/logs/qb_mem2.txt: No such file or directory
		 * 
		 */
		execCmd("adb shell rm -f /sdcard/qb*");
		while(true){
			execCmd("adb shell dumpsys meminfo com.twl.qichechaoren_business | grep 'TOTAL' >> /sdcard/qb_mem2.txt");
			Thread.sleep(500);
		}
		
		
	}
}
