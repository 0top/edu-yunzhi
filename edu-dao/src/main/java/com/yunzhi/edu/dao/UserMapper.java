package com.yunzhi.edu.dao;

import org.apache.ibatis.annotations.Param;

import com.yunzhi.edu.entity.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    
    User selectByPhoneNum(@Param("phonenum")String phonenum);
    
    User findUserByStaffNum(@Param("staffNum")String staffNum);
    
    User selectByPhoneNumAuthentication(@Param("phonenum")String phonenum);
    
    User selectUserSelective(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int unActivateUser(String orgCode, String staffNum);
    
    int activateUser(@Param("orgCode")String orgCode, @Param("staffNum")String staffNum, @Param("id")Long id);
}