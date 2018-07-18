package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.SchoolStudent;

public interface SchoolStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolStudent record);

    int insertSelective(SchoolStudent record);
    
    SchoolStudent selectByPrimaryKey(Long id);
    
    SchoolStudent selectStudentSelectvie(SchoolStudent record);
    
    List<SchoolStudent> listStudentSelective(SchoolStudent record);
    

    int updateByPrimaryKeySelective(SchoolStudent record);

    int updateByPrimaryKey(SchoolStudent record);
    
    int activateUser(SchoolStudent student);
}