package com.learnJavaSE.TowColorBall;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	/* 需求 ：
	 *   中奖号码由6个红球和一个蓝球组成（注意：6个红球不能重复）红色是从1-33中选取，蓝色是从1-16选取
	 *   定义方法返回一组中奖号码，然后用户输入自己的号码，用户号码与随机号码进行匹配。
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] luckNumbers = createLuckNumbers();
		System.out.println(Arrays.toString(luckNumbers));
		int[] UserNumbers = userInputNumbers();
		Judge(luckNumbers,UserNumbers);

	}

	private static void Judge(int[] luckNumbers, int[] userNumbers) {
		// TODO Auto-generated method stub
		
		int HitRed = 0;//红球中奖数
		int HitBlue = 0;//蓝球中奖
		int bl = 6;
		
		for(int i = 0; i < userNumbers.length-1; i++ ) {
			
			if(userNumbers[i]==luckNumbers[i]) {//因为之前分别对luckNumber和userNumber排过序可以直接比较
				
				HitRed++;//红球统计
				
			}
		}
		
		if(userNumbers[bl]==luckNumbers[bl]) {
			HitBlue++;
		}
		
		System.out.println("本次开奖号码为："+Arrays.toString(luckNumbers));
		System.out.println("您购买的号码为："+Arrays.toString(userNumbers));
		if(HitRed == 6) {
			
		}
		switch(HitRed) {
			case 6:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中一等奖！！！！奖金10000万");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中二等奖！！！！奖金500万");
				}
				break;
			case 5:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中三等奖！！！！奖金3000元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中四等奖！！！！奖金200元");
				}
				break;
			case 4:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中四等奖！！！！奖金200元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中五等奖！！！！奖金10元");
				}
				break;
			case 3:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中五等奖！！！！奖金10元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("未中奖感谢您为彩票事业做出的贡献");
				}
				break;
			case 2:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中五等奖！！！！奖金10元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("未中奖感谢您为彩票事业做出的贡献");
				}
				break;
			case 1:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中六等奖！！！！奖金5元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("未中奖感谢您为彩票事业做出的贡献");
				}
				break;
			case 0:
				if(HitBlue == 1) {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("恭喜您中六等奖！！！！奖金5元");
				}else {
					System.out.println("本次开奖您的中奖信息为：");
					System.out.println("红球："+HitRed+" 蓝球："+HitBlue);
					System.out.println("未中奖感谢您为彩票事业做出的贡献");
				}
				break;
		}
		
		
		
	}

	private static int[] userInputNumbers() {
		// TODO Auto-generated method stub
		int [] UserNumbers = new int[7];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < UserNumbers.length; i++) {
			
			if(i<6) {
				
				System.out.println("请输入您的红球第 "+(i+1)+" 个数字");
				UserNumbers[i] = sc.nextInt();
				
			}else {
				
				System.out.println("请输入您的蓝球数字");
				UserNumbers[i] = sc.nextInt();
				
			}
			
		}
		
         for(int j =0;j<6;j++) {//给前6个红球排个序
			
			for(int k = 0;k<5;k++) {
				
				if(UserNumbers[k]>UserNumbers[k+1]) {
					
					int temp = UserNumbers[k];
					UserNumbers[k] = UserNumbers[k+1];
					UserNumbers[k+1] = temp;
					
				}
			}
		}
		
		return UserNumbers;
	}

	private static int[] createLuckNumbers() {//随即生成红蓝球
		// TODO Auto-generated method stub
		Random r = new Random();//随机数种子
		int []luckNumber = new int[7];
		
		int i = 0;//已摇号的个数
		
		while(true) {//摇红球
			int data = r.nextInt(33)+1;
			
			boolean fl = true;
			for(int j = 0; j <= i ; j++) {
				if(data==luckNumber[j]) {
					
					fl = false; 
							
					break;
				}
			}
			
			if(fl) {
				luckNumber[i] = data;
				i++;
				
			}
			if(i==6)
				break;
			
		}
		for(int j =0;j<6;j++) {//给前6个红球排个序
			
			for(int k = 0;k<5;k++) {
				
				if(luckNumber[k]>luckNumber[k+1]) {
					
					int temp = luckNumber[k];
					luckNumber[k] = luckNumber[k+1];
					luckNumber[k+1] = temp;
					
				}
			}
		}
		
		luckNumber[i] = r.nextInt(16)+1;//生成最后一个蓝球。
		
		return luckNumber;
	}

}
