package com.yunzhi.edu.course;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.CourseQAMapper;
import com.yunzhi.edu.entity.CourseQA;
import com.yunzhi.edu.web.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseQA {

	@Resource
	private CourseService courseService;
	
	public TestCourseQA(){}
	
//	@Test
	public void TestSelect(){
		List<CourseQA> qas = new ArrayList<CourseQA>();
		CourseQA qa = new CourseQA();
		qa.setCourseId("1522243682385");
		try{
			qas = courseService.listCourseQA(qa);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(CourseQA qaa : qas){
			System.out.println(qaa.toString());
		}
	}
	
//	@Test
//	public void TestInsert(){
//		
//		CourseQA qa = new CourseQA();
//		qa.setCourseId("1522243682385");
//		qa.setUserId("32415");
//		qa.setUserName("三月");
//		qa.setQuestion("地震等级如何划分？");
//		qa.setIsProcess(false);
//		
//		try{
//		
//			courseService.insertCourseQA(qa);
//		
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
