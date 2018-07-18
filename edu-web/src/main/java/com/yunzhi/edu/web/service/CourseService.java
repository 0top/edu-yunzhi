package com.yunzhi.edu.web.service;

import java.util.List;
import java.util.Map;

import com.yunzhi.edu.domain.ExamAnswer;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseChapter;
import com.yunzhi.edu.entity.CourseWare;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.web.exception.UnknowSystemException;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.CourseComment;
import com.yunzhi.edu.entity.CourseFile;
import com.yunzhi.edu.entity.CourseQA;

public interface CourseService {
	
	
	/*************************
	 * 
	 * 课程操作
	 *
	 *************************/
	public int insertCourse(Course course) throws Exception;
	
	public int insertCourseList(List<Course> courseList) throws Exception;
	
	public List<Course> listCourseList(Course course);
	
	public Course getCourse(Long id);
	
	public int deleteCourseById(Long id);
	
	/*************************
	 * 
	 * 课程章节操作
	 *
	 *************************/
	public List<CourseChapter> insertCourseChapterList(List<CourseChapter> chapters);
	
	public List<CourseChapter> listCourseChapterList(CourseChapter chapter);
	
	public CourseChapter getCourseChapterById(Long id);
	
	/*************************
	 * 
	 * 课程课件操作
	 *
	 *************************/
	public int insertCourseWareList(List<CourseWare> coursewares);
	
	public List<CourseWare> listCourseWareList(CourseWare courseware);
	
	public int deleteCourseWareById(long id);
	
	/*************************
	 * 
	 * 课程考试
	 *
	 *************************/
	public int insertCourseChapterExam(CourseChapterExam exam);
	
	public CourseChapterExam getCourseChapterExamById(Long id);
	
	public List<CourseChapterExam> listCourseChapterExam(CourseChapterExam exam);
	
	public int updateExam(CourseChapterExam exam);
	
	public Map<String, Object> commitCapterExam(Long id, String userId, String courseId ,List<ExamAnswer> answerlist)  throws UnknowSystemException ;
	

	
	/*************************
	 * 
	 * 课程答疑
	 *
	 *************************/
	public List<CourseQA> listCourseQA(CourseQA qa);
	
	public int insertCourseQA(CourseQA qa);
	
	public int updateCourseQA(CourseQA qa);
	
	/*************************
	 * 
	 * 课程资料操作
	 *
	 *************************/
	public int insertCourseFile(CourseFile file);
	
	public int insertCourseFileList(List<CourseFile>  fileList);

	
	
	/*************************
	 * 
	 * 课程操作-----------用户
	 *
	 *************************/
	public int updateUserCourse(UserCourse userCourse);
	
	public UserCourse getUserCourse(String userId, String courseId);
	
	public List<UserCourse> listUserCourse(String userId);
	
	public UserCourse insertUserCourse(UserCourse userCourse);
	
	public List<Course> listUserHasSelectedCourse(String userId);
	
	
	/*************************
	 * 
	 * 课程评论
	 *
	 *************************/
	public int insertCourseComment(CourseComment comment);
	
	public List<CourseComment> listCourseComment(CourseComment comment);
	
}
