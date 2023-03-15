package com.learnJavaSE.doudizhu;

import java.util.*;

/**
 * @author alan
 * 
 * 功能：
 *   1.做牌
 *   2.洗牌
 *   3.定义三个玩家
 *   3.发牌
 *   5.排序
 *   6.看牌
 *
 */
public class GamePanel {
	/*
	 * 1.做牌定义一个静态集合存出54张牌
	 * 2.定义静态代码块初始化牌数据
	 * 
	 * */
   public static List<Card> allCards = new ArrayList<>();
   
   static {
	   
	   String[] size = new String[] {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	   String[] color = new String[] {"♠","♣","♥","✦"};
	   int count = 1;   //排数大小
	   for(String s:size) {//加牌
		   for(String c:color) {
			   
			   Card card = new Card();
			   
			   card.setIndex(count);
			   card.setSize(s);
			   card.setColor(c);
			   
			   allCards.add(card);
			   
			   
		   }
		   count++;
	   }
	   
	   Card c1 = new Card("" , "♔",100);
	   Card c2 = new Card("" , "♕",99);
	   
	   Collections.addAll(allCards , c1, c2);
	   
	   System.out.println("新牌"+allCards);
   }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * 洗牌
		 */
		Collections.shuffle(allCards);
		System.out.println("洗牌后："+allCards);
		
		
		/* 发牌 
		 * */
		//创建三个人对象
		List<Card> xiaocao = new ArrayList<>();
		List<Card> xiaoli = new ArrayList<>();
		List<Card> xiaolu = new ArrayList<>();
		
		for(int i = 0 ; i < allCards.size()-3 ; i++ ) {
			
			if(i % 3 == 0) {
				
				xiaocao.add(allCards.get(i));
				
			}else if(i % 3 == 1) {
				
				xiaoli.add(allCards.get(i));
				
			}else if(i % 3 == 2){
				
				xiaolu.add(allCards.get(i));
			}
			
		}
		
		//每个人的从小到大排序
		
		Collections.sort(xiaocao, (Card c1, Card c2) -> 
		
		    { 
				
				if(c1.getIndex() == c2.getIndex()) {
					
					return 0;
					
				}
				
				return c1.getIndex() > c2.getIndex() ? 1:-1 ;
				
			}
			
			
		);
		//Collections.sort(xiaoli);
		//Collections.sort(xiaolu);
		//最后三张牌
		List<Card> lastthreeCard = allCards.subList(allCards.size()-3 , allCards.size() );
		
		System.out.println("xiaocao"+xiaocao);
		System.out.println("xiaoli"+xiaoli);
		System.out.println("xiaolu"+xiaolu);
		System.out.println("lastthreeCards"+lastthreeCard);
		
		for (Card card : lastthreeCard) {
			xiaocao.add(card);
		}
		//.sort(xiaocao);
		System.out.println("xiaocao"+xiaocao);
		System.out.println("xiaoli"+xiaoli);
		System.out.println("xiaolu"+xiaolu);
		
		
	
	}

}
