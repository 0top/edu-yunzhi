package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.UserCourse;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);
    
    List<UserCourse> listUserCourse(UserCourse record);
    
    UserCourse getUserCourse(UserCourse record);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}