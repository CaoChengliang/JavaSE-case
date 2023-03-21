package com.learnJavaSE.outputstream;

import java.io.*;

public class OutputStreamDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.创建输出流管道
		OutputStream os = new FileOutputStream("src/Out.txt",true);//若是想每次添加数据不删除原来数据要在构造时添加append字段FileOutputStream("src/Out.txt",true)
		
		os.write(97);
		os.write(98);
		//os.write('徐');
		byte[] buffer0 = "\r\n".getBytes();
		os.write(buffer0);
		
		byte[] buffer = {97,98,'a'};
		
		os.write(buffer);
		
		//存储中文
		//byte[] buffer1 = "张".getBytes();//根据编码要一致原则，若不一致则乱码
		byte[] buffer1 = "张".getBytes("GBK");
		os.write(buffer1);
		
		//刷新数据，因为内存块，磁盘慢，缓冲区内数据容易被弄坏，所以用flush();强制输出
		os.flush();
		os.close(); //关闭流释放资源
		

	}

}
