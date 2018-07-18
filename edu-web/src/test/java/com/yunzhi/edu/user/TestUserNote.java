package com.yunzhi.edu.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.UserNoteMapper;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserNote;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUserNote {

	public TestUserNote(){}
	
	@Autowired
	private UserService userService;
	
	@Test
	public void TestInsert(){
		try{
			UserNote userNote = new UserNote();
			userNote.setUserId("3244");
			userNote.setTitle("我的笔记");
			//userNote.setNoteId(RandomId.createId());
			userNote.setContent("预计环境态度和行为将影响H2公共汽车的态度和WTP。因此，环境态度和行为被要求被调查者以1-5的比例来评价一系列的陈述。");
			userService.insertNote(userNote);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void TestList(){
//		User user = new User();
//		user.setUserId("3244");
//		List<UserNote> notes = userService.listUserNote(user);
//		for(UserNote note : notes){
//			System.out.println(note.toString());
//		}
//	}
}
