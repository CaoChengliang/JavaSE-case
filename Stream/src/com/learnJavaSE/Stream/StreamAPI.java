package com.learnJavaSE.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = new ArrayList<>();
		
		Collections.addAll(names, "张三丰", "张萌","韩春明","成建军","倪大红","张朝阳");
		System.out.println(names);
		
		//filter forEach  Stream<T> filter(Predicate<? super T> predicate);
		//names.stream().filter(t -> t.startsWith("张")).forEach(t -> System.out.println(t));
		names.stream().filter(t -> t.startsWith("张")).forEach(System.out::println);
		
		names.stream().filter(t -> t.startsWith("张")).limit(2).forEach(System.out::println);
		
		names.stream().filter(t -> t.startsWith("张")).skip(1).forEach(System.out::println);
		
		//map加工方法
		//例子在集合元素前面加上一个"厉害的"
		names.stream().map(s -> "厉害的"+s ).forEach(System.out::println);
		
		//把上面的list名字封装成一个学生类
		
//		names.stream().map(new Function<String , Student>() {
//
//			@Override
//			public Student apply(String t) {
//				// TODO Auto-generated method stub
//				Student u = new Student(t);
//				return u;
//			}
//			
//			
//			
//		}).forEach(System.out::println);
		
		//names.stream().map(s -> new Student(s)).forEach(System.out::println);
		
		names.stream().map(Student::new).forEach(System.out::println);//构造器引用
		
		//合并流
		
		Stream<String> s1 = names.stream().filter(s -> s.startsWith("张"));
		
		Stream<String> s2 = Stream.of("Java1","Java2");
 		//合并后的泛型一定是合并前两个对象泛型的父类
		//public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
		Stream<Object> s3 = Stream.concat(s1, s2);
		
		s3.forEach(s -> System.out.println(s));
		
	}

}
