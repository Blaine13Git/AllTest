package com.windsing.myTest;

public class SubStringTest {
	
	public static void testSubString(){
		String s = "10qwe�ǵ���ȵ�rt";
		String s_sub = s.substring(0,s.length()-3);
		System.out.println(s_sub);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSubString();
	}

}
