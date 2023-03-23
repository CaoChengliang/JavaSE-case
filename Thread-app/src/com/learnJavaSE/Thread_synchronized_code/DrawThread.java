package com.learnJavaSE.Thread_synchronized_code;

public class DrawThread extends Thread{
	
	private Account acc;
	
	public DrawThread(Account acc, String name) {
		super(name);
		this.acc = acc;
	}

	@Override
	public void run() {
		
		this.acc.drawmoney(10000);
		
		
	}
	
}
