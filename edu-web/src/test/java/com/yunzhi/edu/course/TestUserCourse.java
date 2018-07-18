package com.yunzhi.edu.course;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.yunzhi.edu.domain.UserCourseChapterDetail;
import com.yunzhi.edu.domain.UserCourseDetail;
import com.yunzhi.edu.domain.UserCourseExamDetail;
import com.yunzhi.edu.domain.UserCourseWareDetail;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.web.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestUserCourse {

	@Autowired
	private CourseService courseService;
	
	public TestUserCourse(){}
	
//	@Test
	public void TestUpdate(){
		UserCourse usercourse = new UserCourse();
		
		usercourse = courseService.getUserCourse("3244", "1522243682385");
		
		 Gson gson = new Gson();
		 UserCourseDetail userCourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);
		 
		 for(UserCourseChapterDetail chapter: userCourseDetail.getChapters()){
			 for(UserCourseWareDetail courseware: chapter.getCoursewares()){
				 if(courseware.getId() == 2){
					 courseware.setSee(true);
					 int k = userCourseDetail.getCoursewareCount();
					 userCourseDetail.setCoursewareCount(k+1);
					 double percent = 1.0*userCourseDetail.getCoursewareCount()/userCourseDetail.getCoursewareSum();
					 usercourse.setEngagePercent(new BigDecimal(percent));
					 break;
				 }
			 }
			for(UserCourseExamDetail examdetail: chapter.getExams()){
				if(examdetail.getId()==2){
//					examdetail.setAns("A,B,C,D");
					examdetail.setCorrectSum(5);
					examdetail.setDone(true);
					examdetail.setScore(100);
					examdetail.setSum(10);
					int k =  userCourseDetail.getExamCount();
					userCourseDetail.setExamCount(k+1);
					double percent = 1.0*userCourseDetail.getExamCount()/userCourseDetail.getExamSum();
					usercourse.setExamPercent(new BigDecimal(percent));
					break;
				}
			}
		 }
		 usercourse.setDetail(gson.toJson(userCourseDetail));
		 
		 courseService.updateUserCourse(usercourse);
		
		 System.out.println(usercourse.toString()+"\n");
		 
		 userCourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);
		 
		 detailToString(userCourseDetail);
	}
	
//	@Test
	public void TestSelect(){
		UserCourse usercourse = new UserCourse();
		
		 usercourse = courseService.getUserCourse("3244", "1522243682385");
		 
		 System.out.println(usercourse.toString());
		 
		 Gson gson = new Gson();
		 UserCourseDetail userCourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);
		 
		detailToString(userCourseDetail);
		
		
		System.out.println(gson.toJson(usercourse.getDetail()));
	}
	
//	@Test
//	public void TestInsert(){
//		
//		UserCourse usercourse = new UserCourse();
//		usercourse.setCourseId("1522243682385");
//		usercourse.setUserId("3244");
//		try{
//			System.out.println(courseService.insertUserCourse(usercourse).toString());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	public static void detailToString(UserCourseDetail userCourseDetail){ 
		 
		System.out.println(userCourseDetail.toString());
		for(UserCourseChapterDetail chapter: userCourseDetail.getChapters()){
			System.out.println("--"+chapter.toString());
			for(UserCourseWareDetail courseware: chapter.getCoursewares()){
				System.out.println("----"+courseware.toString());
			}
			for(UserCourseExamDetail examdetail: chapter.getExams()){
				System.out.println("----"+examdetail.toString());
			}
		}
	}
}
