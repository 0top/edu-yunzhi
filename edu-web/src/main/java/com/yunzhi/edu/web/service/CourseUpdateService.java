package com.yunzhi.edu.web.service;

import com.yunzhi.edu.entity.UserCourse;

public interface CourseUpdateService {

	public UserCourse updateUserCourse(String userId, String courseId);
	
	public UserCourse createUserCourse(UserCourse userCourse);
}
