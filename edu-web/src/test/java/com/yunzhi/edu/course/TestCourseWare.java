package com.yunzhi.edu.course;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.CourseWareMapper;
import com.yunzhi.edu.entity.CourseWare;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseWare {
	
	@Autowired
	private CourseWareMapper coursewareDao;
	
	public TestCourseWare(){}
	
//	@Test
	public void TestSelect(){
		CourseWare courseware = new CourseWare();
		courseware.setCourseId("1522243682385"); ;
		List<CourseWare> coursewares = coursewareDao.listCourseWareList(courseware);
		for(CourseWare c:coursewares){
			System.out.println(c.toString());
		}
	}
	
//	@Test
//	public void TestInsert(){
//		List<CourseWare> coursewares = new ArrayList<CourseWare>();
//		CourseWare c1 = new CourseWare();
//		CourseWare c2 = new CourseWare();
//		CourseWare c3 = new CourseWare();
//		
//		c1.setCourseId("1522243682385");
//		c1.setChapterId(1);
//		c1.setCoursewareId(0);
//		c1.setCoursewareName("视频1");
//		c1.setLocation((short) 1);
//		c1.setMediaUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522077149243&di=3061090bc2f8892c8fcd60102ce1db28&imgtype=0&src=http%3A%2F%2Fa1.jikexueyuan.com%2Fhome%2F201511%2F26%2F3da8%2F56566904134c8.jpg");
//		
//		c2.setCourseId("1522243682385");
//		c2.setChapterId(1);
//		c2.setCoursewareId(1);
//		c2.setCoursewareName("视频2");
//		c2.setLocation((short) 2);
//		c2.setMediaUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522077149243&di=3061090bc2f8892c8fcd60102ce1db28&imgtype=0&src=http%3A%2F%2Fa1.jikexueyuan.com%2Fhome%2F201511%2F26%2F3da8%2F56566904134c8.jpg");
//		
//		c3.setCourseId("1522243682385");
//		c3.setChapterId(1);
//		c3.setCoursewareId(2);
//		c3.setCoursewareName("视频3");
//		c3.setLocation((short) 3);
//		c3.setMediaUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522077149243&di=3061090bc2f8892c8fcd60102ce1db28&imgtype=0&src=http%3A%2F%2Fa1.jikexueyuan.com%2Fhome%2F201511%2F26%2F3da8%2F56566904134c8.jpg");
//		
//		coursewares.add(c1);
//		coursewares.add(c2);
//		coursewares.add(c3);
//	
//		for(CourseWare courseware: coursewares){
//			coursewareDao.insertSelective(courseware);
//		}
//	}

}
