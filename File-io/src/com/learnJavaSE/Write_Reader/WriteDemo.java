package com.learnJavaSE.Write_Reader;

import java.io.FileWriter;
import java.io.IOException;
//字符流适合中文文本的读写操作
public class WriteDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter wr = new FileWriter("src/out_write.txt",true);//加true追加数据
		
		//写单个字符
		wr.write('a');
		wr.write('b');
		wr.write('中');
		wr.write("\r\n");
		
		//一堆字符
		char[] c = "我爱中国".toCharArray();
		
		wr.write(c);
		
		wr.close();

	}

}
