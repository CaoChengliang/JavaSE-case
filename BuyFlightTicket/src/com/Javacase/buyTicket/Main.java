package com.Javacase.buyTicket;

import java.util.Scanner;

public class Main {
	/*  买飞机票
	 * 需求：
	 *   机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱
	 *   机票最终优惠价格的计算方案如下：旺季（5-10）月头等舱9折，经济舱8.5折，淡季（11月到来年4月）
	 *   头等舱7折，经济舱6.5折。
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//简单方法
		//还有种别的方法是直接获取当前时间月份判断是否为淡季旺季然后直接打折
		Double OTicketPrice = null;//原价
		Integer month = null;//月份
		String level = null;//仓位等级
		Double CTicketPrice = null;//折后价
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------");
		System.out.println("请输入您的机票原价、月份（1-12）和头等舱或经济舱");
		System.out.println("------------------");
		OTicketPrice = Double.valueOf(scanner.nextDouble());
		month = Integer.valueOf(scanner.nextInt());
		level = scanner.next();
		System.out.println(OTicketPrice+"  "+month.toString()+level);
		CTicketPrice = DiscountTicketPrice(OTicketPrice,month,level); //调用方法
		System.out.println("------------------");
		System.out.println("您的折后价为： "+CTicketPrice);
		System.out.println("------------------");
		

	}
	public static Double DiscountTicketPrice(Double OTicketPrice, Integer month ,String level) {
		// 打折函数返回打折后价格
		Double CTicketPrice = null;
		if(month.intValue()>=5&&month.intValue()<=10) {//旺季
			switch(level) {
			    case "头等舱":
			    	CTicketPrice =  Double.valueOf(OTicketPrice*0.9);
			    	  break;
			    case "经济舱":
			    	CTicketPrice =  Double.valueOf(OTicketPrice*0.65);
			        break;
			    default:
			    	System.out.println("您输入的仓位类型有误~~~");
			    	CTicketPrice = -1.0;
			}
		}else {//淡季
			switch(level) {
		    case "头等舱":
		    	CTicketPrice =  Double.valueOf(OTicketPrice*0.7);
		    	  break;
		    case "经济舱":
		    	CTicketPrice =  Double.valueOf(OTicketPrice*0.6);
		        break;
		    default:
		    	System.out.println("您输入的仓位类型有误~~~");
		    	CTicketPrice = -1.0;
		}
		}
		
		return CTicketPrice;
	}

}
