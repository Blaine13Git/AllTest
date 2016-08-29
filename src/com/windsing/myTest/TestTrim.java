package com.windsing.myTest;

/*
 * trim() 去掉字符串两头的空格
 */
public class TestTrim {
	
	public static void test(){
		String s = "1234567890 ".trim();
		System.out.println(s);
		
		String ss = "123 456 789 0 ".replaceAll(" ", "");
		int count  = 0;
		System.out.println(ss);
		while(!ss.equals(s) && count == 0){
			System.out.println("不等于~~");
		}
	}
	
	public static void test2(){
		String s = "MemTotal:        1876768 kB";
		String[] s_Array = s.split(":");
		for(String ss : s_Array){
			System.out.println(ss);
		}
		System.out.println(s_Array[1].trim());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test();
		test2();
	}

}
