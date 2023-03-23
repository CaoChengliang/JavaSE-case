package com.learnJavaSE.Thread_synchronized_code;

public class Account {

	private String cardId;
	private double money;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String cardId, double money) {
		super();
		this.cardId = cardId;
		this.money = money;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void drawmoney(double money) {
		
		String name = Thread.currentThread().getName();
		synchronized(this) {
			
			if(this.money >= money) {
				
				System.out.println(name+ "来取钱");
				this.money -= money;
				System.out.println(name+ "来取钱" +"剩余" +this.money);
				
			}else {
				
				System.out.println(name+"来取钱"+"钱不够");
			}
			
			
		}
		
		
	}
	
	
}
