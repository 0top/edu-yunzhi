package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.EduTag;

public interface EduTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EduTag record);

    int insertSelective(EduTag record);

    EduTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EduTag record);

    int updateByPrimaryKey(EduTag record);
}