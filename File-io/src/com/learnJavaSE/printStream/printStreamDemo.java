package com.learnJavaSE.printStream;

import java.io.*;

public class printStreamDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//PrintStream ps = new PrintStream("src/print.txt");
		
		//PrintWriter ps = new PrintWriter("src/print.txt");
		PrintStream ps = new PrintStream(new FileOutputStream("src/print.txt",true));//追加功能交给上层类
		
//		ps.print("你好");
//		ps.println("我叫曹成梁");
//		ps.println("我爱学习");
		
		System.out.println("你好！");
		System.out.println("我叫曹成梁！");
		System.out.println("我爱学习！");
		///输出重定向
		System.setOut(ps);
		
		System.out.println("你好！");
		System.out.println("我叫曹成梁！");
		System.out.println("我爱学习！");
		
		ps.close();

	}

}
