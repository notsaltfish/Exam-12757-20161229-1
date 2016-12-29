package com.chen.sm.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;


@Component
public class InsertListner implements ApplicationListener    {


	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		if(event instanceof BeforeInsertEvent){
		
			System.out.println("Before Insert Film Data ");
		}else if(event instanceof AfterInsertEvent){
			
			System.out.println("After Insert Film Data ");
		}else if (event instanceof ContextStartedEvent){
			System.out.println("Context Start  ");
			
		}else if (event instanceof ContextStoppedEvent){	
			System.out.println("Context Stop ");
		}
	}


	
}
