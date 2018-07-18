package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseTask;

public interface CourseTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseTask record);

    int insertSelective(CourseTask record);

    CourseTask selectByPrimaryKey(Long id);
    
    List<CourseTask> listCourseTask(CourseTask record);

    int updateByPrimaryKeySelective(CourseTask record);

    int updateByPrimaryKey(CourseTask record);
}