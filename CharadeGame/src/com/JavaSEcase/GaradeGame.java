package com.JavaSEcase;

import java.util.Random;
import java.util.Scanner;

public class GaradeGame {
	/*
	 * 需求：
	 *  随机生成一个1-100之间的数据，提示用户猜测，猜大提示过大，猜小提示猜小，直到猜中结束游戏 分析： 随机生成一个1-100之间的数据
	 * 分析：
	 *  使用死循环不断提示用户猜测，猜大提示过大，猜小提示猜小。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer RandomNumber = Integer.valueOf(new Random().nextInt(100)+1) ;//创建一个随机整数
		
		Integer UserInputNumber ;//用户输入数字
		
		@SuppressWarnings("all")//取消黄色感叹号，因为下面的输入流scanner我直接在下面循环里调用了没有指定一个变量所以出现感叹号比较烦，可直接忽略。	
		Scanner scanner = new Scanner(System.in);//设置输入流
		
		System.out.println("-------------");
		System.out.println("猜字游戏，输入一个数字，猜大会提示过大，猜小会提示猜小，直到猜中结束游戏");
		System.out.println("-------------");
		System.out.println("请输入您猜测的数字: ");
		
		while(true) {//循环直到猜对数字
			
			UserInputNumber = Integer.valueOf(scanner.nextInt());//用户输入数据
			if(UserInputNumber.intValue()==RandomNumber.intValue()) {
				System.out.println("恭喜，您猜对啦，游戏结束！");
				break;//猜对数字跳出循环
			}
			if(UserInputNumber.intValue()<RandomNumber.intValue()) {
				System.out.println("您猜测的数字较小，请继续猜测");
				
			}else if(UserInputNumber.intValue()>RandomNumber.intValue()) {
				System.out.println("您猜测的数字较大，请继续猜测");
			}
			
         

	   }

     }
}
