package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.CourseChapterExam;

public interface CourseChapterExamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseChapterExam record);

    int insertSelective(CourseChapterExam record);

    CourseChapterExam selectByPrimaryKey(Long id);

    List<CourseChapterExam> listCourseChapterExamList(CourseChapterExam record);
    
    int updateByPrimaryKeySelective(CourseChapterExam record);

    int updateByPrimaryKeyWithBLOBs(CourseChapterExam record);

    int updateByPrimaryKey(CourseChapterExam record);
}