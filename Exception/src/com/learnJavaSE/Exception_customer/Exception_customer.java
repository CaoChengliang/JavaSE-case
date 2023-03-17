package com.learnJavaSE.Exception_customer;

public class Exception_customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		try {
//			checkAge(-1);//提醒强烈可以定义成编译式异常
//		} catch (IllegalAgeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			checkAge(-1);//提醒不强烈可以定义成运行时异常，不会打扰到别人
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
   
	
	public static void checkAge(int age) throws IllegalAgeRuntimeException {
		
		if(age < 0 || age > 200) {
			
			//throw 是在方法内抛出此点异常
			//throws 是在方法声明中抛出此方法异常
			
			//throw new IllegalAgeException(age + " is Illegal");
			
			throw new IllegalAgeRuntimeException(age + " is Illegal");
			
		}else {
			
			System.out.println("年龄合法");
			
		}
		
	}
}
