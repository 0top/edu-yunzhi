package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.SchoolClass;
import com.yunzhi.edu.entity.SchoolDepartment;
import com.yunzhi.edu.entity.SchoolStudent;

public interface SchoolManagerGroupsService {
	
	/**
	 * 操作院系表
	 */
	public List<SchoolDepartment> listDepartment(String orgCode);
	public int insertDepartment(SchoolDepartment department);
	public int insertDepartmentList(List<SchoolDepartment> department);
	public int updateDepartment(SchoolDepartment department);
	public void deleteDepartment();
	
	/**
	 * 操作班级表
	 */
	public List<SchoolClass> listSchoolClass(SchoolClass schoolClass);
	public void deleteSchoolClass();
	public int insertSchoolClass(SchoolClass schoolClass);
	public int insertSchoolClassList(List<SchoolClass> classes);
	public int updateSchoolClass(SchoolClass schoolClass);
	
	
	/**
	 * 查询学习情况
	 */
	public void getLearnStatus();
	

	
	


}
