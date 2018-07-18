package com.yunzhi.edu.user;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUserNotice {

	@Autowired
	private UserService userService;
	
	
	public TestUserNotice(){}
	
//	@Test
//	public void testSelect(){
//		
//		try{
//			List<UserNotice> usernotice = usernoticeDao.listNoticeByUserId("45565");
//			for(UserNotice unotice: usernotice){
//				System.out.println(unotice.toString());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testInsert(){
//		
//		UserNotice notice = new UserNotice();
//		
//		notice.setContent("我们的系统将于明晚更新");
//		notice.setIsRead(false);
//		notice.setNoticeId(Long.parseLong(RandomId.createId()));
//		notice.setSendFrom("10001");
//		notice.setUserId("45565");
//		notice.setCreateTime(new Date());
//		
//		try{
//			usernoticeDao.insertSelective(notice);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
}
