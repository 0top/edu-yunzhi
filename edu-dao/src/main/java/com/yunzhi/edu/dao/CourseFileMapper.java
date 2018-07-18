package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.CourseFile;

public interface CourseFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseFile record);

    int insertSelective(CourseFile record);

    CourseFile selectByPrimaryKey(Long id);
    
    List<CourseFile> listCourseFile(@Param("courseId")String courseId);

    int updateByPrimaryKeySelective(CourseFile record);

    int updateByPrimaryKey(CourseFile record);
}