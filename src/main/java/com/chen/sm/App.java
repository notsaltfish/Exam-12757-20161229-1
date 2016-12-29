package com.chen.sm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.sm.po.Film;
import com.chen.sm.service.FilmService;

/**
 * Hello world!
 *
 */
public class App 
{
	static boolean wantEnd =false;
	static FilmService filmService;
	static ClassPathXmlApplicationContext context = new 
			ClassPathXmlApplicationContext("applicationContext.xml");
	static   Scanner scanner  = new Scanner(System.in);
	static	Set<Byte> sets = new HashSet<Byte>();
	static Set<Integer> ints = new HashSet<Integer>();

	static {
		sets.add(new Byte((byte)1));
		sets.add(new Byte((byte)2));
		sets.add(new Byte((byte)3));
		sets.add(new Byte((byte)4));
		sets.add(new Byte((byte)5));
		sets.add(new Byte((byte)6));
		
		ints.add(1);
		ints.add(2);
	}
    public static void main( String[] args )
    {
    	App app = new App();
    	filmService =(FilmService) context.getBean("filmServiceImpl");
    	context.start();
    	app.input();
       context.stop();
       System.exit(0);
    }
    
    
    
    public   void input(){
        while(!wantEnd){
        	Film film = new Film();       
            String description  = "";
            Byte languageId =0;
            getTitle(film);           
            getDescription(film);
             getLanguageId(film);                   
            filmService.add(film);
            isEnd();
        	/*System.out.println("输入1继续插入数据，输入2结束程序");
        	int num = -1;
        	try{
        		num = scanner.nextInt();
        		if(!ints.contains(num)){
        			System.out.println("请输入1或者2");
        			isEnd();
        		}
        	}catch(Exception e){
    			System.out.println("请输入1或者2");
    			isEnd();
    		}*/
            
    	}
        
    	
    }
    
    public    void getTitle(Film film){
    	System.out.println("请输入电影名称【title】");
    	String title = "";
    	 scanner = new Scanner(System.in);
    	try{
    	    title = scanner.nextLine();
			if(title.trim().equals("")){			
				getTitle(film);
				return ;
			}
			film.setTitle(title);
			return;
		}catch(Exception e){
			getTitle(film);
		}
	}
    
    public    void getDescription(Film film){
    	   System.out.println("请输入电影描述【description】");
        String description  = "";
        scanner = new Scanner(System.in);
    	try{
    		description = scanner.nextLine();
			if(description.trim().equals("")){			
				getDescription(film);
				return ;
			}
			film.setDescription(description);
			return;
		}catch(Exception e){
			getDescription(film);
		}
	}
    
    public  void isEnd(){
    	System.out.println("输入1继续插入数据，输入2结束程序");
    	int num = -1;
    	 scanner = new Scanner(System.in);
    	try{
    		num = Integer.parseInt(scanner.nextLine());
    		if(!ints.contains(num)){
    			isEnd();
    			return ;
    		}
    	}catch(Exception e){
			isEnd();
		}
    	if(num==2){
    		wantEnd=true;
    	}
    	
    }
    public    void getLanguageId(Film film){
    	System.out.println("请输入位于(1,2,3,4,5,6)当中的数字");
    	Byte languageId=null;
    	 scanner = new Scanner(System.in);
    	try{
    	
		languageId = Byte.parseByte(scanner.nextLine());
			if(!sets.contains(languageId)){			
				getLanguageId(film);
				return ;
			}
			film.setLanguageId(languageId);
			return;
		}catch(Exception e){
			getLanguageId(film);
		}
	}
}
