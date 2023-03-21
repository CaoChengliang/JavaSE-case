package com.learnJavaSE.Write_Reader;

import java.io.*;

public class ReaderDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Reader re = new FileReader("src/data.txt");//创建字符流读取管道
		
		
		System.out.println((char)re.read());//读一个字符以编码的形式读
		
		//一次读多个
		
		char [] read = new char[1024];
		
		int len;
		
		while((len = re.read(read)) != -1) {
			
			String newstring = new String(read,0 ,len);
			System.out.println(newstring);
			
		}
		
		re.close();
	}

}
