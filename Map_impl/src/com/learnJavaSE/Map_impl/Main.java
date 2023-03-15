package com.learnJavaSE.Map_impl;

import java.util.*;

// 郊游统计每个人的选的景点人数
// 目的：练习Map嵌套
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.存储每个人选的经典和姓名
		
		Map<String, List<String>> data = new HashMap<>();
		
		//存入数据
		data.put("xiaocao", List.of("A","B","C"));
		
		data.put("xiaolu", List.of("B","C"));
		
		data.put("xiaowang", List.of("A","B","C"));
		
		System.out.println(data);
		
		Map<String,Integer> select = new HashMap<>();
		
		//info = {  [A, B, C] ,  [B, C] ,  [A, B, C] }
		
		Collection<List<String>> info = data.values();
		
		for(List<String> list:info) {
			
			for(String s:list) {
				
				if(select.containsKey(s)) {
					
					select.put(s, select.get(s)+1);
					
				}else {
					
					select.put(s, 1);	
				}
				
			}
			
		}
		
		
		System.out.println(select);
		

	}

}
