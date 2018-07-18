package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.SchoolAdmin;
import com.yunzhi.edu.entity.SchoolAdminKey;

public interface SchoolAdminMapper {
    int deleteByPrimaryKey(SchoolAdminKey key);

    int insert(SchoolAdmin record);

    int insertSelective(SchoolAdmin record);

    SchoolAdmin selectByPrimaryKey(SchoolAdminKey key);

    int updateByPrimaryKeySelective(SchoolAdmin record);

    int updateByPrimaryKey(SchoolAdmin record);
}