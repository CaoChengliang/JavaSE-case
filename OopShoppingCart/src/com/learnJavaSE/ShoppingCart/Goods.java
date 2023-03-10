package com.learnJavaSE.ShoppingCart;

class Goods {
	
	private Integer Number; //商品编号
	private String name = null; //商品名称
	private Double price = null; // 商品价格
	private Integer count = null; // 商品数量
	
	public Goods() {
		super();
	}
	
	
	public Goods(Integer number, String name, Double price, Integer count) {
		this.Number = number;
		this.name = name;
		this.price = price;
		this.count = count;
	}


	public int getNumber() {
		return Number;
	}


	public void setNumber(int number) {
		Number = number;
	}


	public Goods(String name, Double price) {//构造函数
		super();
		this.name = name;
		this.price = price;
	}
    
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getName() {//获取商品姓名
		return name;
	}
	
	public Double getPrice() {//获取价格
		return price;
	}
	
	public Integer getCount() {//获取商品总数
		return count;
	}
	
	public void setCount(Integer count) {//设置商品总数
		this.count = count;
	}
	
	

}
