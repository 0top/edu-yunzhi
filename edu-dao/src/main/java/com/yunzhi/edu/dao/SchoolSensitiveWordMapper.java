package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.SchoolSensitiveWord;

public interface SchoolSensitiveWordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolSensitiveWord record);

    int insertSelective(SchoolSensitiveWord record);

    SchoolSensitiveWord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolSensitiveWord record);

    int updateByPrimaryKey(SchoolSensitiveWord record);
}