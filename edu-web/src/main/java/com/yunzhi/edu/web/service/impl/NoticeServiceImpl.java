package com.yunzhi.edu.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.EduNoticeMapper;
import com.yunzhi.edu.dao.SchoolNoticeMapper;
import com.yunzhi.edu.dao.SchoolStudentMapper;
import com.yunzhi.edu.dao.SchoolTeacherMapper;
import com.yunzhi.edu.dao.muti.UserNoticeMutiMapper;
import com.yunzhi.edu.entity.EduNotice;
import com.yunzhi.edu.entity.SchoolNotice;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.web.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private EduNoticeMapper eduNoticeDao;
	
	@Resource
	private SchoolStudentMapper studentDao;
	
	@Resource
	private SchoolTeacherMapper teacherDao;
	
	@Resource
	private SchoolNoticeMapper schoolNoticeDao;
	
	@Resource 
	private UserNoticeMutiMapper userNoticeMutiDao;
	
	@Override
	public int insertNoticeToUser(EduNotice notice) {
		
		eduNoticeDao.insert(notice);
		
		return 0;
	}
	
	@Override
	public int insertNoticeToSchoolStaff(String staffNum, SchoolNotice schoolNotice) {
		
		schoolNoticeDao.insertSelective(schoolNotice);
		
		return 0;
	}

	@Override
	public int insertNoticeToSchoolMutiStaff(String orgCode, String classId, String departmentId,
			SchoolNotice schoolNotice) {
		
		if(null == orgCode || orgCode.equals("")){
			return 0;
		}
		if(null != classId && !classId.equals("")){
			SchoolStudent student = new SchoolStudent();
			student.setOrgCode(orgCode);
			student.setClassId(classId);
			List<SchoolStudent> students = studentDao.listStudentSelective(student);
			for(SchoolStudent s: students){
				schoolNotice.setAcceptTo(s.getStaffNum());
				schoolNotice.setType((byte) 2);
				schoolNoticeDao.insertSelective(schoolNotice);
			}
			
			SchoolTeacher teacher = new SchoolTeacher();
			teacher.setOrgCode(orgCode);
			teacher.setClassId(classId);
			teacher = teacherDao.selectTeacherSelective(teacher);
			if(null != teacher){
				schoolNotice.setAcceptTo(teacher.getStaffNum());
				schoolNoticeDao.insertSelective(schoolNotice);
			}
		}
		
		if(null != departmentId && !departmentId.equals("")){
			SchoolStudent student = new SchoolStudent();
			student.setOrgCode(orgCode);
			student.setDepartmentId(departmentId);
			List<SchoolStudent> students = studentDao.listStudentSelective(student);
			List<String> classIds = new ArrayList<String>();
			for(SchoolStudent s: students){
				
				if(!classIds.contains(s.getClassId())){
					classIds.add(s.getClassId());
				}
				
				schoolNotice.setAcceptTo(s.getStaffNum());
				schoolNotice.setType((byte) 1);
				schoolNoticeDao.insertSelective(schoolNotice);
			}
			
			SchoolTeacher teacher = new SchoolTeacher();
			teacher.setOrgCode(orgCode);
			for(int i = 0;i<classIds.size();i++){
				teacher.setClassId(classId);
				teacher = teacherDao.selectTeacherSelective(teacher);
				if(null != teacher){
					schoolNotice.setAcceptTo(teacher.getStaffNum());
					schoolNoticeDao.insertSelective(schoolNotice);
				}
			}
		}
		
		return 0;
	}

	@Override
	public List<SchoolNotice> listSchoolNotice(User user) {
		
		if(null != user.getOrgCode() && !user.getOrgCode().equals("")){
			
			SchoolNotice notice = new SchoolNotice();
			notice.setOrgCode(user.getOrgCode());
			notice.setAcceptTo(user.getStaffNum());
			return schoolNoticeDao.listSchoolNotice(notice);
		}
		return null;
	}

	@Override
	public List<SchoolNotice> listSchoolNoticeBySend(String orgCode, String sendFrom, int type) {
		
		return schoolNoticeDao.listSchoolNoticeBySend(orgCode, sendFrom, type);
	}

	


}
