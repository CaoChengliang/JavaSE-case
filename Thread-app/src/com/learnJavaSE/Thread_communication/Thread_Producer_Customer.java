package com.learnJavaSE.Thread_communication;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//桌子.上有一只盘子，每次只能向其中放入-一个水果。爸爸专向盘子中放苹果，妈妈专向盘子中放
//橘子，儿子专等着吃盘子中的橘子，女儿专等着吃盘子中的苹果。只有盘子空时，爸爸或妈妈才
//可向盘子中放-一个水果。仅当盘子中有自己需要的水果时，儿子或女儿可以从盘子中取出水果。
//用PV操作实现.上述过程。




public class Thread_Producer_Customer {
	
	private static final Semaphore plate = new Semaphore(1);
	private static final Semaphore Apple = new Semaphore(0);
	private static final Semaphore orange = new Semaphore(0);

//	private static final Semaphore Orange = null;
	
	public static void main(String [] arg0) {
		
		Queue<String> table = new LinkedList<>();
		
		Thread Dad = new Thread(() ->{
			
			try {
				plate.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {

				table.add("Apple");
				System.out.println(Thread.currentThread().getName()+"放入"+table.toString());
				Apple.release();

			}finally {
			
			}
			
			
		},"Dad");
		
		Thread Mom = new Thread(() ->{
			
			
		
			try {
				try {
					plate.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.add("orange");
				System.out.println(Thread.currentThread().getName()+"放入"+table.toString());
				orange.release();

			}finally {
			
			}
			
			
		},"Mom");
		
		
		Thread Son = new Thread(() ->{
			
			
			
			try {
				try {
					Apple.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 吃到"+table.toString()+"啦");	
				table.remove();		
				plate.release();

			}finally {
			
			}
			
			
		},"Son");
		
		
		Thread Daughter = new Thread(() ->{
			
			try {
				try {
					orange.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 吃到"+table.toString()+"啦");	
				table.remove();		
				plate.release();

			}finally {
			
			}
			
			
		},"Daughter");
		
		
		Dad.start();
		Mom.start();
		Son.start();
		Daughter.start();
		
	}
	
	
	
	
	
}