package com.learnJavaSE.Logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	//创建Logback日志对象
	
	public static final Logger LOGGER = LoggerFactory.getLogger("Test.class");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				
				LOGGER.debug("我要开始执行了。。。。。。。");
				LOGGER.info("开始执行");
				int a = 10;
				int b = 0;
				
				LOGGER.trace("a= "+ a);
				LOGGER.trace("b= "+ b);
				
				System.out.println(a / b);
			
				
			}catch(Exception e) {
				
				e.getStackTrace();
				LOGGER.error("程序有问题了" + e);
				
			}
			
	}

}
