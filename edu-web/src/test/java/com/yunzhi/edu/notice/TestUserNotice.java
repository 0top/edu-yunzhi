package com.yunzhi.edu.notice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.muti.UserNoticeMutiMapper;
import com.yunzhi.edu.entity.SchoolStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUserNotice {

	@Autowired
	private UserNoticeMutiMapper userNoticeMutiDao;

	public TestUserNotice() {
	}


}
