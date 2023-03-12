package com.learnJavaSE.StringAPI;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	/*三个方法分别是
	 *  1. 验证码： 创建一个 5位数验证码。方法：创建一个String变量存储0-9\A-Z\a-z,产生一个随机数利用随机数获取String变量中的字符
	 *  2. 模拟登陆： 模拟判断登陆是否成功。 方法：存储一个用户密码对，然后用户输入判断是否匹配。
	 *  3. 号码隐藏： 隐藏一个号码的中间四位。 方法：截取号码中间字符串然后用****替换。
	 *   
	 *   
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //yanzhengma();
         
        //monidenglu();
         
        haomayincang();
	}

	private static void haomayincang() {
		
		String PhoneNumber = "18812345678";
		
		String xx = "****";
		
		String before = PhoneNumber.substring(0,3);//获取 0 - 2，3个字符串
		String After = PhoneNumber.substring(7);//获取后四位。
		
		String hideNumber = before + xx +After;
		
		System.out.println(hideNumber);
		
		
		
		
		
		
	}

	private static void monidenglu() {
		
		String okLoginName = "admin";//为了学习暂时先设置一个
		String okPassword = "123456789";
		
		//输入三次结束
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			
			System.out.println("请输入您的登陆名称：");
			String name = sc.next();
			System.out.println("请输入您的登陆密码");
			String pass = sc.next();
			
			if(okLoginName.equals(name)) {
				if(okPassword.equals(pass)) {//引用类型比较用equals,不能用==,  .equalsIgnoreCase()忽略大小写的比较
					System.out.println("恭喜您登陆成功");
					break;
				}else {
					System.out.println("密码或账户名错误！您还有"+(2-i)+"次机会");
				}
			}else {
				System.out.println("密码或账户名错误！您还有"+(2-i)+"次机会");
			}
			if(i==2) {
				System.out.println("登陆失败，请联系管理员修改密码！");
			}
			
		}
		
		
	}

	private static void yanzhengma() {
		// TODO Auto-generated method stub
		
		String sourcedata = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
		
		String code="";
		
		Random r = new Random();
		
		for(int i = 0; i<5 ; i++) {
			
			char c = sourcedata.charAt(r.nextInt(sourcedata.length()));
			
			code += c;
		}
		
		System.out.println(code);
		
		
	}

}
