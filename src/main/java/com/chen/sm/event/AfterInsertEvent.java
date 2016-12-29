package com.chen.sm.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.chen.sm.po.Film;

public class AfterInsertEvent extends ApplicationEvent{
	
	
	public AfterInsertEvent(Film source) {
		super(source);
		
	}

	
}
