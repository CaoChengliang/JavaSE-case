package com.learnJavaSE.createThread1;

public class ThreadDemo1 {
///使用Thread 创建线程
	
	public static void main(String[] args) {
		//创建线程
		Thread t = new MyThread();
		t.start();
		/**
		 * 为什么不用run()启动
		 * 1.run()还是普通方法，调用run()系统不会启动线程
		 */
		
		
		
		// 主线程
		for(int i = 0; i < 5 ;i++) {
			
			System.out.println("主线程在运行"+i);
			
		}

	}
	
	

}

class MyThread extends Thread{
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5 ;i++) {
			
			System.out.println("子线程在运行"+i);
			
		}
		
	}
	
}