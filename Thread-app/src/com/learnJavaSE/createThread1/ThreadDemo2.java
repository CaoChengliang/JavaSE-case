package com.learnJavaSE.createThread1;

public class ThreadDemo2 {

	public static void main(String[] args) {
		// 方法二：使用Runnable接口进行线程创建
		//1.创建任务对象
		Runnable r = new MyRunnable();
		//2.将任务放入线程
		Thread t = new Thread(r,"1号");
		
		//3.开启子线程
		t.start();
		
		for(int i = 0; i < 10 ;i++) {
			
			System.out.println("主线程在运行"+i);
			
		}

	}

}


class MyRunnable implements Runnable{//只是实现了接口，可以再继承其他类，但不能返回结果

	@Override
	public void run() {
		
		for(int i = 0; i < 10 ;i++) {
			
			System.out.println("子线程在运行"+i);
			
		}
	
		
	}
	
	
	
}
