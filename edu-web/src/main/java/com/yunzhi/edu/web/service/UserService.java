package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.entity.UserNote;
import com.yunzhi.edu.entity.UserSchedule;
import com.yunzhi.edu.web.exception.PhoneNumHasUsedException;
import com.yunzhi.edu.web.exception.UserHasActivateException;
import com.yunzhi.edu.web.exception.NoSuchSchoolStudentException;

public interface UserService {

	
	public User findUserByPhoneNum(String username);
	
	public User findUserByStaffNum(String staffNum);
		
	public User login(String username, String password);
	
	//注册
	public int insertUser(User user) throws PhoneNumHasUsedException;
	
	public int activateUser(SchoolStudent student, User user) throws UserHasActivateException, NoSuchSchoolStudentException;

	
	/**
	 * 待定
	 * @param note
	 * @return
	 */
	
	public int insertNote(UserNote note);
	
	public List<UserNote> listUserNote(User user);
	
	public int deleteNote(Long id);
	
	public int updateNote(UserNote note);
	
	//用户日程
	public int insertSchedule(UserSchedule schedule);
	
	public int deleteSchedule(UserSchedule schedule);
	
	public List<UserSchedule> listSchedule(UserSchedule schedule);
	
	
}
