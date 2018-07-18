package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.SchoolNotice;

public interface SchoolNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolNotice record);

    int insertSelective(SchoolNotice record);

    SchoolNotice selectByPrimaryKey(Long id);
    
    List<SchoolNotice> listSchoolNotice(SchoolNotice notice);

    int updateByPrimaryKeySelective(SchoolNotice record);

    int updateByPrimaryKey(SchoolNotice record);
    
    List<SchoolNotice> listSchoolNoticeBySend(String orgCode, String sendFrom, int  type);
}