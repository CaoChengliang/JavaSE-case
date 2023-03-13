package com.learnJavaSE.PolymorphicUSB;

public class Computer {

	private String name;
	
	public Computer(String name) {
		
		this.name = name;
		
	}
	
	public void start() {
		
		System.out.println(this.name+"电脑开机");
		
	}
	
	public void installUSB(USB usb) {
		
		usb.connect();
		
		if(usb instanceof Mouse) {
			
			Mouse mouse = (Mouse)usb;
			
			mouse.click();
			 
		}
		
		if(usb instanceof keyboard) {
			
			keyboard k = (keyboard)usb;
			
			k.keyDown();
			
		}
		
		usb.unconnect();
		
	 }
	
	public void shutdown() {
		
		System.out.println("关机");
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	
	
}
