package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.UserExam;

public interface UserExamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserExam record);

    int insertSelective(UserExam record);

    UserExam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserExam record);

    int updateByPrimaryKey(UserExam record);
}