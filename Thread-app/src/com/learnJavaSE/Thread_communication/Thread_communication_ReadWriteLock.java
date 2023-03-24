package com.learnJavaSE.Thread_communication;

import java.util.Arrays;
import java.util.concurrent.locks.*;
//能同时读，写的时候不允许枷锁
public class Thread_communication_ReadWriteLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c = new Counter();
		
		var add1 = new Thread(() ->{
			
			for(int i = 0 ;i < 10 ;i++) {
				
				c.add(i);	
				System.out.println(Thread.currentThread().getName()+" 线程添加了第" +i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		},"lb");
		
		add1.start();
		
		for(int i = 0 ; i < 5; i++) {
			
			var t = new Thread(()->{
				
			
					
					int[] result = c.get();
					System.out.println(Thread.currentThread().getName()+" 线程获取了" +Arrays.toString(result));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				
			},"work"+i); 
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		var add = new Thread(() ->{
			
			for(int i = 0 ;i < 10 ;i++) {
				
				c.add(i);	
				System.out.println(Thread.currentThread().getName()+" 线程添加了第" +i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		},"lb");
		
		add.start();

	}

}


class Counter{
	
	private final ReadWriteLock  rwlock = new ReentrantReadWriteLock();
	private final Lock  wlock = rwlock.writeLock();
	private final Lock  rlock = rwlock.readLock();
	
	private int[] counter = new int[10];
	
	
	public void add(int index) {
		wlock.lock();
		try {
			counter[index]+=1;
			
		}finally {
			
			
			wlock.unlock();
		}
	
		
	}
	
	public int[] get() {
		
		rlock.lock();
		try {
			
			return Arrays.copyOf(counter, counter.length);
			
		}finally {
			rlock.unlock();
		}
		
	}
	
}