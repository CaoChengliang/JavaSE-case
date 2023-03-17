package com.learnJavaSE.Exception;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//最好的方式是底层抛出最外层捕获处理
import java.util.*;

//自己捕获异常后处理
public class Exception_handle {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		System.out.println("程序开始。。。。。。。。。。。。");
		parseTime("2022-12-23 12:12:12");
		
		
		System.out.println("程序结束。。。。。。。。。。。。。");

	}

	private static void parseTime(String string)  {
		// TODO Auto-generated method stub
		
		
		var sdf = new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");
		
		Date data;
		try { //一般是放在一起进行trycatch 因为代码上下有关联上面有错误下面就不用运行了 ，也建议直接使用Exception e,
			data = sdf.parse(string);
			
			System.out.println(data);
			
			
			InputStream input = new FileInputStream("E:/");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			System.out.println("出现问题");
//			e.printStackTrace();
//		}//如果直接抛出的话,,谁先出问题先抛谁,,,不会都抛出
//		  catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
			
		
		
		
//		var sdf = new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");
//		
//		Date data;
//		try {
//			data = sdf.parse(string);
//			System.out.println(data);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			System.out.println("出现问题");
//			e.printStackTrace();
//		}//如果直接抛出的话,,谁先出问题先抛谁,,,不会都抛出
//		
//		
//		try {
//			InputStream input = new FileInputStream("E:/");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
