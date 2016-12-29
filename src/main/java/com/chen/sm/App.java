package com.chen.sm;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.sm.po.Film;
import com.chen.sm.service.FilmService;

/**
 * Hello world!
 *
 */
public class App 
{
	static FilmService filmService;
	static ClassPathXmlApplicationContext context = new 
			ClassPathXmlApplicationContext("applicationContext.xml");
    public static void main( String[] args )
    {
    	
    	filmService =(FilmService) context.getBean("filmServiceImpl");
    	context.start();
        input();
       context.stop();;
    }
    
    public static  void input(){
//    	while(true){
//    		
//    	}
    	Film film = new Film();
        Scanner scanner  = new Scanner(System.in);
        String title = "";
        String description  = "";
        Byte languageId =0;
        System.out.println("请输入电影名称【title】");
        title = scanner.nextLine();
        System.out.println("请输入电影名称【description】");
        description = scanner.nextLine();
        System.out.println("请输入语言ID【languageId】");
        languageId = scanner.nextByte();
        film.setLanguageId(languageId);
        film.setTitle(title);
        film.setDescription(description);
        filmService.add(film);
    	
    }
}
