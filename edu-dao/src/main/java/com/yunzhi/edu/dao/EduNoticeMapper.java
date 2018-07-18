package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.EduNotice;

public interface EduNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EduNotice record);

    int insertSelective(EduNotice record);

    EduNotice selectByPrimaryKey(Long id);
    
    List<EduNotice> selectSelective(EduNotice record);
    
    List<EduNotice> selectUserNoticeSelective(String acceptTo);

    int updateByPrimaryKeySelective(EduNotice record);

    int updateByPrimaryKeyWithBLOBs(EduNotice record);

    int updateByPrimaryKey(EduNotice record);
}