package com.yunzhi.edu.web.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.web.service.SchoolManagerStaffService;

@Controller
@RequestMapping(value = "/school/manager/staff")
public class SchoolStaffController extends BaseController {

	@Autowired
	private SchoolManagerStaffService schoolManagerStaffService;
	
	
	
	Map<String, Object> result = new HashMap<String, Object>();
	
	Gson gson = new Gson();
	
//	@RequiresRoles({"admin"})
	@RequestMapping(value = "/list/teacher/{orgCode}", produces="application/json;charset=utf-8")
	public @ResponseBody String listTeacher(HttpServletRequest req,
			@PathVariable("orgCode") String orgCode){
		SchoolTeacher teacher = new SchoolTeacher();
		teacher.setOrgCode(orgCode);
		List<SchoolTeacher> teacherList = schoolManagerStaffService.listSchoolTeacher(teacher);
		
		return ReMap.ResultMap(0, "请求成功", teacherList);
		
	}

//	@RequiresRoles({"admin"})
	@RequestMapping(value = "/insert/student", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addStudent(HttpServletRequest req) {
		
		String json = ExtractJsonString.extractJson(req);

		try {
			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			com.google.gson.JsonArray jsonArray = jsonObject.getAsJsonArray("student");
			ArrayList<SchoolStudent> students = new ArrayList<SchoolStudent>();

			for (JsonElement student : jsonArray) {
				SchoolStudent stu = gson.fromJson(student, new TypeToken<SchoolStudent>() {
				}.getType());
				stu.setStarttime(stu.getStarttime());
				stu.setEndtime(stu.getEndtime());
				students.add(stu);
				
				System.out.println(stu.toString());
			}

			schoolManagerStaffService.insertSchoolStudent(students);
			return ReMap.ResultMap(0, "请求成功", null);

		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

//	@RequiresRoles(value={"user","admin"},logical=Logical.OR)
	@RequestMapping(value = "/list/student", produces = "application/json;charset=utf-8")
	public @ResponseBody String getStudents(HttpServletRequest req) {
		// 身份验证---获取院校信息
		String json = ExtractJsonString.extractJson(req);		
		SchoolStudent student = gson.fromJson(json, SchoolStudent.class);
		
		try {
			if(null == student){
				System.out.println("请求对象为空--");
				
			}else{
				List<SchoolStudent> students = schoolManagerStaffService.listSchoolStudent(student);
				
				return ReMap.ResultMap(0, "请求成功", students);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequestMapping(value = "/get/student/{id}", produces = "application/json;charset=utf-8")
	public @ResponseBody String getStudentById(@PathVariable("id")long id){
		
		
		SchoolStudent student = new SchoolStudent();
		student.setId(id);
		try{
			student = schoolManagerStaffService.getSchoolStudent(student);
		}catch(Exception e){
			return ReMap.ResultMap(1, "请求失败", null);
		}
		return ReMap.ResultMap(0, "请求成功", student);
		
		
	}

//	@RequiresRoles("admin")
	@RequestMapping(value = "/update/student", produces = "application/json;charset=utf-8")
	public @ResponseBody String updateStudent(HttpServletRequest req) {
		// 身份验证---获取院校信息
		
		try {
			String json = ExtractJsonString.extractJson(req);
			SchoolStudent student = gson.fromJson(json, SchoolStudent.class);
			
			int k = schoolManagerStaffService.updateSchoolStudent(student);
			return ReMap.ResultMap(0, "请求成功", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
}
