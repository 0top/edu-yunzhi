package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.SchoolDepartment;

public interface SchoolDepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolDepartment record);

    int insertSelective(SchoolDepartment record);
    
    SchoolDepartment selectByPrimaryKey(Long id);
    
    List<SchoolDepartment> listDepartmentByOrgCode(@Param("orgCode")String orgCode);

    int updateByPrimaryKeySelective(SchoolDepartment record);

    int updateByPrimaryKey(SchoolDepartment record);
}