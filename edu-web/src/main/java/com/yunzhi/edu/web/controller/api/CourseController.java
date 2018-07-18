package com.yunzhi.edu.web.controller.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.yunzhi.edu.domain.ExamAnswer;
import com.yunzhi.edu.domain.ExamQuestion;
import com.yunzhi.edu.domain.UserCourseDetail;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseChapter;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.CourseComment;
import com.yunzhi.edu.entity.CourseFile;
import com.yunzhi.edu.entity.CourseQA;
import com.yunzhi.edu.entity.CourseWare;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.service.CourseService;
import com.yunzhi.edu.web.service.CourseUpdateService;

@Controller
@RequestMapping(value = "/course")
public class CourseController  extends BaseController{
	
	@Autowired
	private CourseUpdateService courseUpdateService;

	@Autowired
	private CourseService courseService;
	
	Gson gson = new Gson();
	
	@RequestMapping(value = "/insert/usercourse", produces="application/json;charset=utf-8")
	public @ResponseBody String sdCourse(HttpServletRequest req){
		
		try{
			UserCourse usercourse= new UserCourse();
			usercourse.setCourseId("1522243682385");
			courseUpdateService.createUserCourse(usercourse);
			return ReMap.ResultMap(0, "请求成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}
	
//	添加课程--教务添加
//	@RequiresRoles(value={"teahcer","admin"}, logical=Logical.OR)
	@RequestMapping(value = "/insert/course", produces="application/json;charset=utf-8")
	public @ResponseBody String insertCourse(HttpServletRequest req){
		Course cou = new Course();
		
		try{
			String json = ExtractJsonString.extractJson(req);
			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("course");
			
			for (JsonElement course : jsonArray) {				
				cou = gson.fromJson(course, new TypeToken<Course>() {}.getType());
				System.out.println("cou :"+cou.toString());
			}
			courseService.insertCourse(cou);
			return ReMap.ResultMap(0, "请求成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}
	
//	根据条件 -- 列出course
	@RequestMapping(value = "/list/courses", produces="application/json;charset=utf-8")
	public @ResponseBody String listCourse(HttpServletRequest req){
		List<Course> courses = new ArrayList<Course>();
		try{
			String json = ExtractJsonString.extractJson(req);
			Course course = gson.fromJson(json, Course.class);
			
			System.out.println(" COURSE "+course.toString());
			
			courses = courseService.listCourseList(course);	
			return ReMap.ResultMap(0, "请求成功", courses);
		}catch(Exception e){
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}
	
//	@RequiresRoles(value={"user","student","teahcer","admin"}, logical=Logical.OR)
	@RequestMapping(value = "/get/course/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String getCourseById(HttpServletRequest req,
			@PathVariable("id") Long id){
		try{
			
			Course course = courseService.getCourse(id);
			
//			Subject subject = SecurityUtils.getSubject();
//			User cuser = (User)subject.getSession().getAttribute("user");
//			if(null == cuser){
//				return ReMap.ResultMap(0, "当前无用户", null);
//			}
//			UserCourse userCourse = courseService.getUserCourse(cuser.getUserId(), course.getCourseId());
//			if(null == userCourse){
//				userCourse = new UserCourse();
//				userCourse.setCourseId(course.getCourseId());
//				userCourse.setUserId(cuser.getUserId());
//				courseService.insertUserCourse(userCourse);
//			}
			
			return ReMap.ResultMap(0, "请求成功", course);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	删除课程  是否需要删除课程
//	@RequiresRoles("admin")
	@RequestMapping(value = "/delete/course/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String deleteCourseById(HttpServletRequest req,
			@PathVariable("id") Long id){
		
//		courseService.deleteCourseById(id);
		
		return ReMap.ResultMap(1, "暂不支持删除整个课程", null);
	}
	
//	批量添加课程章节信息
//	@RequiresRoles(value={"teacher"})
	@RequestMapping(value = "/insert/chapter",produces="application/json;charset=utf-8")
	public @ResponseBody String insertChapters(HttpServletRequest req){
		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		CourseChapter chapter = new CourseChapter();
		try{
			String json = ExtractJsonString.extractJson(req);
			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("chapters");
			
			for (JsonElement c : jsonArray) {				
				chapter = gson.fromJson(c, new TypeToken<CourseChapter>() {}.getType());
				chapters.add(chapter);
			}
			
			courseService.insertCourseChapterList(chapters);	
			
			return ReMap.ResultMap(0, "请求成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}	
	}
	
//	列出所有章节-----传参？传对象？
	@RequestMapping(value = "/list/chapter", produces="application/json;charset=utf-8")
	public @ResponseBody String listChapters(HttpServletRequest req){
		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		CourseChapter chapter = new CourseChapter();
		try{
			String json = ExtractJsonString.extractJson(req);
			chapter = gson.fromJson(json, CourseChapter.class);
			
			chapters = courseService.listCourseChapterList(chapter);	
			
			return ReMap.ResultMap(0, "请求成功", chapters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	批量添加考试
	@RequestMapping(value = "/insert/exam", produces="application/json;charset=utf-8")
	public @ResponseBody String InsertChapterExams(HttpServletRequest req){
		
		CourseChapterExam exam = new CourseChapterExam();
		
		System.out.println("---------------insertExam----------------------");
		
		try{
			String json = ExtractJsonString.extractJson(req);
						
			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("exam");
			
			for (JsonElement c : jsonArray) {				
				exam = gson.fromJson(c, new TypeToken<CourseChapterExam>() {}.getType());
				System.out.println("exam: "+exam.toString());
			}
			System.out.println("------------------------------------------");
			
			com.google.gson.JsonArray questionArray = jsonObject.getAsJsonArray("questionlist");
			List<ExamQuestion> questionlist = new ArrayList<ExamQuestion>();
			for (JsonElement c : questionArray) {	
				ExamQuestion eq = gson.fromJson(c, new TypeToken<ExamQuestion>() {}.getType());
				eq.setAnswer("prepare");
				questionlist.add(eq);
				System.out.println(questionlist.toString());
			}
			
			System.out.println("------------------------------------------");
			
			List<ExamAnswer> answerlist = new ArrayList<ExamAnswer>();
			
			com.google.gson.JsonArray answerArray = jsonObject.getAsJsonArray("answerlist");
			for (JsonElement c : answerArray) {		
				ExamAnswer answer = new ExamAnswer();
				answer = gson.fromJson(c, ExamAnswer.class);
				answerlist.add(answer);
				
				System.out.println(answer.toString());
			}
			exam.setAnswer(gson.toJson(answerlist));
			exam.setContent(gson.toJson(questionlist));
			
			courseService.insertCourseChapterExam(exam);
			
			return ReMap.ResultMap(0, "请求成功", null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	/*
	@RequestMapping(value = "/insert/exam", produces="application/json;charset=utf-8")
	public @ResponseBody String InsertChapterExam(HttpServletRequest req){		
		try{
			String json = ExtractJsonString.extractJson(req);
			CourseChapterExam exam = gson.fromJson(json, CourseChapterExam.class);			
			courseService.insertCourseChapterExam(exam);			
			return ReMap.ResultMap(0, "请求成功", null);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}*/
	
	@RequestMapping(value = "/update/exam", produces="application/json;charset=utf-8")
	public @ResponseBody String InsertChapterExam(HttpServletRequest req){		
		try{
			String json = ExtractJsonString.extractJson(req);
			CourseChapterExam exam = gson.fromJson(json, CourseChapterExam.class);
		
			System.out.println(exam.toString());
			
	////		courseService.updateExam(exam);			
			return ReMap.ResultMap(0, "请求成功", null);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	@RequiresRoles(value = {"student", "user", "teacher", "admin"}, logical=Logical.OR)
	@RequestMapping(value = "/get/exam/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String getChapterById(HttpServletRequest req,
			@PathVariable("id") Long id){
		
		try{
			CourseChapterExam exam = courseService.getCourseChapterExamById(id);
//			if(SecurityUtils.getSubject().getSession().getAttribute("roleName").equals("student")
//					||SecurityUtils.getSubject().getSession().getAttribute("roleName").equals("user")){
//				exam.setAnswer("");
//			}
			
			return ReMap.ResultMap(0, "请求成功", exam);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	操作课件
//	@RequiresRoles(value={"teacher"})
	@RequestMapping(value = "/insert/courseware", produces="application/json;charset=utf-8")
	public @ResponseBody String insertCourseware(HttpServletRequest req){
		List<CourseWare> coursewares = new ArrayList<CourseWare>();
		CourseWare courseware = new CourseWare();
		String json = ExtractJsonString.extractJson(req);
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("courseware");
		
		try{
			for (JsonElement c : jsonArray) {		
				courseware = gson.fromJson(c, new TypeToken<CourseWare>() {}.getType());
				coursewares.add(courseware);
			}
			if(coursewares.size() >= 0)
				courseService.insertCourseWareList(coursewares);
			return ReMap.ResultMap(0, "请求成功", null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	@RequiresRoles(value = {"teacher"})
	@RequestMapping(value = "/delete/courseware/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String deleteCourseWareById(@PathVariable("id")long id){
		
		courseService.deleteCourseWareById(id);
		
		return ReMap.ResultMap(0, "删除成功", null);
		
	}
	

	@RequestMapping(value = "/list/courseware/{courseId}", produces="application/json;charset=utf-8")
	public @ResponseBody String listCourseware(HttpServletRequest req,
			@PathVariable("courseId") String courseId){
		try{
			CourseWare courseware = new CourseWare();
			courseware.setCourseId(courseId);
			List<CourseWare> coursewares = courseService.listCourseWareList(courseware);
			
			return ReMap.ResultMap(0, "请求成功", coursewares);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequestMapping(value = "/list/coursecomment/{courseId}", produces="application/json;charset=utf-8")
	public @ResponseBody String listCoursecomment(HttpServletRequest req,
			@PathVariable("courseId") String courseId){
		try{
			CourseComment comment = new CourseComment();
			comment.setCourseId(courseId);
			List<CourseComment> coursecomment = courseService.listCourseComment(comment);
			
			return ReMap.ResultMap(0, "请求成功", coursecomment);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	操作课件
	@RequestMapping(value = "/insert/coursecomment", produces="application/json;charset=utf-8")
	public @ResponseBody String insertCourseComment(HttpServletRequest req){
		
		try{
			String json = ExtractJsonString.extractJson(req);
			CourseComment comment = gson.fromJson(json, CourseComment.class);
			comment.setCreateTime(new Date());
			
			courseService.insertCourseComment(comment) ;
			
			return ReMap.ResultMap(0, "请求成功", null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequestMapping(value = "/list/course/qa/{courseId}", produces="application/json;charset=utf-8")
	public @ResponseBody String listCourseQA(HttpServletRequest req,
			@PathVariable("courseId") String courseId){
		try{
			CourseQA qa = new CourseQA();
			qa.setCourseId(courseId);
			List<CourseQA> qas = courseService.listCourseQA(qa);
			
			return ReMap.ResultMap(0, "请求成功", qas);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
//	操作课件
	@RequestMapping(value = "/insert/course/qa", produces="application/json;charset=utf-8")
	public @ResponseBody String insertCourseQA(HttpServletRequest req){
		
		try{
			String json = ExtractJsonString.extractJson(req);
			CourseQA qa = gson.fromJson(json, CourseQA.class);
			
			courseService.insertCourseQA(qa) ;
			
			return ReMap.ResultMap(0, "请求成功", null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequestMapping(value = "/insert/course/filelist", produces="application/json;charset=utf-8")
	public @ResponseBody String insertCourseFile(HttpServletRequest req){
		
		List<CourseFile> fileList = new ArrayList<CourseFile>();
		CourseFile coursefile = new CourseFile();
		String json = ExtractJsonString.extractJson(req);
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("fileList");
	
		try{
			for (JsonElement c : jsonArray) {		
				coursefile = gson.fromJson(c, new TypeToken<CourseFile>() {}.getType());
				fileList.add(coursefile);
			}
			if(fileList.size() >= 0)
				courseService.insertCourseFileList(fileList);
			return ReMap.ResultMap(0, "上传成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
		
		
		
	}
	
}
