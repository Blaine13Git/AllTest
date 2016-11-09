package com.windsing.myTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-01 00:00:00");//设置日期格式
		String today_time = df.format(new Date()).toString();
		System.out.println(today_time);// new Date()为获取当前系统时间
	}

}
