package com.chen.sm.mapper;

import com.chen.sm.po.Film;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
}