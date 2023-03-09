package com.learnJavaSE.FindPrimenumber;

public class Main {
      //判断101-200之间有多少个素数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        isPrime();//调用找素数函数
	}
	public static void isPrime() {
		boolean prime = true;//判断是否为素数：信号位
		int count = 0;			 //素数计数
		int[] PrimeList = new int[1000];     //素数队列
		for(int i = 101;i <= 200; i++ ) {//外层循环控制判断个数
			prime = true;
			for(int j = 2; j < i / 2; j++) {//内层循环控制素数判断
				if(i%j == 0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				PrimeList[count] = i;
				count++;
			}
		}
		System.out.println("101-200之间有 "+ count +" 个素数分别是：");
		for(int i:PrimeList) {//foreach 遍历数组
			if(i!=0) 
			System.out.print(i+" ");
			
		}
	}

}
