package com.learnJavaSE.createThread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 学会线程创建方式三，s实现Callable接口，利用FutureTask完成
 *
 */
public class ThreadDemo3 {

	public static void main(String[] args) {
		
		//创建Callable 对象
		Callable<String> call  = new MyCallable(100);
		//用FutureTask去接call
		FutureTask<String> f1 = new FutureTask<>(call);
		
		Thread t1 = new Thread(f1);
		
		t1.start();
		
		//用FutureTask取线程运行结果
		try {
			String rs1 =  f1.get();
			System.out.println("线程1结束" +rs1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}


//实现Callable接口类
class MyCallable implements Callable<String>{
	
	private int n;
	
	public MyCallable(int n) {
		this.n = n;
	}

	@Override
	public String call() throws Exception {
			
		int sum = 0;
		
		for(int i = 1; i <= n ;i++) {
			
			sum += i;
			
		}

		
		
		return "线程的结果为 "+ sum;
	}
	
	
	
}
