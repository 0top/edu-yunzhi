package com.yunzhi.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.SchoolTeacher;

public interface SchoolTeacherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolTeacher record);

    int insertSelective(SchoolTeacher record);
    
    SchoolTeacher selectByPrimaryKey(Long id);
    
    SchoolTeacher selectTeacherSelective(SchoolTeacher record);
    
    SchoolTeacher selectByStaffNumAuthentication(@Param("staffNum")String staffNum, @Param("orgCode")String orgCode);
    
    List<SchoolTeacher> listTeacherSelective(SchoolTeacher record);

    int updateByPrimaryKeySelective(SchoolTeacher record);

    int updateByPrimaryKey(SchoolTeacher record);
}