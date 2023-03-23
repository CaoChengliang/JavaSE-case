package com.learnJavaSE.Thread_communication;

import java.util.*;

public class TestThreadCommunicationDemo1 {

	public static void main(String[] args) throws InterruptedException {
		  var q = new TaskQueue();
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

class TaskQueue {
	
	Queue<String> qe = new LinkedList<>();
	
	public synchronized void addTask(String s) {
		
		
		try {
			this.qe.add(s);
			this.notifyAll();
			//this.wait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public synchronized String getTask() throws InterruptedException {
		
		while(this.qe.isEmpty()) {
			//this.notifyAll();
			this.wait();
			
		}
				
			
		
			return this.qe.remove();
			
		
		
	}
	
	
	
}