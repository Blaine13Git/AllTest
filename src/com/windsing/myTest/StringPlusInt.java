package com.windsing.myTest;

import java.util.concurrent.TimeUnit;
/**
 * 线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中�??
 * 线程获取锁时，JMM会把该线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须从主内存中读取共享变量�?
 * 
 */
public class StringPlusInt {

	public static void main(String[] args) throws InterruptedException {
		String s = "2"+2;
		System.out.println(s);
	}

}
