package com.learnJavaSE.Exception;


//默认异常处理是出现异常后，最终抛给JVM虚拟机打印异常强制结束程序

public class Exception_default {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始。。。。。。。。。。。。");
		
		divide(10 , 0);
		
		
		System.out.println("程序结束。。。。。。。。。。。。");

	}
	
	public static void divide(int a, int b ) {
		
		System.out.println(a);
		System.out.println(b);
		
		try {
			
			int c = a / b;
			
			System.out.println(c);
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		
	}

}
