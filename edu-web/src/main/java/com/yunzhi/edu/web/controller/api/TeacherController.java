package com.yunzhi.edu.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yunzhi.edu.entity.CourseComment;
import com.yunzhi.edu.entity.CourseNotice;
import com.yunzhi.edu.entity.CourseQA;
import com.yunzhi.edu.entity.CourseTask;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.service.CourseService;
import com.yunzhi.edu.web.service.TeacherService;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController extends BaseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	Gson gson = new Gson();
	
	@RequestMapping(value = "/get/course/discussion/{courseId}", produces="application/json;charset=utf-8")
	public @ResponseBody String getCourseDiscussionByCourseId(@PathVariable("courseId")String courseId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		CourseComment comment = new CourseComment();
		comment.getCourseId();
		List<CourseComment> commentlist = courseService.listCourseComment(comment); 
		map.put("comment", commentlist);
		
		CourseQA qa = new CourseQA();
		qa.setCourseId(courseId);
		List<CourseQA> qalist = courseService.listCourseQA(qa);
		map.put("qa", qalist);
		
		return ReMap.ResultMap(0, "请求成功", map);
	}
	
	@RequestMapping(value = "/deploy/task", produces = "application/json;charset=utf-8")
	public @ResponseBody String deployTask(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		CourseTask task = gson.fromJson(json, CourseTask.class);
		
		teacherService.insertTask(task);
		
		return ReMap.ResultMap(0, "请求成功", null);
	}
	
	@RequestMapping(value = "/list/task/teacherId={teacherId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String listTask(HttpServletRequest req,
			@PathVariable("teacherId")String teacherId){
		
		List<CourseTask> tasklist = teacherService.listCourseTask(teacherId);
		
		
		return ReMap.ResultMap(0, "请求成功", tasklist);
		
	}
	
	@RequestMapping(value = "/delete/task/{id}", produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteTaskById(@PathVariable("id")long id){
		
		teacherService.deleteTask(id);
		
		
		return ReMap.ResultMap(0, "请求成功", null);
		
	}
	
	@RequestMapping(value = "/deploy/course/notice", produces = "application/json;charset=utf-8")
	public @ResponseBody String deployCourseNotice(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		CourseNotice coursenotice = gson.fromJson(json, CourseNotice.class);
		
		teacherService.insertCourseNotice(coursenotice);
		
		return ReMap.ResultMap(0, "请求成功", null);
	}
	
	@RequestMapping(value = "/list/course/notice/{courseId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String listCourseNoticeBycourseId(@PathVariable("courseId")String courseId){
		
		List<CourseNotice> noticelist = teacherService.listCourseNotice(courseId);
		
		return ReMap.ResultMap(0, "请求成功", noticelist);
		
	}
	@RequestMapping(value = "/delete/course/notice/{id}", produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteCourseNoticeById(@PathVariable("id")long id){
		
		teacherService.deleteCourseNoticeById(id);
		
		return ReMap.ResultMap(0, "请求成功", null);
		
	}
}
