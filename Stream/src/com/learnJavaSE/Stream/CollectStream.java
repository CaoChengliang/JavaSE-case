package com.learnJavaSE.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

///收集Stream流
public class CollectStream {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		
		Collections.addAll(names, "张三丰", "张萌","韩春明","成建军","倪大红","张朝阳");
		System.out.println(names);
		
		Stream<String> s1 = names.stream().filter(s -> s.startsWith("张"));
		
		List<String> l = s1.collect(Collectors.toList());
		
		l.add("Java");
		
		System.out.println(l);
		
		//流只能用一次
		Stream<String> s2 = names.stream().filter(s -> s.startsWith("张"));
		Set<String> set = s2.collect(Collectors.toSet());
		System.out.println(set);
	
		
		
	}

}
