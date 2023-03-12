package com.learnJavaSE.ATM;

import java.util.*;

/**
 * @author alan
 *
 */
/**
 * @author alan
 *
 */
/**
 * @author alan
 *
 */
public class ATMSystem {

	public static void main(String[] args) {
		/* ATM入口类
		 * 
		 *  */
		
		List<Account> list  = new ArrayList<>();//ATM维护一个账户列表
		Scanner sc = new Scanner(System.in);
		int command; //命令
		
		//输入不正确重新输入
		while(true) {
			
			//入口界面、
			System.out.println("==========================ATM=======================");	
			System.out.println("1.用户登陆");
			System.out.println("2.用户注册");
			System.out.println("0.退出系统");
			System.out.println("请输入您的命令1 、 2继续您的操作：");
			System.out.println("====================================================");
			
			command = sc.nextInt();
			
			switch(command) {
			
			   case 1:
				   //登陆
				   login(list,sc);
				   break;
			   case 2:
				   //注册
				   register(list, sc);
				   break;
			   case 0:
				   System.exit(0);
			  default:
				  System.out.println("您输入的命令不正确请重新输入");
				
			}
			
		}
		
		
		
		

	}

	private static void login(List<Account> list, Scanner sc) {
		System.out.println("====================系统登陆===========================");
		
		if(list.isEmpty()) {
			System.out.println("对不起，当前系统中无账户，请先开户，再来登陆");
			return; //卫语言跳出方法
		}
		
		
			
		
		while(true) {
			System.out.println("请您输入您的卡号：");
			
			String ID = sc.next();
			Account acc = getAccountByID(list,ID);
			
			if(acc!=null) {
				
				//System.out.println("请输入您的密码：");
				while(true) {
					System.out.println("请输入您的密码：");
					String password = sc.next();
					
					if(acc.getPassWord().equals(password)) {//判断密码是否一致
						   
						System.out.println("恭喜你！ "+ acc.getName()+"    账户ID: "+acc.getAccountID()+"   登陆成功");
						
						//显示用户登陆页面
						showUsercommand(sc,acc,list);//我本来是想直接写不用方法，但是感觉还是用方法比较好
						return;//干掉当前方法
						
						
						//....查询、转账、取款、存款
						
						
					}else {
						
						System.out.println("您输入的密码不正确，请输入y/n，选择重新输入或者退出");
									
						String se = sc.next();
						
						if(se.equals("n")) {//如果不想输了跳出
							
							return;
							
						}
						
					}
				}
				
			}else {
				
				System.out.println("卡号错误或不存在请您输入 y/n ,选择重新输入卡号或者退出输入");
				
				
				String se = sc.next();
				
				if(se.equals("n")) {//如果不想输了跳出
					
					return;
					
				}
				
			}
			
		}
		
		
		
		
		
	}

	/**
	 * 
	 * 用户操作展示页
	 * @param sc
	 * @param acc
	 * @param list 
	 */
	private static void showUsercommand(Scanner sc, Account acc, List<Account> list) {
		// TODO Auto-generated method stub
		
		
		while(true) {
			System.out.println("====================ATM操作界面==========================");
			System.out.println("1.查询");
			System.out.println("2.存款");
			System.out.println("3.取款");
			System.out.println("4.转账");
			System.out.println("5.修改密码");
			System.out.println("6.退出");
			System.out.println("7.注销当前账户");
			System.out.println("您可以继续选择功能进行操作！");
			
			int command = sc.nextInt();
			
			switch(command) {

				  
			  case 1:
				  
				  showAccount(acc);
				  
				  break;
				  
			  case 2:
				  
				  saveMoney(acc,sc);
				  
				  break;
				  
			  case 3:
				  
				  drawmoney(acc,sc);
				  
				  break;
				  
			  case 4:
				  
				  transfer(sc,acc,list);
				  
				  break;
				  
			  case 5:
				  
				  changePassword(acc,sc);
				  
				  return;//修改完密码需要重新登陆
				  
			  case 6:
				  
				  System.out.println("退出成功，欢迎下次再来");
				  return;
				  								    
			  case 7:
				  deleteAccount(acc,sc,list);
				  
				  
				  return;
				  
			  default:
				  System.out.println("您的输入不正确，请在此输入~~~~~");
			
			}
			
		}
		
	}
     
