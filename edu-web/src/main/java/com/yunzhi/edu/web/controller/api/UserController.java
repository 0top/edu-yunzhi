package com.yunzhi.edu.web.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
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
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.entity.UserNote;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.exception.NoSuchSchoolStudentException;
import com.yunzhi.edu.web.exception.UnknowSystemException;
import com.yunzhi.edu.web.exception.UserHasActivateException;
import com.yunzhi.edu.web.service.CourseService;
import com.yunzhi.edu.web.service.SchoolService;
import com.yunzhi.edu.web.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	Gson gson = new Gson();

	@Autowired
	private UserService userService;
	
	@Autowired
	 private SchoolService schoolService;
	
	@Autowired
	private CourseService courseService;
	
	@RequiresRoles(value={"user"})
	@RequestMapping(value = "activate/user", produces="application/json;charset=utf-8")
	public @ResponseBody String activateUser(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		SchoolStudent student = gson.fromJson(json, SchoolStudent.class);
		if(student.getOrgCode().equals("")||student.getRealName().equals("")||student.getStaffNum().equals("")){
			return ReMap.ResultMap(1, "信息不全", null);
		}
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		
		try{
			int k = userService.activateUser(student, user);
			if(k > 0){
				SecurityUtils.getSubject().getSession().setAttribute("roleName", "student");
				user.setOrgCode(student.getOrgCode());
				user.setStaffNum(student.getStaffNum());
				School school = schoolService.getSchoolDetail(user.getOrgCode());
				SecurityUtils.getSubject().getSession().setAttribute("school", school);
			
				SecurityUtils.getSubject().getSession().setAttribute("user", user);
			
				return ReMap.ResultMap(0, "绑定成功", null);
			}
		}catch(NoSuchSchoolStudentException nsse){
			return ReMap.ResultMap(1, nsse.getMessage(), null);
		}
		catch(UserHasActivateException uhae){
			return ReMap.ResultMap(1, uhae.getMessage(), null);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("用户绑定失败");
		}
		return ReMap.ResultMap(1, "请求失败", null);
		
	}
	
//	@RequiresRoles(value={"user","student","teahcer","admin"}, logical=Logical.OR)
	@RequestMapping(value = "/get/course/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String getCourseById(HttpServletRequest req,
			@PathVariable("id") Long id){
		try{
			
			Course course = courseService.getCourse(id);
			
			Subject subject = SecurityUtils.getSubject();
			User cuser = (User)subject.getSession().getAttribute("user");
			if(null == cuser){
				return ReMap.ResultMap(0, "当前无用户", null);
			}
			UserCourse userCourse = courseService.getUserCourse(cuser.getUserId(), course.getCourseId());
			if(null == userCourse){
				userCourse = new UserCourse();
				userCourse.setCourseId(course.getCourseId());
				userCourse.setUserId(cuser.getUserId());
				courseService.insertUserCourse(userCourse);
			}
			
			return ReMap.ResultMap(0, "请求成功", course);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	
	//获取用户所选择的课程
	@RequiresRoles(value={"user","student"},logical=Logical.OR)
	@RequestMapping(value = "/list/selected/course/{userId}", produces="application/json;charset=utf-8")
	public @ResponseBody String listSelectedCourse(@PathVariable("userId") String userId){
		
		try{
			List<Course> courselist = courseService.listUserHasSelectedCourse(userId);
			
			return ReMap.ResultMap(0, "获取成功", courselist);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequiresRoles(value={"user","student"},logical=Logical.OR)
	@RequestMapping(value = "/add/course", produces="application/json;charset=utf-8")
	public @ResponseBody String addUserCourse(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		UserCourse usercourse = gson.fromJson(json, UserCourse.class);
		try{
			usercourse = courseService.insertUserCourse(usercourse);
		}catch(Exception e){
			return ReMap.ResultMap(1, "请求失败", null);
		}
		return ReMap.ResultMap(0, "添课成功", usercourse);
	}
	
//	@RequestMapping(value = "/commit/exam", produces="application/json; charset=utf-8")
//	public @ResponseBody String commitExam(HttpServletRequest req){
//		
//		String json = ExtractJsonString.extractJson(req);
//		
//		UserCourse usercourse = gson.fromJson(json, UserCourse.class);
//		
//		
//		return ReMap.ResultMap(0, "添课成功", null);
//	}
	
	
	//获取用户笔记
//	@RequiresRoles(value={"user","student" ,"teacher"},logical=Logical.OR)
	@RequestMapping(value = "/list/note", produces="application/json;charset=utf-8")
	public @ResponseBody String listNote(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		User user = gson.fromJson(json, User.class);
		
		if(user != null){
			List<UserNote> notes = userService.listUserNote(user);
			if(null != notes){
				return ReMap.ResultMap(0, "请求成功", notes);
			}
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	
	@RequestMapping(value = "/insert/note", produces="application/json;charset=utf-8")
	public @ResponseBody String insertNote(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		UserNote userNote = gson.fromJson(json, UserNote.class);
				
		if(userNote != null){
			int k = userService.insertNote(userNote);
			if(k >= 0){
				return ReMap.ResultMap(0, "请求成功", null);
			}
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	
	@RequestMapping(value = "/commit/exam/{id}", produces="application/json;charset=utf-8")
	public @ResponseBody String commintExam(HttpServletRequest req,
			@PathVariable("id")Long id){
		CourseChapterExam exam = new CourseChapterExam();
		String json = ExtractJsonString.extractJson(req);
				
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		
		String userId = jsonObject.get("userId").getAsString() ;
		String courseId = jsonObject.get("courseId").getAsString();
		
		com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("answerlist");
//		List<String> answerlist = new ArrayList<String>();
		List<ExamAnswer> answerlist = new ArrayList<ExamAnswer>();
		for (JsonElement c : jsonArray) {				
			ExamAnswer ans = gson.fromJson(c, ExamAnswer.class);
			answerlist.add(ans);
			System.out.println(ans.toString());
		}
		try{
		    Map<String , Object> retmap = courseService.commitCapterExam( id, userId, courseId, answerlist);
		    return ReMap.ResultMap(0, "请求成功", retmap);
		}catch(UnknowSystemException e1){
			return ReMap.ResultMap(1, e1.getMessage(), null);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(1, "请求失败", null);
	}
}
