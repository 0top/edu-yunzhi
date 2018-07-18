package com.yunzhi.edu.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.UserMapper;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUesrLogin {

	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private UserService userService;
	
	public TestUesrLogin(){}
	
//	@Test
//	public void testStaffNumLogin(){
//		
//		try{
//			User user = userService.findUserByStaffNum("121303");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testLogin(){
//		
//		try{
//			User user = userDao.selectByPhoneNumAuthentication("12345654321");
//			System.out.println(user.toString());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testActivate(){
//		
//		User user = new User();
//		user.setUserId("45565");
//		user.setId((long)3);
//		
//		SchoolStudent student = new SchoolStudent();
//		student.setOrgCode("10150");
//		student.setStaffNum("121304");
//		student.setRealName("廿七");
//		
//		try{
//			userService.activateUser(student, user);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		
//	}
}
