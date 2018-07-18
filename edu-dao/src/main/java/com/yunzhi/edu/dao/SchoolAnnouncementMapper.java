package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.SchoolAnnouncement;

public interface SchoolAnnouncementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolAnnouncement record);

    int insertSelective(SchoolAnnouncement record);

    SchoolAnnouncement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolAnnouncement record);

    int updateByPrimaryKey(SchoolAnnouncement record);
}