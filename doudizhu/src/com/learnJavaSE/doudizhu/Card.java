package com.learnJavaSE.doudizhu;

/**
 * @author alan
 *
 */
public class Card{
	
	private String size;//点数
	private String color;//花色
	private int index;   //牌的大小
	
	public Card() {
		
	}
	
	
	public Card(String size, String color,int index) {
		super();
		this.size = size;
		this.color = color;
		this.index = index;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	@Override
	public String toString() {
		
		return size+color;
				
	}
	
//	@Override
//	public int compareTo( Object o ) {
//		
//		Card c = (Card) o;
//		
//		if(this.index == c.index) {
//			return 0;
//		}
//		
//		return this.index > c.index ? 1:-1;
//		
//	}
	
	
	

}
