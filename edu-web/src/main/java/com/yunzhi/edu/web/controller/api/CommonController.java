package com.yunzhi.edu.web.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.yunzhi.edu.core.Upload;

import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.service.ArticleService;
import com.yunzhi.edu.web.service.CommonService;
import com.yunzhi.edu.web.service.SchoolService;


@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController{

	@Autowired
	private CommonService commonService; 
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private ArticleService articleService;
	
	Gson gson = new Gson();
	
	@RequestMapping(value = "/list/school", produces = "application/json;charset=utf-8")
	public @ResponseBody String updateStudent() {
		// 身份验证---获取院校信息
		
		try {
			List<School> schools = schoolService.listAllSchoolBase();
			return ReMap.ResultMap(0, "请求成功", schools);
		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}
//	@RequiresRoles(value={"user","student","teacher","admin"}, logical=Logical.OR)
	@RequestMapping(value = "/upload/image", produces="application/json;charset=utf-8")
	public @ResponseBody String upload(@RequestParam(required = false) MultipartFile file){
		
		List<String> imgurl = new ArrayList<String>();
		String url = "";
		try{
			url = Upload.uploadFile("image",file);
			imgurl.add(url);
			System.out.println(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(0, "上传成功", imgurl);

	}
	
	@RequestMapping(value = "/upload/file", produces="application/json;charset=utf-8")
	public @ResponseBody String uploadFile(@RequestParam(required = false) MultipartFile file){
				
		List<String> fileurl = new ArrayList<String>();
		String url = "";
		try{
			url = Upload.uploadFile("file",file);
			fileurl.add(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(0, "上传成功", fileurl);
	}
	
	@RequestMapping(value = "/upload/courseware", produces="application/json;charset=utf-8")
	public @ResponseBody String uploadCoursewar(@RequestParam(required = false) MultipartFile file){
		
		List<String> fileurl = new ArrayList<String>();
		String url = "";
		try{
			url = Upload.uploadFile("courseware",file);
			fileurl.add(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ReMap.ResultMap(0, "上传成功", fileurl);
	}
	
	
}
