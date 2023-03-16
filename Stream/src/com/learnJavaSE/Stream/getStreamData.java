package com.learnJavaSE.Stream;

import java.util.*;
import java.util.stream.Stream;
/*Stream的核心思想
 * 
 * 先得到集合或者数组的Stream流（传送带）
 * 用这个Stream流处理集合或者数组的数据
 * 简化数组或者集合的api操作
 * 
 * 集合获取stream的方法
 *     default Stream<E> stream();
 * */
public class getStreamData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*--------------------- Collections集合获取Stream 流--------- */
		
		Collection<String> list = new ArrayList<>();
		
		Stream<String> s = list.stream();
		
		/* Map集合获取Stream流 */
		
		Map<String , Integer> map = new HashMap<>();
		
		Stream<String> keyStream = map.keySet().stream();
		Stream<Integer> valueStream = map.values().stream();
		
		/* 数组获取Stream流 */
		
		String[] names = {"曹成梁","张明珠"};
		
		Stream<String> nameStream = Arrays.stream(names);
		

	}

}
