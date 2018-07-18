package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.UserNote;

public interface UserNoteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserNote record);

    int insertSelective(UserNote record);

    UserNote selectByPrimaryKey(Long id);
    
    List<UserNote> listUserNote(String userId);

    int updateByPrimaryKeySelective(UserNote record);

    int updateByPrimaryKey(UserNote record);
}