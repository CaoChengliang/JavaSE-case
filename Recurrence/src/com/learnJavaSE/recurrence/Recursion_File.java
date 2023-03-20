package com.learnJavaSE.recurrence;

import java.io.*;

/**
 * 目标：递归在D盘查找 IEEE IOT Journal.pdf 文件 
 *
 */
public class Recursion_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:/");
		String fileName = "IEEE IOT Journal.pdf";
		
		searchFile( dir, fileName);
		

	}

	private static void searchFile(File dir, String fileName) {
		 		
		   //判断是否是文件夹
			if(dir != null && dir.isDirectory()) {
				
				File[] files = dir.listFiles();
				
				if(files != null && files.length > 0) {
					
					for(File file: files) {
						
						if(file.isFile()) {
							
							if(file.getName().contains(fileName)) {
								
								System.out.println("恭喜您找到了 " + file.getAbsolutePath());
								
							}
							
						}else {
							
							searchFile(file, fileName);
							
						}
						
						
					}
					
				}
			}else {
				
				System.out.println("对不起您找的不是文件夹");
				
			}
		
		
	}

}
