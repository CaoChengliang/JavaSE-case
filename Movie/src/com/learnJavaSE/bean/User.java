package com.learnJavaSE.bean;

/*
 * 
 * 用户类 ：登录名 ， 真名 ，密码 ， 性别， 电话， 账户金额
 * 
 * 
 * */

public class User {
	
	private String loginName; //假名
	private String userName;  //真名
	private String Password;  //密码
	private char sex;
	private String phone;
	private double money;
	
	
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String loginName, String userName, String password, char sex, String phone, double money) {
		super();
		this.loginName = loginName;
		this.userName = userName;
		Password = password;
		this.sex = sex;
		this.phone = phone;
		this.money = money;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
	
	
	
	
	
	
	

}
