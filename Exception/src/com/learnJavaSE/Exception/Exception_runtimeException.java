package com.learnJavaSE.Exception;

/*
 * RuntimeException异常是指编译期不会有提示，运行期发现的错误，一般指程序员水平问题
 * 
 * */

public class Exception_runtimeException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("程序开始。。。。。。。。。。。。。。。。");
		
		//数组索引异常 ArrayIndexOutOfBoundsException
		
		String [] a = {"a","c","b"};
		System.out.println(a[2]);
		//System.out.println(a[3]);
		
		//空指针异常 NullPointerException
		String s = null;
		System.out.println(s);
		//System.out.println(s.length());
		
		//数学操作异常ArithmenticException
		int i = 1;
		//System.out.println(i/0);
		
		//类型转换异常ClassCastException
		Object o = 23;
		
		String r = (String) o;
		
		
		//数字转换转换异常
		String st = "123dd";
		//Integer in = Integer.valueOf(st);
		
		System.out.println("程序结束。。。。。。。。。。。。。。。。");

	}

}