	/**
	 * 
	 * 删除账户
	 * @param acc
	 * @param sc
	 * @param list 
	 */
	private static void deleteAccount(Account acc, Scanner sc, List<Account> list) {
		// TODO Auto-generated method stub
		System.out.println("====================账户删除======================");
		System.out.println("您真的要销户吗 y/n");
		  
		  String s = sc.next();
		  
		  switch(s) {
		  
		  	case "y":
		  		
		  		System.out.println("请您输入密码：");
		  		String password = sc.next();
		  		if(password.equals(acc.getPassWord())) {
		  			
		  			list.remove(acc);
		  			System.out.println("账户已删除！！！");
		  			
		  		}else {
		  			
		  			System.out.println("您输入的密码不正确");
		  			return;
		  			
		  		}
		  		
		  		break;
		  		
		  	default:
		  		System.out.println("听我说，谢谢你，因为有你");
		  }
		
	}

	/**
	 * 
	 * 更改账户密码
	 * @param acc
	 * @param sc
	 */
	private static void changePassword(Account acc, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====================改密码页面==========================");
		
		while(true) {
			
			System.out.println("请输入当前账户密码：");
			String passWord = sc.next();
			
			if(passWord.equals(acc.getPassWord())) {
				
				System.out.println("请输入新密码：");
				String newPassword = sc.next();
				
				System.out.println("请您确认一下新密码：");
				String newPassword1 = sc.next();
				if(newPassword1.equals(newPassword)) {
					
					acc.setPassWord(newPassword1);
					System.out.println("恭喜，密码修改成功！");
					return;
					
				}else {
					
					System.out.println("两次密码不一致");
					
				}
				
				
				
				
				
			}else {
				
				System.out.println("您输入的密码不正确！请重新输入");
				
			}
			
		}
		
		
		
		
	}

	/**
	 * 
	 * 转账
	 * @param sc
	 * @param acc
	 * @param list
	 */
	private static void transfer(Scanner sc, Account acc, List<Account> list) {
		
		System.out.println("====================转账页面==========================");
		
		if(list.size() <= 1) {
			
			System.out.println("当前系统少于2人无法转账");
			
			return;
			
		}
		
		if(acc.getBalance() == 0) {
			
			System.out.println("没钱就别转了");
			
		}
		
		while(true) {
			
			System.out.println("请输入您要转账的对方用户ID");
			
			String ID = sc.next();
			Account acc1 = getAccountByID(list,ID);
			
			if(ID.equals(acc.getAccountID())) {
				
				System.out.println("不能给自己转账！");
				continue;
				
			}
			
			if(acc1 != null) {
				
				String UserName = acc1.getName();
				
				System.out.println("请确认您是否为"+"*"+UserName.substring(1)+"转账！");
				
				while(true) {
					
					System.out.println("请输入他的姓氏");
					
					String preName = sc.next();
					
					if(UserName.startsWith(preName)) {
						
						//正式转账开始
						
						while(true) {
							
							System.out.println("请输入转账金额：");
							double money = sc.nextDouble();
							
							if(money <= acc.getBalance()) {
								
								acc.setBalance(acc.getBalance()-money);
								acc1.setBalance(acc1.getBalance()+money);
								
								System.out.println("转账成功您的账户还有"+acc.getBalance());
								
								return;
								
							}else {
								
								System.out.println("您钱不够！最多可以转"+acc.getBalance());
								
							}
							
						}
						
						
						
					}else {
						
						System.out.println("您输入的姓氏不正确！请再次输入");
						
					}
					
				}
				
				
			}else {
				
				System.out.println("不存在该用户请确认！");
				
			}
			
		}
		
		
          
		
	
		
	}

