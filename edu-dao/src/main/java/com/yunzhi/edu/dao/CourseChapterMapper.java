package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseChapter;

public interface CourseChapterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);
    
    int insertChapterListSelective(List<CourseChapter> records);

    CourseChapter selectByPrimaryKey(Long id);
    
    List<CourseChapter> listChapterSelective(String courseId);

    int updateByPrimaryKeySelective(CourseChapter record);

    int updateByPrimaryKey(CourseChapter record);
}