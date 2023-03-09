package com.learnJavaSE.DigitalEncrytion;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/* 需求： 
	 *  某系统的数字密码：比如1983，采用加密方式进行传输，规则如下：先得到每位数，
	 *  然后每位数都加上5，再对10求余，最后将数字反转，得到新数。
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//输入整数调用加密算法
		//int Message = 3891; // 原文
		//int s = EncryM1(Message);
		//System.out.println(s);
		
		//单个数字的输入加密
		System.out.println("请输入你想要加密的数字数量：---");
		
		int length;//输入几个数
		
		Scanner sc  = new Scanner(System.in);
		
		length = sc.nextInt();
		
		int []array = new int[length];//定义存放加密数字
		
		for(int i = 0; i < length ;i++) {//输入
			System.out.println("请输入您想加密的第 "+(i+1)+" 个数：");
			array[i] = sc.nextInt();
			
		}
		
		//输出数字
	    System.out.println(Arrays.toString(array));
		
		for(int i = 0; i < length ;i++) {//输入
			array[i] = (array[i] + 5) % 10;
			
		}
		System.out.println(Arrays.toString(array));
		//反转
		for(int i = 0, j = array.length - 1;i < j;i++,j--) {
			int temp;
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			
		}
		//输出加密数字
		System.out.println(Arrays.toString(array));

	}
	

	

	public static int EncryM1(int message) {//突发奇想方法：输入整数如何返回加密数字
		int []bool = new int[10];
		int cip = 0;     //密文
		int count = 0;
		while(message!=0) {
			bool[count] = ( (message % 10)+5)%10;
			message /= 10;
			count++;	
			
		}
		for(int i = 0;i < count;i++) {
			cip += bool[i];
			if(i!=count-1)
			 cip *= 10;
			
		}
		return cip;
	}

}