	/**
	 * 取钱
	 * @param acc
	 * @param sc
	 */
	private static void drawmoney(Account acc, Scanner sc) {
		
		System.out.println("====================取款页面==========================");
		
		while(true) {
			
			System.out.println("请输入您要提取的金额：");
			
			double money = sc.nextDouble();
			if(money < 100) {
				
				System.out.println("金额太少，无法提现！");
				return;
				
			}
			
			if(money <= acc.getQuotaMoney()) {
				
				if(money <= acc.getBalance()) {
					
					acc.setBalance(acc.getBalance()-money);
					
					System.out.println("恭喜您！提现成功！当前账户信息为  ");
					
					showAccount(acc);
					
					return;
					
				}else {
					
					System.out.println("账户里没这么多钱啊，操！！"+"账户里有金额： "+acc.getBalance());
					
				}
				
			}else {
				
				System.out.println("对不起您要提取的金额已超过当次提现额度！你每次可取金额为"+acc.getQuotaMoney());
				
			}
			
		}
			
	}

	/**
	 * 
	 * 存款页面
	 * @param acc 当前账户
	 * @param sc  输入流
	 * 
	 */
	private static void saveMoney(Account acc, Scanner sc) {
		
		System.out.println("====================存款页面==========================");
		System.out.println("请输入您要存款的金额：");

		double money = sc.nextDouble();
		
	
		
		
		acc.setBalance(acc.getBalance()+money);
		
		System.out.println("恭喜您存款成功！ 您的当前信息如下");
		
		showAccount(acc);
			
		
	}

	/**
	 * 用户信息展示
	 * @param acc
	 */
	private static void showAccount(Account acc) {
		
		System.out.println("====================用户详情页==========================");
		  System.out.println("您的账户信息如下：");
		  System.out.println("卡号："+acc.getAccountID());
		  System.out.println("姓名："+acc.getName());
		  System.out.println("余额："+acc.getBalance());
		  System.out.println("当次提现额度："+acc.getQuotaMoney());
		  
		
	}

	/**
	 * 用户开户功能
	 * @param list //账户集合
	 */
	private static void register(List<Account> list,Scanner sc) {
		//注册方法
		System.out.println("========================Welcome!(开户)=======================");
		
		Account acc  = new Account();
		
		//输入姓名
		System.out.println("请输入您的账户姓名");
		String name = sc.next();
		acc.setName(name);
		
		//输入密码
		System.out.println("请输入您的密码：");
		String Password = sc.next();
		
		while(true){
			System.out.println("请再次输入您的密码：");
			String okPassword = sc.next();
			
			if(okPassword.equals(Password)) {
				
				acc.setPassWord(okPassword);
				break;
				
			}else {
				System.out.println("您输入的密码不正确");
			}
		}
		
		
		//输入存取限额
		System.out.println("请输入您的存取限额");
		double quotamoney = sc.nextDouble();
		acc.setQuotaMoney(quotamoney);
		
		
		//设置一个不重复的5位数随机ID
		String ID = getRandomID(list);
		acc.setAccountID(ID);
		
		//加入集合
		list.add(acc);
		
		System.out.println(name+" 恭喜您开户成功！"+"您的卡号是: "+ID+" 保管好！");
		
		
	}
    
	//返回一个随机的5位不重复数字ID
	private static String getRandomID(List<Account> list) {
        Random r = new Random();
        
        
           while(true) {
        	   String ID = "";
           	for(int i = 0; i < 5; i++ ) {
               	
               	ID += r.nextInt(9);
               	
               }
               Account acc = getAccountByID(list,ID);
               if(acc==null) {
               	//如果没查到重复说明ID可以使用！！
               	return ID;
               	
               }
           }
        
     }
	
	//根据ID找出有没有此账户
	private static Account getAccountByID(List<Account> list, String ID) {
		
		
		
		for(int i = 0; i < list.size(); i++) {
			
			Account acc = list.get(i);
			
			if(acc.getAccountID().equals(ID)) {
					 return acc;
				
				
		}
				
	   }
		
	    return null;
	}

	
}
