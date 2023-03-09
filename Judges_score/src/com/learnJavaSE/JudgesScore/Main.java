package com.learnJavaSE.JudgesScore;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/* 需求： 
	 *   在唱歌比赛中，有六名评委给选手打分，分数范围是[0-100]之间的整数。
	 *   选手的最后得分为：
	 *      去掉最高分、最低分后的四个评委的平均分。
	 *   请完成上述过程并计算出选手的得分
	 *      
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []scores = new int[6];
		double average;
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------");
		for(int i = 0; i < scores.length; i++) {
			System.out.println("请输入第 "+ (i+1) +" 个评委的打分：");
			scores[i] = scanner.nextInt();
		}
		System.out.println("----------------------");
		
		
		average = getAverage(scores);
		System.out.println("----------------------");
		System.out.println("平均分为："+average);
		System.out.println("----------------------");

	}

	private static double getAverage(int[] scores) {
		// TODO Auto-generated method stub
		
		int max = scores[0];//设置最大值、最小值为数组第一个值，好做比较
		int min = scores[1];
		int sum = 0;
		
		for(int i = 0;i < scores.length; i++) {
			
			if(max < scores[i]) {
                     max = scores[i];
		    }
			
			if(min > scores[i]) {
				    min = scores[i];
			}
			
			sum += scores[i];
			
		}
		
		return (sum - min - max)/(scores.length - 2);
		
	}
}
