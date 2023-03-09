package com.learnJavaSE.copyArray;

public class Main {
	/* 把一个数组的元素复制到另外一个新数组中去 
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry1 = {23,15,55,123,2};
		int[] arry2 = arry1;//因为数组属于引用类型，这样只是arry2指向arry1
		
		
		int[] arry3 = new int[arry1.length];
		
		
		Copy(arry1,arry3);
		
		printArray(arry1);
		printArray(arry3);
		

	}
	//打印数组
	public static void printArray(int[] arry) {
		System.out.print("[");
		for(int i = 0;i<arry.length;i++) {
			System.out.print(i==arry.length-1 ? arry[i]:arry[i]+",");
		}
		System.out.println("]");
		
	}
	//完成数据复制
	public static void Copy(int[]arry1,int[]arry2) {
		for(int i = 0;i < arry1.length ;i++) {
			arry2[i] = arry1[i]; 
		}
				
	}

}
