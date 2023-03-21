package com.learnJavaSE.common_io;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//复制文件到文件
		IOUtils.copy(new FileInputStream("src/book.xml"), new FileOutputStream("src/new.xml"));
		//复制文件到文件夹
		FileUtils.copyFileToDirectory(null, null);
		
		//复制文件夹到文件夹
		
		FileUtils.copyDirectoryToDirectory(null, null);

	}

}
