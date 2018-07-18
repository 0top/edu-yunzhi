package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;

public interface SchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolWithBLOBs record);

    int insertSelective(SchoolWithBLOBs record);

    SchoolWithBLOBs selectByPrimaryKey(Long id);
    
    SchoolWithBLOBs getSchoolWithBLOBs(@Param("orgCode")String orgCode);
    
    List<School> listAllSchoolBase();
    
    List<SchoolWithBLOBs> listAllSchool();

    int updateByPrimaryKeySelective(School school);

    int updateByPrimaryKeyWithBLOBs(SchoolWithBLOBs record);

    int updateByPrimaryKey(School record);
    
    int updateAuthorizate(String orgCode);
}