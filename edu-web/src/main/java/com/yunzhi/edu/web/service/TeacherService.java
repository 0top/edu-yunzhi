package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseNotice;
import com.yunzhi.edu.entity.CourseTask;
import com.yunzhi.edu.entity.SchoolTeacher;

public interface TeacherService {
	
	
	
	//交由course管理？
	public List<Course> listCourse(String teacherId);
	
	public SchoolTeacher findTeacherByStaffNum(String staffNum);
	
	public SchoolTeacher selectByStaffNumAuthentication(String staffNum, String orgCode);
	
	
	public int insertTask(CourseTask task);
	
	public List<CourseTask> listCourseTask(String teacherId);
	
	public int deleteTask(Long id);
	
	//coursenotice
	public int insertCourseNotice(CourseNotice notice);
	
	public int deleteCourseNoticeById(Long id);
	
	public List<CourseNotice> listCourseNotice(String courseId);
	

}
