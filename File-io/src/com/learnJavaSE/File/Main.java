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
		
		File f  = new File("../File-io/src/data.txt");//相对路径（绝对路径？）
		System.out.println(f.exists());
		System.out.println(f.length());
		
		
		
			
		
	}

}
