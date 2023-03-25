package com.learnJavaSE.ThreadAPI;

public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 5 ;i++) {
			
			System.out.println("main线程在运行"+i);
			
			if(i == 3) {
				//睡眠3s
				Thread.sleep(3000);
				
			}
			
		}		

	}

}
