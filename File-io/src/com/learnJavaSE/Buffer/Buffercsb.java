package com.learnJavaSE.Buffer;

import java.io.*;
import java.util.*;

public class Buffercsb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				BufferedReader re = new BufferedReader(new FileReader("src/csb.txt"));
				
				BufferedWriter wr = new BufferedWriter(new FileWriter("src/csb1.txt"));
		){
				List<String> list = new ArrayList<>();
				String len;
				while( ( len = re.readLine() ) != null) {
					
					list.add(len);
					
				}
				//System.out.println(list);
				
				
				List<String> size = new ArrayList<>() ;
				
				Collections.addAll(size, "一","二","三","四","五","六","柒","八","九");
				//System.out.println(size);
				
				Collections.sort(list, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						//System.out.println(size.indexOf(o1.substring(0,o1.indexOf("."))) - size.indexOf(o2.substring(0,o2.indexOf("."))));
						//System.out.println(list);
						return size.indexOf(o1.substring(0,o1.indexOf("."))) - size.indexOf(o2.substring(0,o2.indexOf(".")));//这个地方行数假如文件是空行则失败
					}
						
				});
				//System.out.println("a");
				
				//System.out.println(list);
				
			    for(String data: list) {
			    	
			    	wr.write(data);
			    	wr.newLine();
			    	
			    }
				
		}catch(Exception e) {
			
			
			System.out.println(e);
			
		}
		
		

	}

}
