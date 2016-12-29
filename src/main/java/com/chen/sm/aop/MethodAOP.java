package com.chen.sm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.chen.sm.event.AfterInsertEvent;
import com.chen.sm.event.BeforeInsertEvent;
import com.chen.sm.po.Film;

@Aspect
@Component
public class MethodAOP {

	@Autowired
	ApplicationContext applicationContext;
	@Around("execution(* com.chen.sm.service.*.*(..))")
	public Object serviceExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
			Film film = new Film();
			BeforeInsertEvent before = new BeforeInsertEvent(film);
			applicationContext.publishEvent(before);
		
	        Object retVal = pjp.proceed();
	        AfterInsertEvent after = new AfterInsertEvent(film);
	        applicationContext.publishEvent(after);
	        return retVal;
	}
}
