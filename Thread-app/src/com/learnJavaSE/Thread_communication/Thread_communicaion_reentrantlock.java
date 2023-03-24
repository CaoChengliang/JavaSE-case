package com.learnJavaSE.Thread_communication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_communicaion_reentrantlock {

	public static void main(String[] args) throws InterruptedException {
		    var q = new TaskQueue1();
	        var ts = new ArrayList<Thread>();
	        for (int i=0; i<5; i++) {
	            var t = new Thread(() -> {
	                    // 执行task:
	                    while (true) {
	                        try {
	                            String s = q.getTask();
	                            System.out.println(Thread.currentThread().getName()+"execute task: " + s);
	                        } catch (Exception e) {
	                            return;
	                        }
	                    }
	               
	            },"worker"+i);
	            t.start();
	         ts.add(t);
	        }
//	        var add = new Thread(() -> {
//	          
//	        	  
//	        	  for (int i=0; i<10; i++) {
//		                // 放入task:
//		                String s = "t-" + Math.random()+"task"+i;
//		                System.out.println(Thread.currentThread().getName()+"add task"+i+": " + s);
//		                q.addTask(s);
//		                try { Thread.sleep(100); } catch(InterruptedException e) {}
//		            
//	        	  
//	          }
//	        },"laoban");
//	        add.start();
//	        var add1 = new Thread(() -> {
//		          
//	        	  
//	        	  for (int i=0; i<10; i++) {
//		                // 放入task:
//		                String s = "t-" + Math.random()+"task"+i;
//		                System.out.println(Thread.currentThread().getName()+"add task"+i+": " + s);
//		                q.addTask(s);
//		                //try { Thread.sleep(100); } catch(InterruptedException e) {}
//		            
//	        	  
//	          }
//	        },"laoban1");
//	        add1.start();
	        var add2 = new Thread(() -> {
		          
	        	  
	        	  for (int i=0; i<10; i++) {
		                // 放入task:
		                String s = "t-" + Math.random()+"task"+i;
		                System.out.println(Thread.currentThread().getName()+"add task"+i+": " + s);
		                q.addTask(s);
		               try { Thread.sleep(100); } catch(InterruptedException e) {}
		            
	        	  
	          }
	        },"laoban2");
	        add2.start();
	       add2.join();
	        Thread.sleep(100);
	        for (var t : ts) {
	            t.interrupt();
      }
	        }

}
class TaskQueue1 {
	
	private  final Lock lock = new ReentrantLock();
	private  final Condition condition = lock.newCondition();
	
	
	private Queue<String> qe = new LinkedList<>();
	
	public  void addTask(String s) {
		
		lock.lock();
		try {
			
			qe.add(s);
			condition.signalAll();
			
		}finally {
			
			lock.unlock();
		}
		
		
		
	}
	
	
	public String getTask() throws InterruptedException   {
		lock.lock();
		try {
			
			while(this.qe.isEmpty()) {
				//this.notifyAll();
				condition.await();
				
			}
			return this.qe.remove();
		}finally{
			
			lock.unlock();
		}
		
				
			
		
			
			
		
		
	}
	
	
	
}
