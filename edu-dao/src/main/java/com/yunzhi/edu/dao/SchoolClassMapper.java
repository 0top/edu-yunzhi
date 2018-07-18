package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.SchoolClass;
import com.yunzhi.edu.entity.SchoolClassKey;

public interface SchoolClassMapper {
    int deleteByPrimaryKey(SchoolClassKey key);

    int insert(SchoolClass record);

    int insertSelective(SchoolClass record);
    
    SchoolClass selectByPrimaryKey(SchoolClassKey key);
    
    List<SchoolClass> listSchoolClassSelective(SchoolClass record);

    int updateByPrimaryKeySelective(SchoolClass record);

    int updateByPrimaryKey(SchoolClass record);
}