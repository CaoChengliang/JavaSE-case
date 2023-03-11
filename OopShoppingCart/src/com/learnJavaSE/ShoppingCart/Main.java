package com.learnJavaSE.ShoppingCart;

import java.util.*;

public class Main {
	/* 需求 
	 *   模拟购物车模块的功能，需要实现添加商品到购物车中去，同时需要提供修改商品的购买数量，
	 *   结算商品价格的功能。（请使用面向对象编程来解决）
	 * 模块模拟：   
	 *   添加商品 add：                                              添加商品 add：
	 *   查看商品 query：                                            查看商品 query：
	 *   修改数量 update：                                           修改数量 update：
	 *   结算价格 pay：                                              结算价格 pay：
	 *   请选择您要操作的功能：                                         请选择您要操作的功能：
	 *   add                                                    query
	 *   请输入商品编号（不重复）：                                       ----------------------------------------------
	 *   1                                                      商品id        商品名称   商品价格         商品购买数量
	 *   请输入商品的名称：                                            1           卡西欧手表    399.9          1
	 *   大米                                                     添加商品 add：
	 *   请您输入商品价格：                                            查看商品 query：
	 *   399.9                                                  修改数量 update：
	 *   请您输入您购买商品数量：                                        结算价格 pay：
	 *   1                                                      请选择您要操作的功能：
	 *   添加成功！
	 *   添加商品 add：
	 *   查看商品 query：
	 *   修改数量 update：
	 *   结算价格 pay：
	 *   请选择您要操作的功能：
	 * 分析：
	 *   需要有商品类、购物车类（包括商品数组）、用户显示界面,完成用户操作。支付后完成购物车浏览。
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Goods> list = new ArrayList<>();
		ShoppingCart scart = new ShoppingCart(); //设置购物车对象
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("添加商品 add：");
			System.out.println("查看商品 query：");
			System.out.println("修改数量 update：");
			System.out.println("结算价格 pay：");
			System.out.println("请选择您的操作");
			String command = sc.next();
			
			switch(command) {
			
			      case "add":
			    	  scart.addGoods();
			    	  break;
			      case "query":
			    	  scart.printGoods();
			    	  break;
			      case "update":
			    	  scart.updateGoods();
			    	  break;
			      case "pay":
			    	  scart.payGoods();
			    	  break;
			
			}
			if(command.equals("pay")) {//支付后退出
				break;
			}
			
		}

	}

}
