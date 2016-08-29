package com.windsing.myTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListMap {
	
	public static void main(String[] args) {
		
		//List<Map<String, String>> lm = null; //初始化没有赋值，会导致Exception in thread "main" java.lang.NullPointerException
		List<Map<String, String>> lm = new ArrayList<>();
		Map<String,String> m1 = new HashMap<>();
		m1.put("11", "a1");
		m1.put("21", "b1");
		m1.put("31", "c1");
		Map<String,String> m2 = new HashMap<>();
		m2.put("12", "a2");
		m2.put("22", "b2");
		m2.put("32", "c2");
		Map<String,String> m3 = new HashMap<>();
		m3.put("13", "a3");
		m3.put("23", "b3");
		m3.put("33", "c3");
		
		lm.add(m1);
		lm.add(m2);
		lm.add(m3);
		
		System.out.println(lm+"==="+lm.size());
		
		System.out.println(lm.get(0).get("11"));
	}

}
