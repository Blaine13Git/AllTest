package com.windsing.myTest;

import java.util.concurrent.TimeUnit;
/**
 * 线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中。
 * 线程获取锁时，JMM会把该线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须从主内存中读取共享变量。
 * 
 */
public class SynchronizedTest {
	
	static boolean flag = true;
	static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread A = new Thread(new Wait(), "wait thread");
		A.start();
		TimeUnit.SECONDS.sleep(2);
		Thread B = new Thread(new Notify(), "notify thread");
		B.start();
	}

	static class Wait implements Runnable {
		@Override
		public void run() {
			synchronized (lock) {//获取锁
				while (flag) {
					try {
						System.out.println(Thread.currentThread() + " flag is true");
						lock.wait();//调用wait()方法后会释放锁，线程进入等待状态……，被唤醒后，从wait()返回到锁处继续执行。
					} catch (InterruptedException e) {

					}
				}
				System.out.println(Thread.currentThread() + " flag is false");
			}
		}
	}

	static class Notify implements Runnable {
		@Override
		public void run() {
			synchronized (lock) {
				flag = false;//线程B对共享变量flag的修改对线程A来说是可见的
				lock.notifyAll();//唤醒等待中的线程，notify()或notifyAll()方法调用后，等待线程不会立刻从wait()中返回，需要等该线程释放锁之后，才有机会获取锁之后从wait()返回。
				try {
					TimeUnit.SECONDS.sleep(7);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
