package com.learnJavaSE.ThreadAPI;

public class ThreadAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new MyThread();
		t1.setName("1号");
		t1.start();
		
		Thread t2 = new MyThread();
		t2.setName("2号");//设置线程名字
		t2.start();
		
		for(int i = 0; i < 5 ;i++) {
			
			System.out.println("main线程在运行"+i);
			
		}
		

	}

}

class MyThread extends Thread{
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5 ;i++) {
			//取名字+获取当前线程
			System.out.println(Thread.currentThread().getName()+ "子线程在运行"+i);
			
		}
		
	}
	
}