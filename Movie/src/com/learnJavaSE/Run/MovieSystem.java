package com.learnJavaSE.Run;

import com.learnJavaSE.bean.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class MovieSystem {
		
	/**
	 *  创建list存储用户信息
	 *
	 */
	public static final List<User> ALL_USERS = new ArrayList<>();
	
	
	/**
	 * 
	 * 定义map键对，存储商家和电影信息
	 */
	

	public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();
	
	
	
	/**
	 * 系统输入模块
	 */
	public static final Scanner SYS_SC = new Scanner(System.in);
	
	public static User loginUser;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static final Logger LOGGER  = LoggerFactory.getLogger("MovieSystem.class");
	
	/**
	 * 
	 * 准备一些测试数据
	 * 
	 */
	
	
	static {
        Customer c = new Customer();
        c.setLoginName("ldh888");
        c.setPassword("123456");
        c.setUserName("刘德华");
        c.setSex('男');
        c.setPhone("1222222");
        c.setMoney(10000);
        ALL_USERS.add(c);
 
        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassword("123456");
        c1.setUserName("关之琳");
        c1.setSex('女');
        c1.setPhone("13333333");
        c1.setMoney(2000);
        ALL_USERS.add(c1);
 
 
        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassword("123456");
        b.setUserName("包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("144444444");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意 商家信息一定要加入到店铺排片信息中去
        List<Movie>  movies = new ArrayList<>();
        ALL_MOVIES.put(b,movies);
 
        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassword("123456");
        b2.setUserName("包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("15555555");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意 商家信息一定要加入到店铺排片信息中去
        List<Movie>  movies2 = new ArrayList<>();
        ALL_MOVIES.put(b2,movies2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showMain(); //展示主页
		
		

	}

	/**
	 *  展示主页内容
	 */
	private static void showMain() {
		
			
			System.out.println("=======================电影系统首页========================");
			while(true) {
			System.out.println("1.登陆");
			System.out.println("2.用户注册");
			System.out.println("3.商家注册");
			System.out.println("4.退出");
			System.out.println("请您输入相关命令：");
			
			String command = SYS_SC.nextLine();
			
			
			switch(command) {
			
				case "1":
					//登陆
					login();
					
					break;
					
				case "2":
					break;
					
				case "3":
					break;
					
				default:
					System.out.println("您输入的命令有误，请检查~~~~");
			
			}
			
		}
		
		
	}
    
	
	/**
	 * 登陆模块
	 */
	private static void login() {
		System.out.println("=================登录模块==================");
		while(true) {
			
			System.out.println("请输入登陆名称：");
			String LoginName = SYS_SC.nextLine();
			System.out.println("请输入登陆密码：");
			String password = SYS_SC.nextLine();
			
			
			//1.根据用户名返回用户对象
			User u = getUserByLoginName(LoginName);
			
			//2. 判断用户名是否存在
			if(u != null) {
				//用户存在
				if(u.getPassword().equals(password)) {
					
					loginUser = u;
					LOGGER.info(loginUser.getUserName()+"登陆成功~~~");
					//成功登陆，需判断是用户登陆还是商家登陆
					if(u instanceof Customer) {
						//客户登陆
						ShowCustomerMain();
						
					}else {
						//商家登陆
						ShowBusinessMain();
						
					}
					return;
					
				}else {
					
					System.out.println("您输入的密码有误");
				}
				
			}else {
				
				System.out.println("您输入的用户名有误，请检查");
				
			}
			
		}
		
		
	}

	/**
	 * 商家操作展示页面
	 */
	private static void ShowBusinessMain() {
		// TODO Auto-generated method stub
		
		
		while (true) {
            System.out.println("================电影商家界面=================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex()=='男'?"先生":"女士"+"欢迎您进入系统"));
            System.out.println("1、展示详情：");
            System.out.println("2、上架电影：");
            System.out.println("3、下架电影");
            System.out.println("4、修改电影");
            System.out.println("5、退出");
            System.out.println("请输入操作命令：");
            String command = SYS_SC.nextLine();
            switch (command) {
                case "1":
                    // 展示详情
                    showBusinessInfos();
                    break;
                case "2":
                    //上架电影
                    addMovie();
                    break;
                case "3":
                    //下架影片
                    deleteMovie();
                    break;
                case "4":
                    updateMovie();
                    break;
                case "5":
                    System.out.println(loginUser.getUserName()+"请您下次再来啊~~~");
                    return;
                default:
                    System.out.println("不存在该命令！");
                    break;
            }

        }

		
	}
     
	
	/**
	 * 电影信息修改
	 */
	private static void updateMovie() {
		
		System.out.println("=================影片修改=====================");
		Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        
        if(movies.size() == 0) {
        	
        	System.out.println("您无片可以修改");
        	return;
        }else {
        	while(true) {
        		
        		System.out.println("请您输入想要修改的电影名称");
            	String movieName = SYS_SC.nextLine();
            	
            	Movie movie = getMovieByMovieName(movieName);
            	
            	if(movie == null) {
            		
            		System.out.println("您输入的电影名称有误，请问您想继续输入吗？ y/n");
            		String command = SYS_SC.nextLine();
            		switch(command) {
            			case "y":
            				break;
            			default:
            				System.out.println("好的");
            				return;
            		
            		}
            		
            	}else {
            		System.err.println("您要修改的电影为：" + movie.getName());
            		System.out.println("请输入修改后片名：");
                    String name = SYS_SC.nextLine();
                    System.out.println("请输入修改后主演：");
                    String actor = SYS_SC.nextLine();
                    System.out.println("请输入修改后时长：");
                    String time = SYS_SC.nextLine();
                    System.out.println("请输入修改后票价：");
                    String price = SYS_SC.nextLine();
                    System.out.println("请输入修改后票数：");
                    String totalNumber = SYS_SC.nextLine();
                    
                    
                    
                    while(true) {
                    	
                    	  try {
                          	
                          	System.out.println("请输入影片放映时间：");
                             String stime = SYS_SC.nextLine();
                              
                  			movie.setName(name);
                  			movie.setActor(actor);
                  			movie.setTime(Double.valueOf(time));
                  			movie.setPrice(Double.valueOf(price));
                  			movie.setNumber(Integer.valueOf(totalNumber));
                  			movie.setStartTime(sdf.parse(stime));
                  			showBusinessInfos();
                            System.out.println("您已成功修改电影：  "+ movie.getName());
                  			return;
                  		
                  		} catch (Exception e) {
                  			// TODO Auto-generated catch block
                  			LOGGER.error("您的时间格式有问题，请输入格式为 yyyy/MM/dd HH:mm:ss");
                  		}
                    	
                    }
            		
            		
            		
            	}
        		
        	}
        	
        	
        }
        
		
	}
  
	/**
	 * 删除电影
	 */
	private static void deleteMovie() {
		System.out.println("=================影片删除=====================");
		Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        
        if(movies.size() == 0) {
        	
        	System.out.println("您无片可以删除");
        	return;
        }else {
        	while(true) {
        		
        		System.out.println("请您输入想要删除的电影名称");
            	String movieName = SYS_SC.nextLine();
            	
            	Movie movie = getMovieByMovieName(movieName);
            	
            	if(movie == null) {
            		
            		System.out.println("您输入的电影名称有误，请问您想继续输入吗？ y/n");
            		String command = SYS_SC.nextLine();
            		switch(command) {
            			case "y":
            				break;
            			default:
            				System.out.println("好的");
            				return;
            		
            		}
            		
            	}else {
            		
            		movies.remove(movie);
            		System.out.println("您已成功下架电影：  "+ movie.getName());
            		showBusinessInfos();
            		return;
            		
            	}
        		
        	}
        	
        	
        }
        
		
	}

	/**
	 * 根据电影名称返回电影类型
	 * @param movieName
	 * @return
	 */
	private static Movie getMovieByMovieName(String movieName) {

		Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
		
        for(Movie e:movies) {
        	
        	if(e.getName().contains(movieName)) {
        		
        		return e;
        		
        	}
        	
        }
		
		return null;
	}

	/**
	 * 
	 * 商家上架影片
	 */
	private static void addMovie() {
		System.out.println("=================影片上架=====================");
		Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);

        System.out.println("请输入新片名：");
        String name = SYS_SC.nextLine();
        System.out.println("请输入主演：");
        String actor = SYS_SC.nextLine();
        System.out.println("请输入时长：");
        String time = SYS_SC.nextLine();
        System.out.println("请输入票价：");
        String price = SYS_SC.nextLine();
        System.out.println("请输入票数：");
        String totalNumber = SYS_SC.nextLine();
        
        
        
        while(true) {
        	
        	  try {
              	
              	System.out.println("请输入影片放映时间：");
                  String stime = SYS_SC.nextLine();
                  
      			Movie movie = new Movie(name, actor, Double.valueOf(time), Double.valueOf(price)
      			        ,Integer.valueOf(totalNumber), sdf.parse(stime));
      			
      			movies.add(movie);
      			
      			System.out.println("您已成功上架 《" + movie.getName() + "》");
      			return;
      		
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			LOGGER.error("您的时间格式有问题",e);
      		}
        	
        }
      
		
	}

	/**
	 * 商家显示页面
	 */
	private static void showBusinessInfos() {
		// 当前用户（loginUser）登陆后展示信息
		System.out.println("==================商家信息展示页====================");
		LOGGER.info(loginUser.getUserName() + " 店家正在查看自己的信息~~~~~~~");
		Business business = (Business)loginUser;
		
		System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址：" + business.getAddress());
		List<Movie> Movies = ALL_MOVIES.get(business);
		System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
		if(Movies.size() > 0) {
			
			for(Movie m: Movies) {
				
				System.out.println(m.getName() + "\t\t\t" + m.getActor() + "\t\t" + m.getTime() + "\t\t" +m.getScore() + "\t\t" +m.getPrice() + "\t\t" +m.getNumber()+"\t\t" + sdf.format(m.getStartTime()));
				
			}
			
		}else {
			
			System.out.println("您无片可播~~~~~~~~");
			
		}
		
		
	}

	/**
	 * 用户操作展示页面
	 */
	private static void ShowCustomerMain() {
		// TODO Auto-generated method stub
		
		System.out.println("===============电影客户界面===============");
		
		System.out.println("欢迎您！"+ loginUser.getUserName() + (loginUser.getSex()=='男'?"先生":"女士"+"欢迎您进入系统"));
		while (true) {
        System.out.println("请您选择要操作的功能");
        System.out.println("1、展示全部影片信息");
        System.out.println("2、根据电影名查询电影信息");
        System.out.println("3、评分功能");
        System.out.println("4、购票功能");
        System.out.println("5、退出系统");
 
        
            System.out.print("请您选择要操作的命令：");
            String  command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部影片
             
                	showAllMovies();
                    break;
                case "2":
                    //根据电影名查询电影信息
             //       selectedMovieByName();
                    break;
                case "3":
           //         score();
                    break;
                case "4":
                    // 购票功能
                    buyMovie();
                    break;
                case "5":
                    System.out.println(loginUser.getUserName() + "已退出，欢迎下次再来~~~");
                    return;
                default:
                    System.out.println("不存在该命令~~~");
                    break;
            }
        }

		
	}

	
	/**
	 * 
	 * 
	 * 购票功能
	 */
	private static void buyMovie() {
		// TODO Auto-generated method stub
		showAllMovies();
		System.out.println("===============用户电影购票页面===============");
		
		while(true) {
			
			System.out.println("请输入购票商家名称");
			String shopName = SYS_SC.nextLine(); //输入店铺名称
			
			Business business = getBusinessByShopName(shopName);
			
			if(business != null) {
				//开始购票
				List<Movie> movies = ALL_MOVIES.get(business);
				
				if( movies .size() > 0 ) {
					//有电影
					System.out.println("请您输入您想看的电影名称");
					String MovieName = SYS_SC.nextLine();
					
					Movie movie = getMovieByShopAndName(business, MovieName);
					
					
				}else {
					
					System.out.println("影院关门了~~~~~");
					System.out.println("请问您是否继续 y/n");
					String command = SYS_SC.nextLine();
					switch(command) {
						case "y":
							break;
					    default:
					    	System.out.println("好的");
					    	return;
					}
					
				}
				
			}else {
				
				System.out.println("您输入的店铺名有误，请重新输入");
				
			}
			
		}
		
	}

	private static Movie getMovieByShopAndName(Business business, String movieName) {

		List<Movie> movies = ALL_MOVIES.get(business);
		for(Movie movie:movies) {
			
			if(movie.getName().contains(movieName)) {
				
				return movie;
				
			}
			
		}
		return null;
	}

	/**
	 * 
	 * 根据店铺名返回店铺对象
	 * @param shopName
	 * @return
	 */
	private static Business getBusinessByShopName(String shopName) {
		// TODO Auto-generated method stub
		Set<Business> businesses = ALL_MOVIES.keySet();
		for(Business business: businesses) {
			
			if(business.getShopName().contains(shopName)) {
				
				return business;
				
			}
		}
		return null;
	}

	/**
	 * 
	 * 展示全部商家和排片信息
	 */
	private static void showAllMovies() {
		System.out.println("===============电影展示页面===============");
		
		// TODO Auto-generated method stub
		ALL_MOVIES.forEach((business, movies) -> {
			
			System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址：" + business.getAddress());
			//List<Movie> Movies = ALL_MOVIES.get(business);
			System.out.println("\t\t\t"+"片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
			if(movies.size() > 0) {
				
				for(Movie m: movies) {
					
					System.out.println(m.getName() + "\t\t\t" + m.getActor() + "\t\t" + m.getTime() + "\t\t" +m.getScore() + "\t\t" +m.getPrice() + "\t\t" +m.getNumber()+"\t\t" + sdf.format(m.getStartTime()));
					
				}
				
			}else {
				
				System.out.println("您无片可播~~~~~~~~");
				
			}
			
		});
		
	}

	/**
	 * 根据登陆名找到用户
	 */
	private static User getUserByLoginName(String LoginName) {
		for(User user: ALL_USERS) {
			
			if(user.getLoginName().equals(LoginName)) {
				
				return user;
				
			}
			
		}
		return null; //查无此人
	}

}
