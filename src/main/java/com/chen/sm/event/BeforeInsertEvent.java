package com.chen.sm.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.chen.sm.po.Film;

public class BeforeInsertEvent extends ApplicationEvent{
	
	
	public BeforeInsertEvent(Film source) {
		super(source);
		
	}

	
}
