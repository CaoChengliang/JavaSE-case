package com.learnJavaSE.Stream;

public class Topperformer {
	
	
	private String name;
	
	private double money;
	
	
	

	@Override
	public String toString() {
		return "Topperformer [name=" + name + ", money=" + money + "]";
	}

	public Topperformer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topperformer(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	

}
