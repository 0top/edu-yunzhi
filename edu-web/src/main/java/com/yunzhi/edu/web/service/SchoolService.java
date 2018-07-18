package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;

public interface SchoolService {
	
	/**
	 * 列出所有学校详细信息
	 * @return
	 */
	public List<SchoolWithBLOBs> listAllSchool();
	
	public List<School> listAllSchoolBase();
	
	public School getSchoolDetail(String orgCode);

}
