package com.learnJavaSE.File;

import java.io.File;

//学习 File对象
public class Main {

	public static void main(String[] args) {
		//1.File 对象的创建
		//File f  = new File("D:\\CoderLife\\resource\\data.txt");
		//File f = new File("D:/CoderLife/resource/data.txt");//反斜杠可以不用转义
		//File f = new File("D:"+File.separator+"CoderLife"+File.separator+"resource"+File.separator+"data.txt");//用APi可以适用与多个系统
		
		
		//File f = new File("D:\\CoderLife\\resource"); //File创建文件也可以是文件夹
		
		File f  = new File("src/data.txt");//相对路径（绝对路径？）eclipse能直接定位到src?!还是java版本问题
		System.out.println(f.exists());
		System.out.println(f.length());
		
		System.out.println(f.getAbsolutePath());
		
		File f1 = new File("D:\\CoderLife\\resource");
		
		String [] names = f1.list();
		
		for(String name: names ) {
			
			System.out.println(name);
		}
		
		File[] files = f1.listFiles();
		
		for(File f2: files) {
			
			System.out.println(f2);
			
		}
		
		File f3 = new File("D:/aaaaa"); 
		
		File[] dir  = f3.listFiles();//不存在返回null, 路径是文件返回null, 空文件夹返回0, 非空文件夹讲所有文件夹以及文件的路径放入, 有隐藏内容包含隐藏
		
		System.out.println(dir);
	}

}
