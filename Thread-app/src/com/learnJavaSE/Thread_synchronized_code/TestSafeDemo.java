package com.learnJavaSE.Thread_synchronized_code;

public class TestSafeDemo {
     
	
	public static void main(String[] args) {
		
		Account fa = new Account("100",10000);
		
		Thread t1 = new DrawThread(fa ,"小红");
		Thread t2 = new DrawThread(fa," 小白");
		t1.start();
		t2.start();
		
	}
	
	
	
}
