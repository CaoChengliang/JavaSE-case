package com.learnJavaSE.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	
	
	private List<Goods> list = new ArrayList<>(); //货物列表
	
	public ShoppingCart() {
		  
		
	}
	
	public void addGoods() { //添加购物车
		
		Goods goods = new Goods();
	 
		Scanner sc = new Scanner(System.in);
		System.out.println("请您输入商品的编号（不重复）： ");
		goods.setNumber(sc.nextInt());
		
		System.out.println("请您输入商品的名称：");
		goods.setName(sc.next());
		
		System.out.println("请您输入购买商品的价格：");
		goods.setPrice(sc.nextDouble());
		
		System.out.println("请您输入购买商品的数量：");
		goods.setCount(sc.nextInt());
		
		System.out.println("添加成功！ ");
		
		this.list.add(goods);
		
		
	}
	
    public void DeleteGoods() {  //删除购物车
    	System.out.println("您的购物车列表为：");
    	this.printGoods();
    	System.out.println("请输入您想要删除的商品编号：");
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	this.list.remove(n-1);
    	System.out.println("删除成功");
    	this.printGoods();
		
	}
    
    public void updateGoods() {///更新购物车
    	System.out.println("您的购物车列表为：");
    	this.printGoods();
    	System.out.println("请输入您想要修改的的商品编号：");
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	if(this.list.get(n-1)!=null) {
    		System.out.println("请您输入修改后购买后数量：");
    		int number = sc.nextInt();
    		this.list.get(n-1).setCount(number);
    		System.out.println("修改成功");
    	}else {
    		System.out.println("无此商品");
    	}
    	
		
	}
    public void payGoods() {//支付购物车
    	this.printGoods();
    	double money = 0;
    	System.out.println("您的商品购物车总价格为：");
    	for(Goods goods:this.list) {
    		money = money + goods.getCount()*goods.getPrice();
    	}
    	System.out.println(money);
    	this.list.clear();
    	System.out.println("您已支付所有的货物，购物车已清空。");
    	this.printGoods();
    }
    
    public void printGoods() {//打印购物车内容，其实有想法是复写toString方法直接把列表打出来。 
    	System.out.println("商品id    "+"商品名称    "+"商品价格    "+"商品的购买数量");
    	for(Goods goods:this.list) {
    		System.out.println("   "+goods.getNumber()+"      "+goods.getName()+"      "+goods.getPrice()+"      "+goods.getCount());
    	}
    	
    }
 
}
