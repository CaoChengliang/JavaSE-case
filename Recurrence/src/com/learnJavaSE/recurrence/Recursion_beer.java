package com.learnJavaSE.recurrence;

import java.util.Arrays;

/**
 * 
 * 目标：啤酒2元一瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶，请10元可以喝多少啤酒，剩余多少空瓶和盖子
 * 
 * */

public class Recursion_beer {
	public static int money = 10;
	public static int beer = 0;
	public static int cap = 0;
	public static int bottle = 0;

	public static void main(String[] args) {
		
		drinkBeer(money,beer,bottle,cap);
		System.out.println(money +" "+ beer+" " + cap+ " " + bottle);

	}

	private static void drinkBeer(int m,int b, int n, int c) {
		// TODO Auto-generated method stub
		if(money<2 && bottle < 2 && cap < 4) {
			
		       return;
		}
		if(money >= 2) {
			
			beer++;
			bottle++;
			cap++;
			money -= 2;
			
			
		}else if(cap >= 4) {
			
			beer++;
			bottle++;
			cap -= 3;
			
		}else if(bottle >= 2) {
			
			beer++;
			bottle--;
			cap++;
			
		}
		
		drinkBeer( money, beer,  bottle,  cap);
		
	}

	

}
