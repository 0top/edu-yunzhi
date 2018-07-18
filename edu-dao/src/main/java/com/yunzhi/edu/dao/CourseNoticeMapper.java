package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.CourseNotice;

public interface CourseNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseNotice record);

    int insertSelective(CourseNotice record);

    CourseNotice selectByPrimaryKey(Long id);
    
    List<CourseNotice> listCourseNotice(@Param("courseId")String courseId);

    int updateByPrimaryKeySelective(CourseNotice record);

    int updateByPrimaryKey(CourseNotice record);
}