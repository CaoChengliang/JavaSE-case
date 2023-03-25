package com.learnJavaSE.Thread_communication;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.*;

/**
 * StampedLock 可以允许在读的时候进行写，读完之后进行判断是否有锁改变了数据重新读。
 *
 */
public class Thread_commnunication_Stampedlock {

	public static void main(String[] args) {
		Point p = new Point(0,0);
		
		
		
		Thread t = new Thread(() -> {
			
			for(int i = 0; i< 5;i++) {
				
				p.move(i, i);
				System.out.println("这是写的第 "+ i +"次！点位是(" + p.getX()+","+p.getY() + ")");
				
			}
			
		});
		
		t.start();
		
		for(int i = 0;i<9;i++) {
			
			double s = p.distanceFromOrigin();
			
			System.out.println("读到的距离为：" + s+"点位是(" + p.getX()+","+p.getY() + ")");
			
			
		}
		

	}

}



class Point{
	
	private final StampedLock stampedlock = new StampedLock();
	private double x;
	private double y;
	
	
	
	
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public void move(double deltaX, double delatY) {
		//获取写锁
		long stamp = stampedlock.writeLock();
		
		try {
			
			x += deltaX;
			y += delatY;
			
			
		}finally {
			
			stampedlock.unlockWrite(stamp);//释放写锁
		}
		
		
	}
	
	
	public double distanceFromOrigin() {
		long stamp = stampedlock.tryOptimisticRead();//获取乐观锁；
		
		double currentX = x;//假设原始数据为（100，200） 突然有写程序把坐标改为（300，400）
		
		//此时若已读完x，则再读y时出现错误出现（100，400）
		double currentY = y;
		
		if(!stampedlock.validate(stamp)) {//检查是否数据改变
			
		   stamp = stampedlock.readLock();//获取读锁（悲观锁）
		try {
			currentX = x;
				currentY = y;
				
			}finally {
				
				stampedlock.unlockRead(stamp);
				
			}
			
			
		}
		
		return Math.sqrt(currentX * currentX + currentY * currentY );
		
	}
	
	
}