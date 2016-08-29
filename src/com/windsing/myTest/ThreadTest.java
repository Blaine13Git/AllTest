package com.windsing.myTest;

public class ThreadTest {
	
	static boolean flag = true;
	
	public static void test001(){
		Runnable task001 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				int i = 0;
				while(flag){
					Thread t = Thread.currentThread();
					System.out.println("thread name:"+t.getName());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread = new Thread(task001);
		thread.start();
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		test001();
		Thread.sleep(3000);
		flag = false;
	}

}
