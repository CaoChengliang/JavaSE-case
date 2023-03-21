package com.learnJavaSE.Buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBuffer {
//各个io流速度显示
	public static void main(String[] args){
		// TODO Auto-generated method stub
		//copy01(); //普通流一个字节一个字节复制，极慢放弃
		copy02(); //缓冲流一个字节一个字节复制
		copy03(); //普通流设置缓冲区
		copy04(); //缓冲流设置缓冲区
		

	}

	
	
	private static void copy04() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		try(    InputStream is = new FileInputStream("D:\\CoderLife\\resource\\钉钉 2022-03-16 20-06-43.mp4"); 
				
				//换成缓冲流
				InputStream bis = new BufferedInputStream(is);
				
				OutputStream os = new FileOutputStream("src/new4.mp4");
				
				OutputStream bos = new BufferedOutputStream(os);
				
				){
				
				byte[] buffer = new byte[1024];
				int len; //定义一个长度记录每次输入的长度，用来防止写入时写错
				
				while((len = bis.read(buffer)) != -1 ) {
					
					bos.write(buffer,0 , len);	
					
				}
				
				long endTime = System.currentTimeMillis(); 
				System.out.println("复制完成！用时：" + (endTime - startTime)/1000+"s");
			
				
			}catch(Exception e) {
				
				e.getStackTrace();
				
			}
		
	}

	private static void copy03() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		try(    InputStream is = new FileInputStream("D:\\CoderLife\\resource\\钉钉 2022-03-16 20-06-43.mp4"); 
				
				//换成缓冲流
				//InputStream bis = new BufferedInputStream(is);
				
				OutputStream os = new FileOutputStream("src/new3.mp4");
				
				//OutputStream bos = new BufferedOutputStream(os);
				
				){
				
				byte[] buffer = new byte[1024];
				int len; //定义一个长度记录每次输入的长度，用来防止写入时写错
				
				while((len = is.read(buffer)) != -1 ) {
					
					os.write(buffer,0 , len);	
					
				}
				long endTime = System.currentTimeMillis(); 
				System.out.println("复制完成！用时：" + (endTime - startTime)/1000+"s");
				
			}catch(Exception e) {
				
				e.getStackTrace();
				
			}
		
	}

	private static void copy02() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		try(    InputStream is = new FileInputStream("D:\\CoderLife\\resource\\钉钉 2022-03-16 20-06-43.mp4"); 
				
				//换成缓冲流
				InputStream bis = new BufferedInputStream(is);
				
				OutputStream os = new FileOutputStream("src/new2.mp4");
				
				OutputStream bos = new BufferedOutputStream(os);
				
				){
				
				
				int len; //定义一个长度记录每次输入的长度，用来防止写入时写错
				
				while((len = bis.read()) != -1 ) {
					
					bos.write(len);	
					
				}
				long endTime = System.currentTimeMillis(); 
				System.out.println("复制完成！用时：" + (endTime - startTime)/1000+"s");
				
			}catch(Exception e) {
				
				e.getStackTrace();
				
			}
		
	}

	private static void copy01() {
		long startTime = System.currentTimeMillis();
		try(    InputStream is = new FileInputStream("D:\\CoderLife\\resource\\钉钉 2022-03-16 20-06-43.mp4"); 
				
				//换成缓冲流
			
				
				OutputStream os = new FileOutputStream("src/new1.mp4");
				
			
				
				){
				
		
				int len; //定义一个长度记录每次输入的长度，用来防止写入时写错
				
				while((len = is.read()) != -1 ) {
					
					os.write(len);	
					
				}
				long endTime = System.currentTimeMillis(); 
				System.out.println("复制完成！用时：" + (endTime - startTime));
				
			}catch(Exception e) {
				
				e.getStackTrace();
				
			}
		
		
	}
	
	

}
