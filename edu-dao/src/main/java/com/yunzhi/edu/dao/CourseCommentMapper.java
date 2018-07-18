package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseComment;

public interface CourseCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseComment record);

    int insertSelective(CourseComment record);

    CourseComment selectByPrimaryKey(Long id);
    
    List<CourseComment> listCourseComment(CourseComment comment);

    int updateByPrimaryKeySelective(CourseComment record);

    int updateByPrimaryKey(CourseComment record);
}