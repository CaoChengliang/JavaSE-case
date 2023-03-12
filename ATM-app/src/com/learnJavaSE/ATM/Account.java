package com.learnJavaSE.ATM;

public class Account {
	/* 账户类 
	 * */
    private String AccountID;  //身份ID
    private String Name;       //姓名
    private String passWord;
    
	private Double balance = 0.0;    //账户余额
    private Double quotaMoney = 0.0; //限定提现金额
    
    
    
    public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccountID() {
		return AccountID;
	}
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getQuotaMoney() {
		return quotaMoney;
	}
	public void setQuotaMoney(Double quotaMoney) {
		this.quotaMoney = quotaMoney;
	}
    
    
    
}
