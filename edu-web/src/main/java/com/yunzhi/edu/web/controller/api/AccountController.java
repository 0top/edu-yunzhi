package com.yunzhi.edu.web.controller.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.util.EncryptUtil;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.LoginType;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.exception.PhoneNumHasUsedException;
import com.yunzhi.edu.web.realm.CustomToken;
import com.yunzhi.edu.web.service.CourseService;
import com.yunzhi.edu.web.service.SchoolManagerStaffService;
import com.yunzhi.edu.web.service.SchoolService;
import com.yunzhi.edu.web.service.TeacherService;
import com.yunzhi.edu.web.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private SchoolService schoolService;
	 
	 @Autowired
	 private CourseService courseService;
	 
	 @Autowired
	 private TeacherService teacherService;
	 
	 @Autowired
	 private SchoolManagerStaffService schoolManagerService;
	 
	 Gson gson = new Gson();	
	 
	@RequestMapping(value = "/user/check", produces="application/json;charset=utf-8")
	public @ResponseBody String checkCurrentUser(){

		Map<String, Object> map = new HashMap<String, Object>();
		
		if(null != SecurityUtils.getSubject().getSession().getAttribute("user")){
			
			Subject subject = SecurityUtils.getSubject();
			User cuser = (User)subject.getSession().getAttribute("user");
			if(null != subject.getSession().getAttribute("roleName")){
				map.put("user", cuser);
				List<UserCourse> courselist = courseService.listUserCourse(cuser.getUserId());
				map.put("usercourse", courselist);
				if(subject.getSession().getAttribute("roleName").equals("student")){
					School school = schoolService.getSchoolDetail(cuser.getOrgCode());
					SecurityUtils.getSubject().getSession().setAttribute("school", school);	
					map.put("school", subject.getSession().getAttribute("school"));
					SchoolStudent student = new SchoolStudent();
					student.setOrgCode(cuser.getOrgCode());
					student.setStaffNum(cuser.getStaffNum());
					student = schoolManagerService.getSchoolStudent(student);
					map.put("student", student);
				}
				
				return ReMap.ResultMap(0, "已有登录用户", map);
			}
			
		}
		return ReMap.ResultMap(1, "无登录用户", null);
	}
	 
	@RequestMapping(value = "/user/register", produces="application/json;charset=utf-8")
	public @ResponseBody String userRegister(HttpServletRequest req){
		 
		String json = ExtractJsonString.extractJson(req);
		
		User user = gson.fromJson(json, User.class); 
		//验证是否是未注册手机号
		try{
			userService.insertUser(user);
			return ReMap.ResultMap(0, "注册成功", null);
		}catch(PhoneNumHasUsedException phe){
			return ReMap.ResultMap(1, phe.getMessage(), null);
		}
		catch(Exception e){
			System.out.println("注册失败");
			return ReMap.ResultMap(1, "注册成功", null);
		}
		 
		
	}
	
	@RequestMapping(value = "/user/login", produces="application/json;charset=utf-8")
    public @ResponseBody String login(HttpServletRequest req) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Subject subject = SecurityUtils.getSubject();

		String json = ExtractJsonString.extractJson(req);
		User user = gson.fromJson(json, User.class);
		if(null == user){
			return ReMap.ResultMap(1, "未正确填写信息", null);
		}
		User tempuser = (User)subject.getSession().getAttribute("user");
		if(null != tempuser&& tempuser.getPhonenum().equals(user.getPhonenum())){
			
			User cuser = (User)subject.getSession().getAttribute("user");
			if(null != subject.getSession().getAttribute("roleName")){
				map.put("user", subject.getSession().getAttribute("user"));
				List<UserCourse> courselist = courseService.listUserCourse(cuser.getUserId());
				map.put("usercourse", courselist);
				
				if(cuser.getRoleName().equals("student")){
					
					School school = schoolService.getSchoolDetail(cuser.getOrgCode());
					
					SchoolStudent student = new SchoolStudent();
					student.setOrgCode(cuser.getOrgCode());
					student.setStaffNum(cuser.getStaffNum());
					student = schoolManagerService.getSchoolStudent(student);
					
					map.put("school", school);
					map.put("student", student);
				}
				
				return ReMap.ResultMap(0, "当前用已登录", map);
			}
		}

		String password = user.getPassword();
		
		if(null != user.getStaffNum()&&!user.getStaffNum().equals("")){
			user = userService.findUserByStaffNum(user.getStaffNum());
			if(null==user){
				return ReMap.ResultMap(1, "无当前学生存在", null);
			}
		}		
        
        try {
        	CustomToken token = new CustomToken(user.getPhonenum(), password, LoginType.USER.toString());
        	token.setRememberMe(true);
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
        	return ReMap.ResultMap(1, "用户名或密码错误", null);
        } catch (UnknownAccountException uae) {
        	return ReMap.ResultMap(1, "用户名或密码错误", null);
        } catch (ExcessiveAttemptsException eae) {
        	return ReMap.ResultMap(1, "请稍后尝试", null);
        }
        User currentUser = userService.findUserByPhoneNum(user.getPhonenum());
        subject.getSession().setAttribute("user", currentUser);
        subject.getSession().setAttribute("roleName", currentUser.getRoleName());
        
        List<UserCourse> courses = courseService.listUserCourse(currentUser.getUserId());
		subject.getSession().setAttribute("usercourse", courses);
		
		
		
		if(currentUser.getRoleName().equals("student")){
			
			School school = schoolService.getSchoolDetail(currentUser.getOrgCode());
			subject.getSession().setAttribute("school", school);
			
			SchoolStudent student = new SchoolStudent();
			student.setOrgCode(currentUser.getOrgCode());
			student.setStaffNum(currentUser.getStaffNum());
			student = schoolManagerService.getSchoolStudent(student);
			subject.getSession().setAttribute("student", student);
			
			map.put("school", school);
			map.put("student", student);
		}
		
		map.put("user", currentUser);
		map.put("usercourse", courses);
			
        return ReMap.ResultMap(0, "登录成功", map);
    }
	
	@RequestMapping(value = "/teacher/check", produces="application/json;charset=utf-8")
	public @ResponseBody String checkCurrentTeacher(){
		
		if(null != SecurityUtils.getSubject().getSession().getAttribute("user")){
			
			Subject subject = SecurityUtils.getSubject();
			SchoolTeacher teacher = (SchoolTeacher)subject.getSession().getAttribute("user");
			if(null != teacher){	
				return ReMap.ResultMap(0, "已有登录用户", teacher);
			}
		}
		return ReMap.ResultMap(1, "无登录用户", null);
	}
	
	@RequestMapping(value = "/teacher/login", produces="application/json;charset=utf-8")
	public @ResponseBody String teacherLogin(HttpServletRequest req){
				
		Subject subject = SecurityUtils.getSubject();
		
		String json = ExtractJsonString.extractJson(req);
		SchoolTeacher teacher = gson.fromJson(json, SchoolTeacher.class);
		
		if(null == teacher){
			return ReMap.ResultMap(1, "未正确填写信息", null);
		}
		subject.getSession().setAttribute("orgCode", teacher.getOrgCode());
		
		SchoolTeacher tempteacher = (SchoolTeacher)subject.getSession().getAttribute("user");
		
		if(null != tempteacher){
			System.out.println(" has exist teacher--");
			
			SchoolTeacher tteacher = teacherService.selectByStaffNumAuthentication(teacher.getStaffNum(), teacher.getOrgCode())   ;
			if(null == tteacher){
				return ReMap.ResultMap(1, "用户名或密码错误", null);
			}

			if(tempteacher.getStaffNum().equals(tteacher.getStaffNum())&&
					tempteacher.getOrgCode().equals(tteacher.getOrgCode())){
				return ReMap.ResultMap(0, "该用户已登录", gson.toJson(tempteacher));
			}
		}
		
        CustomToken token = new CustomToken(teacher.getStaffNum(), teacher.getPassword(),LoginType.TEACHER.toString());
        
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
        	return ReMap.ResultMap(1, "用户名或密码错误", null);
        } catch (UnknownAccountException uae) {
        	return ReMap.ResultMap(1, "用户名或密码错误", null);
        } catch (ExcessiveAttemptsException eae) {
        	return ReMap.ResultMap(1, "请稍后尝试", null);
        }
        
        SchoolTeacher fteacher =  teacherService.findTeacherByStaffNum(teacher.getStaffNum());
        System.out.println(" -- session teacher --"+fteacher.toString());
        subject.getSession().setAttribute("user", fteacher);
        subject.getSession().setAttribute("roleName", "teacher");
        
        return ReMap.ResultMap(0, "登录成功", gson.toJson(fteacher));
		
	}
	
	
	@RequiresRoles(value={"user","student","teacher","admin"}, logical=Logical.OR)
	@RequestMapping(value = "/logout", produces="application/json;charset=utf-8")
	public @ResponseBody String  loginout(HttpServletRequest req) {
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		return ReMap.ResultMap(0, "登出成功", null);
	}
	
	@RequestMapping(value = "error")
	public String error(){
		return "error";
	}
	
	
}
