package com.windsing.myTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CalendarTest {

	public static Map<String, String> getWeekDay() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		
		map.put("mon", df.format(cal.getTime()));
		
		System.out.println("********得到本周一的日期*******" + df.format(cal.getTime()));
		
		// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		// 增加一个星期，才是我们中国人理解的本周日的日期
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		
		map.put("sun", df.format(cal.getTime()));
		System.out.println("********得到本周天的日期*******" + df.format(cal.getTime()));
		
		return map;
	}

	public static void main(String[] args) {

		//获取日历的实例
		Calendar cl = Calendar.getInstance();
		
		//获取本周一的时间
		cl.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date d = cl.getTime();
		
		//格式化时间的输出
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String monday_date = sdf.format(d);
		
		System.out.println(monday_date);
		
		Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
		cal.add(Calendar.DAY_OF_MONTH, -30);// 取当前日期的前一天.
		//cal.add(Calendar.DAY_OF_MONTH, +1);// 取当前日期的后一天.

		// 通过格式化输出日期
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("Today is:" + format.format(Calendar.getInstance().getTime()));

		System.out.println("yesterday is:" + format.format(cal.getTime()));

	}

}
