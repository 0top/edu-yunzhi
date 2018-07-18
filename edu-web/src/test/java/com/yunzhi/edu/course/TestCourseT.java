package com.yunzhi.edu.course;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.CourseMapper;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseChapter;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.CourseWare;
import com.yunzhi.edu.web.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseT {

	@Autowired
	private CourseMapper courseDao;
	
	@Autowired
	private CourseService courseService;
	
	public TestCourseT(){	
	}
	
//	@Test
//	public void TestInsertSelective(){
//		List<Course> courses = new ArrayList<Course>();
//		
//		Course c1 = new Course();
//		Course c2 = new Course();
//		Course c3 = new Course();
//		c1.setOrgCode("10002");
//		c1.setTitle("了快速分解");
//		c1.setCourseId(System.currentTimeMillis()+"");
//		c1.setScore((byte) 5);
//		c2.setOrgCode("10002");
//		c2.setTitle("毛血旺");
//		c2.setCourseId(System.currentTimeMillis()+"");
//		c2.setExamFinal((short) 80);
//		c2.setExamUsual((short) 20);
//		c3.setOrgCode("10150");
//		c3.setCourseId(System.currentTimeMillis()+"");
//		c3.setDescription("知识小讲堂");
//		c3.setTags("人工智能");
//		
//		courses.add(c1);
//		courses.add(c2);
//		courses.add(c3);
//		
//		try{
//			for(int k = 0; k<courses.size();k++){
//				courseDao.insertSelective(courses.get(k));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void TestSelectSelective(){
//		try{
//			Course course = new Course();
//			course.setTitle("第一课");
//			course.setIsPublic(false);
//			List<PackCourse> courses = courseDao.listCourseSelective(course);
//			for(Course cou: courses){
//				System.out.println(cou.toString());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void TestDelete(){
//		try{
//			int k = courseDao.deleteByPrimaryKey((long) 4);
//			System.out.println(k);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void TestList(){
		try{
			Course course = (Course) courseService.getCourse ((long) 6);
			System.out.println(course.toString());
			if(null != course.getChapters()){
				for(CourseChapter chapter:course.getChapters()){
					System.out.println("--"+chapter.toString());
					if(null != chapter.getCoursewares()){
						for(CourseWare courseware: chapter.getCoursewares()){
							System.out.println("----"+courseware.toString());
						}
					}
					if(null != chapter.getExams()){
						for(CourseChapterExam exam: chapter.getExams()){
							System.out.println("----"+exam.toString());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
