package com.learnJavaSE.serializable;

import java.io.Serializable;

public class Student implements Serializable{

	private String name;
	private String loginname;
	
	//transient 表示不参与序列化
	private transient String password;
	private int age;
	
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", loginname=" + loginname + ", password=" + password + ", age=" + age + "]";
	}
	public Student(String name, String loginname, String password, int age) {
		super();
		this.name = name;
		this.loginname = loginname;
		this.password = password;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
