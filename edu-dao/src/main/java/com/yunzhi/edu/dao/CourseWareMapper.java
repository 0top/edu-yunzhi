package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseWare;

public interface CourseWareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseWare record);

    int insertSelective(CourseWare record);

    CourseWare selectByPrimaryKey(Long id);
    
    List<CourseWare> listCourseWareList(CourseWare courseware);

    int updateByPrimaryKeySelective(CourseWare record);

    int updateByPrimaryKey(CourseWare record);
}