package com.chen.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.sm.mapper.FilmMapper;
import com.chen.sm.po.Film;
import com.chen.sm.service.FilmService;


@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;


	public void add(Film film) {

		filmMapper.insertSelective(film);
	}


	
	
}
