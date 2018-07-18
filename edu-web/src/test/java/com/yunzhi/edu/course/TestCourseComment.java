package com.yunzhi.edu.course;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.entity.CourseComment;
import com.yunzhi.edu.web.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseComment {

	@Resource
	private CourseService courseService;
	
	public TestCourseComment(){}
	
//	@Test
//	public void testSelect(){
//		
//		CourseComment comment = new CourseComment();
//		comment.setCourseId("1522243682385");
//		
//		List<CourseComment> comments = courseService.listCourseComment(comment);
//		
//		for(CourseComment com : comments){
//			System.out.println(com.toString());
//		}
//	}
	
	
//	@Test
//	public void testInsert(){
//		CourseComment comment = new CourseComment();
//		
//		comment.setContent("知识点清晰，满分");
//		comment.setCourseId("1522243682385");
//		comment.setCreateTime(new Date());
//		comment.setRate((byte) 5);
//		comment.setSendFromId("32415");
//		comment.setSendFromName("三月");
//		
//		courseService.insertCourseComment(comment);
//	}
}
