package com.learnJavaSE.captch;

import java.util.Random;

public class Main {
      //需求：定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Captch;
		Captch = CreatCode(5);
		System.out.println(Captch);
		
		
	}
	public static String CreatCode(int n) {//验证码产生方法
		Random r = new Random();//随机数种子
		String code = "";//验证码
		for (int i = 0; i < n; i++) {
			int type = r.nextInt(3);//0为大写字母， 1 为小写字母， 2是数字
			switch(type) {
			   case 0:
				  char v =  (char)(r.nextInt(25)+65);//A-Z
				  code = code + v;
				  break;
			   case 1:
				   char v1 = (char)(97+r.nextInt(25));//a-z
				   code = code + v1;
				   break;
			   case 2:
				   int v2 = r.nextInt(10);//0-9
				   code = code + v2;
				   break;
			}
			
		}
		return code;
	}

}
