package com.windsing.baseClass;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

/**
 * String 类型是不可变的，可以被共享。String buffer 支持可变字符串
 * 
 * @author FC
 *
 */

public class TestString {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "123";
		
		/**
		 * HashMap的键值对都可以为null
		 * 更适合单线程的操作
		 */
		Map hm = new HashMap<>();
		
		/**
		 * Hashtable 里面实现了很多的 synchronized（同步）的方法
		 * 现成安全的
		 */
		Map ht = new Hashtable<>();
		
	}

}
