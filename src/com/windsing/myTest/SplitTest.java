package com.windsing.myTest;

public class SplitTest {
	
	static void split001(){
		String s = "¥15";
		String[] s_num = s.split("¥");
		for(String num:s_num){
			System.out.println(num);
		}
		
		for(int i =0 ;i<s_num.length;i++){
			System.out.println("index:"+i+"\t"+s_num[i]);
		}
		System.out.println(s_num.toString());
		System.out.println(s_num.length);	
	}
	
	static void split002(){
		String s = "¥15";
		String[] s_num = s.split("¥");
		System.out.println(s_num[s_num.length-1]);
	}
	
	/**
	 * 用全部的空白字符分割
	 */
	static void split003(){
		String s = "sdfknksd     304920     asdof     奥德没地方";
		String[] s_num = s.split("\\s+");
		for(String ss:s_num){
			System.out.println(ss);
		}
		
	}
	
	/**
	 * 使用“.”分割
	 */
	static void testDot(){
		String s = "com.abc.123";
		String[] s0 = s.split("\\.");
		System.out.println(s0.length);
		System.out.println(s0[0]);
	}
	
	static void testDot2(){
		String s = "com_abc_123";
		String[] s0 = s.split("\\.");
		System.out.println("数组长度：："+s0.length);
		System.out.println("第一个元素：："+s0[0]);
	}
	
	public static void main(String[] args){
		split003();
	}
}
