package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.EduNotice;
import com.yunzhi.edu.entity.SchoolNotice;
import com.yunzhi.edu.entity.User;

public interface NoticeService {
	
	//给用户发通知
	public int insertNoticeToUser(EduNotice notice);	
	
	public int insertNoticeToSchoolStaff(String staffNum, SchoolNotice schoolNotice);
	
	public int insertNoticeToSchoolMutiStaff(String orgCode, String classId, String departmentId, SchoolNotice schoolNotice);
	
	
	public List<SchoolNotice> listSchoolNotice(User user);
	
	public List<SchoolNotice> listSchoolNoticeBySend(String orgCode, String sendFrom, int type);

}
