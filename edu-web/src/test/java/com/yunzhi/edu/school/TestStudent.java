package com.yunzhi.edu.school;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.SchoolStudentMapper;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.web.service.SchoolManagerStaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestStudent {

	@Autowired
	private SchoolManagerStaffService studentService;
	
	@Autowired
	private SchoolStudentMapper studentDao;
	
	public TestStudent(){}
	
	
//	@Test
	public void TestSelect(){
		SchoolStudent student = new SchoolStudent();
		student.setOrgCode("");
		List<SchoolStudent> students =  studentService.listSchoolStudent(student);
		if(students!=null){
			for(SchoolStudent s:students){
				System.out.println(s.toString());
			}
		}
		
	}
	
//	@Test
//	public void Testselect(){
//		try{
//			SchoolStudent student = new SchoolStudent();
//					
//			student = studentDao.selectByPrimaryKey((long) 100);
//			if(student == null){
//				System.out.println("null");
//			}
//			
//			SchoolStudent students = studentDao.selectByPrimaryKey((long) 100);
//			
//			if(students == null){
//				System.out.println("null");
//			}
//		
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		List<SchoolStudent> students =  studentService.listSchoolStudent(student);
//		if(students!=null){
//			for(SchoolStudent s:students){
//				System.out.println(s.toString());
//			}
//		}
//	}
}
