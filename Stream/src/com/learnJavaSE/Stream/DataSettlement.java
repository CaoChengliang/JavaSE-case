package com.learnJavaSE.Stream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*某个公司的开发部门，分为开发一部和二部，现需要进行年中数据结算
 * 
 * 
 *		员工信息包含了（名称、性别、工资、奖金、处罚记录）
 *		开发一部有四个员工、开发二部有5名员工
 * 		分别筛选出2各部门最高工资的员工信息，封装成优秀员工对象Topperformer
 * 		分别统计出2各部门的平均月收入，要求去掉最高和最低工资
 *      两个部门整体的平均工资
 * */

public class DataSettlement {
 
	public static double allmoney1 = 0;
	public static double allmoney2 = 0;
	
	public static double allmoney = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Employee> one = new ArrayList<>();
		
		one.add(new Employee("猪八戒",'男',20000.0,25000,null));
		one.add(new Employee("曹成梁",'男',2000000.0,250000,null));
		one.add(new Employee("张明珠",'女',30000.0,35000,"不听领导（我）的话"));
		one.add(new Employee("云宵云",'男',1000.0,200,null));
		
		
		List<Employee> two = new ArrayList<>();
		
		two.add(new Employee("形式上",'男',4000.0,5000,"辣椒水"));
		two.add(new Employee("都得到",'女',5000.0,2500,"鞭打"));
		two.add(new Employee("学学习",'女',33300.0,35000,"抽打"));
		two.add(new Employee("啦啦啦",'男',2000.0,200,null));
		
		
		//1. 开发一部最高工资
		Employee e = one.stream().max( ( s1,  s2) -> Double.compare(s1.getSalary()+s1.getBonus(), s2.getSalary()+s2.getBonus())).get();
	    System.out.println(e);
	    
	    //一部优秀员工
	    Topperformer t = one.stream().max((s1 , s2) -> Double.compare(s1.getSalary()+s1.getBonus() , s2.getSalary()+s2.getBonus())).map(s -> new Topperformer(s.getName(), s.getBonus()+s.getSalary())).get();
	     
	    System.out.println(t);
	    //选出2各部门平均月收入
	    
	    one.stream().sorted((s1 , s2) -> Double.compare(s1.getSalary()+s1.getBonus() , s2.getSalary()+s2.getBonus())).skip(1).limit(one.size() - 2).forEach(s -> allmoney1 = allmoney1 + s.getBonus() + s.getSalary());
	    System.out.println("one部门的平均月收入为" + allmoney1 / (one.size() - 2));
	    
	    two.stream().sorted((s1 , s2) -> Double.compare(s1.getSalary()+s1.getBonus() , s2.getSalary()+s2.getBonus())).skip(1).limit(one.size() - 2).forEach(s -> allmoney2 = allmoney2 + s.getBonus() + s.getSalary());
	    System.out.println("two部门的平均月收入为" + allmoney2 / (two.size() - 2));
	    
	    //开发部的平均工资
	    Stream<Employee> s1 = one.stream();
	    Stream<Employee> s2 = one.stream();
	    
	    Stream<Employee> s3 = Stream.concat(s1, s2);
	    
	    s3.sorted((e1 , e2) -> Double.compare(e1.getSalary()+e1.getBonus() , e2.getSalary()+e2.getBonus())).forEach(s -> allmoney += (s.getBonus() + s.getSalary()) );
	    
	    BigDecimal a = BigDecimal.valueOf(allmoney);
	    BigDecimal b = BigDecimal.valueOf(one.size() + two.size() -2);
	    
	    System.out.println("两部的平均工资为"+ a.divide(b ,2 , RoundingMode.UP));
	}

}
