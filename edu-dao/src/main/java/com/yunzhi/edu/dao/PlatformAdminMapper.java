package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.PlatformAdmin;

public interface PlatformAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformAdmin record);

    int insertSelective(PlatformAdmin record);

    PlatformAdmin selectByPrimaryKey(Long id);
    
    PlatformAdmin selectSelective(PlatformAdmin record);

    int updateByPrimaryKeySelective(PlatformAdmin record);

    int updateByPrimaryKey(PlatformAdmin record);
}