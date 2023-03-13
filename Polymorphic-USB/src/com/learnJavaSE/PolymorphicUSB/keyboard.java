package com.learnJavaSE.PolymorphicUSB;

public class keyboard implements USB {
	
        private String name;
        
        
        public keyboard(String name) {
        	
        	this.name = name;
        	
        }
        
        @Override
        public void connect() {
        	
        	System.out.println("键盘已连接");
        	
        } 
        
        @Override 
        public void unconnect() {
        	
        	System.out.println("键盘一断开");
        	
        }
        
		/* 独立功能 
		 * */
        public void keyDown() {
        		
        	System.out.println("键盘正在敲击");
        	
        }
        
        
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
        
        
        
        

}
