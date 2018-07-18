package com.yunzhi.edu.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yunzhi.edu.entity.SchoolClass;
import com.yunzhi.edu.entity.SchoolDepartment;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.service.SchoolManagerGroupsService;

@Controller
@RequestMapping(value = "/school/manager/groups")
public class SchoolGroupsController extends BaseController {

	@Autowired
	private SchoolManagerGroupsService schoolManagerGroupsService;
	
	Gson gson = new Gson();
	
//	@RequiresRoles(value={"admin"})
	@RequestMapping(value="/list/department/{orgCode}", produces="application/json;charset=utf-8")
	public @ResponseBody String listDepartment(@PathVariable("orgCode")String orgCode){
		
		List<SchoolDepartment> departmentList = schoolManagerGroupsService.listDepartment(orgCode);
		
		return ReMap.ResultMap(0, "请求成功", departmentList);
	}
	
	@RequestMapping(value="/insert/department", produces="application/json;charset=utf-8")
	public @ResponseBody String insertDepartment(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		SchoolDepartment department = gson.fromJson(json, SchoolDepartment.class);
				
		int k = schoolManagerGroupsService.insertDepartment(department);
		
		if(k != 0){
			return ReMap.ResultMap(0, "插入成功", null);
		}
		else{
			return ReMap.ResultMap(0, "插入成功", null);
		}
	}
	
	@RequestMapping(value="/list/schoolclass", produces="application/json;charset=utf-8")
	public @ResponseBody String listSchoolClass(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		try{
			SchoolClass schoolClass = gson.fromJson(json, SchoolClass.class);
			
			List<SchoolClass> schoolClassList = schoolManagerGroupsService.listSchoolClass(schoolClass);
			
			return ReMap.ResultMap(0, "请求成功", schoolClassList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ReMap.ResultMap(1, "请求出错", null);
		
	}
	
	@RequestMapping(value="/insert/schoolclass", produces="application/json;charset=utf-8")
	public @ResponseBody String insertSchoolClass(HttpServletRequest req){
		
		String json = ExtractJsonString.extractJson(req);
		
		SchoolClass schoolClass = gson.fromJson(json, SchoolClass.class);
		
		int k = schoolManagerGroupsService.insertSchoolClass(schoolClass);
		
		if(k != 0){
			return ReMap.ResultMap(0, "插入成功", null);
		}
		else{
			return ReMap.ResultMap(0, "插入成功", null);
		}
	}
}
