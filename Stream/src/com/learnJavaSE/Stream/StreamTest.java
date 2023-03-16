package com.learnJavaSE.Stream;

import java.util.*;

/*学习Stream流
 *认为廖雪峰老师比较详细一些
 *
 * */
public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<>();
		
		Collections.addAll(names, "张萌","韩春明","成建军","倪大红","张朝阳");
		
		System.out.println(names);
		
//		//如果想找三个字的名字（如果用模糊查询正则表达式就可以吧，这里只是练习Stream）
//		List<String> threeNamelist = new ArrayList<>();
//		
//		for(String s:names) {
//			
//			if(s.length() == 3) {
//				
//				threeNamelist.add(s);
//				
//			}
//			
//		}
//		
//		System.out.println(threeNamelist);
//		
//		//找姓张的
//		List<String> zhanglist = new ArrayList<>();
//		
//		for(String s:names) {
//			
//			if(s.startsWith("张")) {
//				
//				zhanglist.add(s);
//				
//			}
//			
//		}
//		
//		System.out.println(zhanglist);
//		
       //用Stream流一句搞定
		
		names.stream().filter(n -> n.startsWith("张") && n.length() == 3).forEach(n -> System.out.println(n));
	}

}
