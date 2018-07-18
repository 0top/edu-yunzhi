package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.SchoolClassCourse;

public interface SchoolClassCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolClassCourse record);

    int insertSelective(SchoolClassCourse record);

    SchoolClassCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolClassCourse record);

    int updateByPrimaryKey(SchoolClassCourse record);
}