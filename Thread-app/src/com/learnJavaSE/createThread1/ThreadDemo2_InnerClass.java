package com.learnJavaSE.createThread1;

public class ThreadDemo2_InnerClass {
	
	public static void main(String[] args) {
		// 方法二：使用Runnable接口进行线程创建
		//1.创建任务对象
		Runnable r = new MyRunnable();
		//2.将任务放入线程
		Thread t = new Thread(r);
		
		//3.开启子线程
		t.start();
		
		
		Thread r2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for(int i = 0; i < 10 ;i++) {
					
					System.out.println("子线程2在运行"+i);
					
				}
				
			}
			
		});
		r2.start();
		
		
		new Thread(() -> {
			
			for(int i = 0; i < 10 ;i++) {
			
			System.out.println("子线程3在运行"+i);
			
		}}).start();
		
		
		
		for(int i = 0; i < 10 ;i++) {
			
			System.out.println("主线程在运行"+i);
			
		}

	}
	

}


