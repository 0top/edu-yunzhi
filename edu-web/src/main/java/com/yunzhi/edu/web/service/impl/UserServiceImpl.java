package com.yunzhi.edu.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.yunzhi.edu.dao.SchoolStudentMapper;
import com.yunzhi.edu.dao.UserCourseMapper;
import com.yunzhi.edu.dao.UserMapper;
import com.yunzhi.edu.dao.UserNoteMapper;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserNote;
import com.yunzhi.edu.entity.UserSchedule;
import com.yunzhi.edu.util.EncryptUtil;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.web.exception.NoSuchSchoolStudentException;
import com.yunzhi.edu.web.exception.PhoneNumHasUsedException;
import com.yunzhi.edu.web.exception.UserHasActivateException;
import com.yunzhi.edu.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userDao;

	@Resource
	private SchoolStudentMapper studentDao;
	
	@Resource
	private UserNoteMapper userNoteDao;

	
	@Resource
	private UserCourseMapper usercourseDao;

	
	@Override
	public User findUserByPhoneNum(String phone) {
		
		if(null == phone||phone.equals("")){
			return null;
		}
		
		return userDao.selectByPhoneNum(phone);
	}
	
	@Override
	public User findUserByStaffNum(String staffNum){
		
		if(null == staffNum||staffNum.equals("")){	
			return null;
		}
		
		return userDao.findUserByStaffNum(staffNum);
	}

	@Override
	public User login(String phone, String password) {
		
		if(null == phone || null == password)
			return null;

		User user = new User();
		user.setId(Long.parseLong(RandomId.createId()));
		String salt = EncryptUtil.createCredentialsSalt();
		user.setSalt(salt);
		user.setPhonenum(phone);
		user.setPassword(EncryptUtil.encryptMD5(password, salt));
		
		return userDao.selectUserSelective(user);
	}

	public int insertUser(User user) throws PhoneNumHasUsedException {
		
		if(null == user)
			return 0;
		
		User cuser = userDao.selectByPhoneNum(user.getPhonenum());
		
		if(null != cuser){
			throw new PhoneNumHasUsedException("手机号已被注册");
		}
		user.setUserId(RandomId.createId());
		String salt = EncryptUtil.createCredentialsSalt();
		user.setSalt(salt);
		String password = user.getPassword();
		user.setPassword(EncryptUtil.encryptMD5(password, salt));
		
		return userDao.insertSelective(user);

	}

	@Override
	public int activateUser(SchoolStudent student, User user)  throws UserHasActivateException, NoSuchSchoolStudentException{

		if (null == student.getOrgCode()||student.getOrgCode().equals("") || 
				null == student.getStaffNum() || student.getStaffNum().equals("") ||
				null == student.getRealName()||student.getRealName().equals("")){
			System.out.println("学生信息出错");
			return 0;
		}
		System.out.println(student.toString());
		SchoolStudent sstudent = studentDao.selectStudentSelectvie(student);
		if(null == sstudent){
			throw new NoSuchSchoolStudentException("无此学生信息，请确认信息后再试");
		}
		if(sstudent.getIsActivate()==1){
			throw new UserHasActivateException("用户已激活，请联系学校进行解绑");
		}
		
		User userr =  userDao.selectUserSelective(user);
		if(userr == null){
			System.out.println("无此学生");
			return 0;
		}
		System.out.println("激活："+userr.toString());
		
			studentDao.activateUser(student);
			
			userDao.activateUser(student.getOrgCode(), student.getStaffNum(), user.getId());

			System.out.println("激活："+userr.getOrgCode() +"   "+ student.toString()+" -- 失败");

		return 1;
	}

	@Override
	public int insertNote(UserNote note) {
		
		note.setNoteId(RandomId.createId());
		
		return userNoteDao.insertSelective(note);
	}

	@Override
	public List<UserNote> listUserNote(User user) {
		
		
		return userNoteDao.listUserNote(user.getUserId());
	}

	@Override
	public int deleteNote(Long id) {

		return userNoteDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateNote(UserNote note) {
		
		return userNoteDao.updateByPrimaryKey(note);
	}

	//用户日程
	@Override
	public int insertSchedule(UserSchedule schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchedule(UserSchedule schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserSchedule> listSchedule(UserSchedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

}
