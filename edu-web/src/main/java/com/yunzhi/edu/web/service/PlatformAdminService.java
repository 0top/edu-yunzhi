package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.PlatformAdmin;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;

public interface PlatformAdminService {
	
	public int AuthorizeSchool(School school);
	
	public PlatformAdmin adminLogin(PlatformAdmin record);
	
	public List<SchoolWithBLOBs> listAllSchoolDetail();

}
