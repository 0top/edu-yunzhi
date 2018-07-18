package com.yunzhi.edu.course;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.CourseChapterMapper;
import com.yunzhi.edu.entity.CourseChapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestCourseChapter {

	@Autowired
	private CourseChapterMapper courseChapterDao;

	public TestCourseChapter() {
	}

	@Test
	public void TestSelectCourseChapter() {

		CourseChapter chapter = new CourseChapter();
//		chapter.setChapterName("期末考核");
		chapter.setCourseId("1522243682385");

		try {
			List<CourseChapter> chapters = courseChapterDao.listChapterSelective(chapter.getCourseId());
			if (null != chapters && chapters.size() != 0) {
				for (CourseChapter cha : chapters) {
					System.out.println(cha.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	// public void TestInsertCourseChapter() {
	// List<CourseChapter> chapters = new ArrayList<CourseChapter>();
	//
	// CourseChapter c1 = new CourseChapter();
	// CourseChapter c2 = new CourseChapter();
	// CourseChapter c3 = new CourseChapter();
	// c1.setChapterId(1);
	// c1.setCourseId("1522243682385");
	// c1.setChapterName("第一章：起源");
	// c2.setChapterId(2);
	// c2.setCourseId("1522243682385");
	// c2.setChapterName("第二章：进化");
	// c3.setChapterId(3);
	// c3.setCourseId("1522243682385");
	// c3.setChapterName("第三章：智人");
	// c3.setLocation((short) 2);
	//
	// chapters.add(c1);
	// chapters.add(c2);
	// chapters.add(c3);
	//
	// try {
	// courseChapterDao.insertChapterListSelective(chapters);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
