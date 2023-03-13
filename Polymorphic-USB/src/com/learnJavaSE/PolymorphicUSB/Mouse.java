package com.learnJavaSE.PolymorphicUSB;

public class Mouse implements USB {
    private String name;
    
    public Mouse(String name) {
    	
    	this.name = name;
    	
    }
	

	@Override
	public void connect() {
		
		System.out.println("鼠标已连接");

	}

	@Override
	public void unconnect() {
		
		System.out.println("鼠标拔出了");
    
	}
	
	/* 独立功能 
	 * */
	public void click() {
		System.out.println("鼠标点击");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
