package com.windsing.testSource;

public class People {

	public static String name;
	public static int age;
	public static final String GENDER = "男";
	public static String hobbit;
	
	//单例模式，只产生一个people对象。
	private static People people= null;
	public static People getInstace(){
		
		if(people == null){
			people = new People();
		}
		return people;
		
	}

}
