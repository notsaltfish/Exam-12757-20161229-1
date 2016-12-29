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
		
		ints.add(1);
		ints.add(2);
	}
    public static void main( String[] args )
    {
    	
    	filmService =(FilmService) context.getBean("filmServiceImpl");
    	context.start();
    
        input();
       context.stop();
       System.exit(0);
    }
    
    public static  void input(){
        while(!wantEnd){
        	Film film = new Film();
        	String title = "";
            String description  = "";
            Byte languageId =0;
            System.out.println("请输入电影名称【title】");
            title = scanner.nextLine();
            System.out.println("请输入电影名称【description】");
            description = scanner.nextLine();
            System.out.println("请输入语言ID【languageId】");
             getLanguageId(film);
         
            film.setTitle(title);
            film.setDescription(description);
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
    
    public static void isEnd(){
    	System.out.println("输入1继续插入数据，输入2结束程序");
    	int num = -1;
    	try{
    		num = Integer.parseInt(scanner.nextLine());
    		if(!ints.contains(num)){
    			isEnd();
    		}
    	}catch(Exception e){
			isEnd();
		}
    	if(num==2){
    		wantEnd=true;
    	}
    	
    }
    public   static void getLanguageId(Film film){
    	System.out.println("请输入位于(1,2,3,4,5)当中的数字");
    	Byte languageId=null;
    	try{
    	
		languageId = Byte.parseByte(scanner.nextLine());
			if(!sets.contains(languageId)){			
				getLanguageId(film);
			}
			film.setLanguageId(languageId);
		}catch(Exception e){
			getLanguageId(film);
		}
	}
}
