package com.yunzhi.edu.school;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.web.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestTeacher {
	
	@Autowired
	private TeacherService teacherService;
	
	public TestTeacher(){}
	
	@Test
	public void TestSelect(){
		try{
		
			String teacherId = "";
			List<Course> courses = teacherService.listCourse(teacherId);
			if(null != courses){
				for(Course course: courses){
					System.out.println(course.toString());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
