package com.yunzhi.edu.course;

import java.util.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.CourseChapterExamMapper;
import com.yunzhi.edu.entity.CourseChapterExam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseChapterExam {

	@Autowired
	private CourseChapterExamMapper examDao;
	
	public TestCourseChapterExam(){}
	
//	@Test
//	public void TestGet(){
//		CourseChapterExam c1 = examDao.selectByPrimaryKey((long) 1);
//		System.out.println(c1.toString());
//	}
	
	@Test
	public void TestSelect(){
		try{
		CourseChapterExam c1 = new CourseChapterExam();
		c1.setCourseId("1522243682385");
		System.out.println(c1.toString());
		List<CourseChapterExam> exams = examDao.listCourseChapterExamList(c1);
		
		if(exams==null){
			System.out.println("null--------");
		}
		System.out.println(exams.toString());
		for(CourseChapterExam exam: exams){
			System.out.println(exam.toString());
		}
		}catch(Exception e){
			System.out.println("null");
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void TestInsert(){
//		try{
//		CourseChapterExam c1 = new CourseChapterExam();
//		CourseChapterExam c2 = new CourseChapterExam();
//		c1.setCourseId("1522243682385");
//		c1.setChapterId(1);
//		c1.setDescription("一试");
//		c1.setExamId(System.currentTimeMillis()+"");
//		c1.setContext("content");
//		c1.setAnswer("answer");
//		c1.setEndTime(new Date());
//		
//		c2.setCourseId("1522243682385");
//		c2.setChapterId(1);
//		c2.setExamId(System.currentTimeMillis()+"");
//		c2.setContext("content  content");
//		c2.setAnswer("answer answer");
//		c2.setEndTime(new Date());
//		
//		examDao.insertSelective(c1);
//		examDao.insertSelective(c2);
//		
//		System.out.println("ok");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
