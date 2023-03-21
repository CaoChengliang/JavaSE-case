package com.learnJavaSE.outputstream;



import java.io.*;

public class CopyDemo {

	/**
	 * 
	 * 复制文件到另外一个文件夹
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//可以复制任何文件
		//try(resource){}可以不用处理流的关闭,只能是资源才能放入，必须实现了Closeable 和 AutoCloseable接口才叫资源
		try(InputStream is = new FileInputStream("D:\\CoderLife\\resource\\钉钉 2022-03-16 20-06-43.mp4"); OutputStream os = new FileOutputStream("src/new.mp4");){
			
			byte[] buffer = new byte[1024];
			int len; //定义一个长度记录每次输入的长度，用来防止写入时写错
			
			while((len = is.read(buffer)) != -1 ) {
				
				os.write(buffer,0 , len);	
				
			}
			System.out.println("复制完成！");
			
		}
		

	}

}
