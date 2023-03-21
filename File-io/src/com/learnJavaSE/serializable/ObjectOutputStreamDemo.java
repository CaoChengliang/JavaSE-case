package com.learnJavaSE.serializable;
import java.io.*;

/*
 * 学会对象序列化，使用ObjectOutputStream 把内存对象存入文件
 * 
 * **/
public class ObjectOutputStreamDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		//对象要序列化必须实现Serializable 接口
		Student s = new Student("曹","xiaocao", "123456",21);
		
		//创建序列化对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/obj.txt"));
		
		//调用序列化
		oos.writeObject(s);
		
		//释放资源
		oos.close();

	}

}
