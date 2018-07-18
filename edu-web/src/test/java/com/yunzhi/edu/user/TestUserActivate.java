package com.yunzhi.edu.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUserActivate {

	
	@Resource
	private UserService userService;
	
	public TestUserActivate(){}
	
//	@Test
//	public void testActiveteUser(){
//		
//		SchoolStudent student = new SchoolStudent();
//		student.setOrgCode("10150");
//		student.setStaffNum("121303");
//		student.setRealName("陈思");
//		
//		User user = new User();
//		user.setId((long)2);
//		
//		try{
//			userService.activateUser(student, user);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
}
