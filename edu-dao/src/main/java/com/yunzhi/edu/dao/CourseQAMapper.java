package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseQA;

public interface CourseQAMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseQA record);

    int insertSelective(CourseQA record);

    CourseQA selectByPrimaryKey(Long id);
    
    List<CourseQA> listCourseQA(CourseQA qa);

    int updateByPrimaryKeySelective(CourseQA record);

    int updateByPrimaryKey(CourseQA record);
}