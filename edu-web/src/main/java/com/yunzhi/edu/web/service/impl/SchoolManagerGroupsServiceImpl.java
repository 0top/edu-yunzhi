package com.yunzhi.edu.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.SchoolClassMapper;
import com.yunzhi.edu.dao.SchoolDepartmentMapper;
import com.yunzhi.edu.entity.SchoolClass;
import com.yunzhi.edu.entity.SchoolDepartment;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.web.service.SchoolManagerGroupsService;

@Service
public class SchoolManagerGroupsServiceImpl implements SchoolManagerGroupsService {
	
	@Autowired
	private SchoolDepartmentMapper departmentDao;
	
	@Autowired
	private SchoolClassMapper schoolClassDao;
	
	/**
	 * 操作院系表
	 * @param department
	 * @return
	 */
	@Override
	public List<SchoolDepartment> listDepartment(String orgCode) {
		
		if(!orgCode.equals("")){
			return departmentDao.listDepartmentByOrgCode(orgCode);
		}
		return null;
	}

	@Override
	public int insertDepartment(SchoolDepartment department){
		
		if(null != department){
			if(department.getDepartmentId()==null){
				department.setDepartmentId(RandomId.createId());
			}
			
		   return departmentDao.insertSelective(department);
		}
		return 0;
		
	}

	
	
	@Override
	public int insertDepartmentList(List<SchoolDepartment> departments) {
		
		if(null == departments){
			return 0;
		}

		for(SchoolDepartment department: departments){
			departmentDao.insertSelective(department);
		}
		return 1;
				
	}
	
	@Override
	public int updateDepartment(SchoolDepartment department) {
		
		if(null != department){
			return departmentDao.updateByPrimaryKeySelective(department);
		}
		return -1;
		
	}
	
	@Override
	public void deleteDepartment() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 操作班级表
	 * @param classes
	 * @return
	 */
	@Override
	public List<SchoolClass> listSchoolClass(SchoolClass schoolClass){
		
		if(null != schoolClass){
			return schoolClassDao.listSchoolClassSelective(schoolClass);
		}
		return null;
	}

	@Override
	public void deleteSchoolClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertSchoolClass(SchoolClass schoolClass){

		if(null != schoolClass){
			if(schoolClass.getClassId().equals(""))
				schoolClass.setClassId(RandomId.createId());
			return schoolClassDao.insertSelective(schoolClass);
		}
		return -1;
	}
	
	@Override
	public int insertSchoolClassList(List<SchoolClass> schoolclasslist) {
		
		if(null == schoolclasslist){
			return 0;
		}
		
		for(SchoolClass schoolClass: schoolclasslist){
			schoolClassDao.insertSelective(schoolClass);
		}
		return 1;
				
	}

	@Override
	public int updateSchoolClass(SchoolClass schoolClass) {
		if(null != schoolClass){
			return schoolClassDao.updateByPrimaryKeySelective(schoolClass);
		}
		return -1;
	}

	@Override
	public void getLearnStatus() {
		// TODO Auto-generated method stub
		
	}

}
