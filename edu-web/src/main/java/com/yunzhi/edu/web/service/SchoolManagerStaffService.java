package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolTeacher;

public interface SchoolManagerStaffService {

	/**
	 * 操作学生表
	 * @param students
	 * @return
	 */
	public int insertSchoolStudent(List<SchoolStudent> students);
	
	public List<SchoolStudent> listSchoolStudent(SchoolStudent student);
	
	public SchoolStudent getSchoolStudent(SchoolStudent student);
	
	public int updateSchoolStudent(SchoolStudent student);
	
	public int deleteSchoolStudent(SchoolStudent student);
	
	/**
	 * 操作教师表
	 * @param teachers
	 * @return
	 */
	public int insertSchoolTeacher(List<SchoolTeacher> teachers);
	
	public List<SchoolTeacher> listSchoolTeacher(SchoolTeacher teacher);
	
	public int updateSchoolTeacher(SchoolTeacher teacher);
	
}
