package com.learnJavaSE.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//编译时期异常，出现后必须处理否则代码不通过。
public class Exception_Javac {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	    String date ="2015-01-12 10:23:21";
	    var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    
	    Date d = sdf.parse(date);//编译期异常继承Exception.必须抛出或者try..catch处理异常
	    
	    System.out.println(d);
	    
	 }

}
