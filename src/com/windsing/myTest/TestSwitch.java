package com.windsing.myTest;

public class TestSwitch {
	
	public static String testSwitchReturn(String s){
		switch(s){
		case "a": 
			return s;
		default : 
			return "mm";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSwitchReturn("a");
		System.out.println();
	}

}
