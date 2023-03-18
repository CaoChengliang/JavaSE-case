package com.learnJavaSE.bean;

import java.util.Date;

//定义一个Movie类， 其中包含：片名、主演、评分、时长、票价、余票 开始放映时间；

public class Movie {
	
	private String name;
	private String actor;
	private double score;
	private double time;
	private double price;
	private int    number; 
	private Date   startTime;	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String name, String actor, double time, double price, int number, Date startTime) {
		super();
		this.name = name;
		this.actor = actor;
//		this.score = score;  评分由客户来打
		this.time = time;
		this.price = price;
		this.number = number;
		this.startTime = startTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
	
	

}
