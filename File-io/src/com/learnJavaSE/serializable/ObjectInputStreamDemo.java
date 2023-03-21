package com.learnJavaSE.serializable;

import java.io.*;

/**
 * 将对象反序列化，使用对象字节流将文件中的对象数据恢复成内存中的Java对象
 *
 */
public class ObjectInputStreamDemo {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		//创建管道
		ObjectInputStream is  = new ObjectInputStream(new FileInputStream("src/obj.txt"));
		
		//反序列化
		Student s = (Student)is.readObject();
		
		System.out.println(s);
		
	}

}
