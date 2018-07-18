package com.yunzhi.edu.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.SchoolMapper;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;
import com.yunzhi.edu.web.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Resource
	private SchoolMapper schoolDao;
	
	@Override
	public List<SchoolWithBLOBs> listAllSchool() {
		return schoolDao.listAllSchool();
	}

	@Override
	public List<School> listAllSchoolBase() {
		return schoolDao.listAllSchoolBase();
	}

	@Override
	public School getSchoolDetail(String orgCode) {
		
		if( orgCode.equals(""))
			return null;
		
		return schoolDao.getSchoolWithBLOBs(orgCode);
	}
	
	
}
