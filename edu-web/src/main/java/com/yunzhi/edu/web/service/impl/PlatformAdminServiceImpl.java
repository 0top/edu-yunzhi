package com.yunzhi.edu.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.PlatformAdminMapper;
import com.yunzhi.edu.dao.SchoolMapper;
import com.yunzhi.edu.entity.PlatformAdmin;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;
import com.yunzhi.edu.web.service.PlatformAdminService;

@Service
public class PlatformAdminServiceImpl implements PlatformAdminService{

	@Resource
	private PlatformAdminMapper platformAdmindDao;
	
	@Resource
	private SchoolMapper schoolDao;
	
	@Override
	public int AuthorizeSchool(School school) {
		
		if(null == school){
			return 0;
		}
		
		return schoolDao.updateByPrimaryKeySelective(school);
	}

	@Override
	public PlatformAdmin adminLogin(PlatformAdmin record) {
		
		if(null == record)
			return null;
		return platformAdmindDao.selectSelective(record);

	}

	@Override
	public List<SchoolWithBLOBs> listAllSchoolDetail() {
		
		return schoolDao.listAllSchool();
	}

	
}
