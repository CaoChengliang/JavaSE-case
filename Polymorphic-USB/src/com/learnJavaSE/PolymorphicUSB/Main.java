package com.learnJavaSE.PolymorphicUSB;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Computer c = new Computer("外星人");
		
		c.start();
		
		USB mouse = new Mouse("逻辑");
		USB keyboard = new keyboard("樱花");
		
		c.installUSB(mouse);
		c.installUSB(keyboard);
		
		c.shutdown();

	}

}
