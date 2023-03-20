package com.learnJavaSE.recurrence;

public class Main {

	public static void main(String[] args) {
	
		int sum = sum(2);
		System.out.println(sum);
		
		int peach = Monkey(1 );
		System.out.println(peach);
		
		
	}
	//猴子吃桃问题
	public static int Monkey(int n ) {
		
		if(n == 10) {
			
			return 1;
			
		}else {
			
			return 2 * Monkey( n+1  ) + 2;
			
		}
		
	}
	
	
	//递归计算n个数的和
	public static int sum(int n) {
		
		if(n == 1) {
			
			return 1;
			
		}else {
			
			return sum(n-1) + n;
		}
		
	}

}
