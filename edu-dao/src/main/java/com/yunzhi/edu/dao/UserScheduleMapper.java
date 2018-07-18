package com.yunzhi.edu.dao;

import com.yunzhi.edu.entity.UserSchedule;

public interface UserScheduleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserSchedule record);

    int insertSelective(UserSchedule record);

    UserSchedule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSchedule record);

    int updateByPrimaryKey(UserSchedule record);
}