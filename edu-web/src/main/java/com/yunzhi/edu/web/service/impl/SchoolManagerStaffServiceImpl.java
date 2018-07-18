package com.yunzhi.edu.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.SchoolClassMapper;
import com.yunzhi.edu.dao.SchoolDepartmentMapper;
import com.yunzhi.edu.dao.SchoolStudentMapper;
import com.yunzhi.edu.dao.SchoolTeacherMapper;
import com.yunzhi.edu.dao.UserMapper;
import com.yunzhi.edu.entity.SchoolClass;
import com.yunzhi.edu.entity.SchoolDepartment;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.web.service.SchoolManagerStaffService;

@Service
public class SchoolManagerStaffServiceImpl implements SchoolManagerStaffService{
	
	@Resource
	private SchoolStudentMapper studentDao;
	
	@Resource
	private SchoolTeacherMapper teacherDao;
	
	@Resource
	private SchoolClassMapper schoolClassDao;
	
	@Resource
	private SchoolDepartmentMapper departmentDao;
	
	@Resource
	private UserMapper userDao;

	/**
	 * 操作学生表
	 * @return
	 */
	@Override
	public int insertSchoolStudent(List<SchoolStudent> students) {
		
		if(students == null)
			return 0;
		
		List<SchoolClass> schoolClass = new ArrayList<SchoolClass>();
		List<String> sc = new ArrayList<String>();
		List<SchoolDepartment> department = new ArrayList<SchoolDepartment>();
		List<String> sd = new ArrayList<String>();
		
		for(SchoolStudent student: students){
			studentDao.insertSelective(student);
			if(null != student.getDepartmentId()&& !"".equals(student.getDepartmentId())){
				if(!sd.contains(student.getDepartmentId())){
					sd.add(student.getDepartmentId());
					SchoolDepartment d = new SchoolDepartment();
					d.setOrgCode(student.getOrgCode());
					d.setDepartmentId(student.getDepartmentId());
					department.add(d);
				}
			}
			
			if(null != student.getClassId()&& ""!=student.getClassId()){
				if(!sc.contains(student.getClassId()) ){
					sc.add(student.getClassId());
					SchoolClass c = new SchoolClass();
					c.setOrgCode(student.getOrgCode());
					c.setClassId(student.getClassId());
					c.setDepartmentId(student.getDepartmentId());
					schoolClass.add(c);
				}
			}
			
		}
		if(null != schoolClass){
			for(SchoolClass c: schoolClass){
				schoolClassDao.insertSelective(c);
			}
		}
		if(null != department){
			for(SchoolDepartment d: department){
				departmentDao.insertSelective(d);
			}
		}
		return 1;
	}

	@Override	
	public List<SchoolStudent> listSchoolStudent(SchoolStudent student) {
		
		if(null == student){
			return null;
		}
		
		return studentDao.listStudentSelective(student) ;
	}
	
	//获取单个学生的信息
	@Override
	public SchoolStudent getSchoolStudent(SchoolStudent student) {
		
		if(null != student){
			 return studentDao.selectStudentSelectvie(student);
		}
		
		return null;
	}
	
	@Override
	public int updateSchoolStudent(SchoolStudent student) {
		
		if(null == student){
			return 0;
		}

		return studentDao.updateByPrimaryKeySelective(student);
	}

	@Override
	public int deleteSchoolStudent(SchoolStudent student) {
		
		if(student == null){
			return 0;
		}
		
		/**
		 * 设置为未激活状态
		 */
		userDao.unActivateUser(student.getOrgCode(), student.getStaffNum());

		return  studentDao.deleteByPrimaryKey(student.getId()) ;
	}
	
	/**
	 * 操作教师表
	 * @param teachers
	 * @return
	 */
	@Override
	public int insertSchoolTeacher(List<SchoolTeacher> teachers) {
		
		if(null == teachers){
			return 0;
		}
		
		for(SchoolTeacher teacher : teachers){
			teacherDao.insertSelective(teacher);
		}
		return 1;
	}

	@Override
	public List<SchoolTeacher> listSchoolTeacher(SchoolTeacher teacher) {
		
		if(null == teacher){
			return null;
		}

		return teacherDao.listTeacherSelective(teacher);
	}
	
	@Override
	public int updateSchoolTeacher(SchoolTeacher teacher) {
		if(null == teacher){
			return 0;
		}
		
		return  teacherDao.updateByPrimaryKeySelective(teacher);
	}


	


}
