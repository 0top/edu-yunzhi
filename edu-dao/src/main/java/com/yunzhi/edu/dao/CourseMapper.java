package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.Course;

public interface CourseMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);
    
//    int insertCourseListSelective(List<Course> records);

    Course selectByPrimaryKey(Long id);
    
    Course selectCourseBaseByCourseId(@Param("courseId")String courseId);
    
    List<Course> listCourseSelective(Course record);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    
    //extends
    ////////////////////////////
    int selectCourseCourseUser(@Param("courseId")String courseId);
    
}