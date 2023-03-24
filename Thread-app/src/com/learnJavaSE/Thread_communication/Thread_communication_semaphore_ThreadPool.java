package com.learnJavaSE.Thread_communication;

import java.util.concurrent.*;

public class Thread_communication_semaphore_ThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final Semaphore semaphore = new Semaphore(2);
	        ExecutorService executorService = Executors.newCachedThreadPool();
	        for (int i = 0; i < 10; i++) {
	            final int index = i; 
	            executorService.execute(new Runnable() {
	                public void run() {
	                    try {
	                        semaphore.acquire();
	                        System.out.println("线程:" + Thread.currentThread().getName() + "获得许可:" + index);
	                        TimeUnit.SECONDS.sleep(1);
	                       
	                        semaphore.release();
	                        System.out.println("允许TASK个数：" + semaphore.availablePermits());  
	                        
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	        }
	        executorService.shutdown();

	}

}
