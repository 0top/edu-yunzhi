package com.yunzhi.edu.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yunzhi.edu.core.Upload;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolWithBLOBs;
import com.yunzhi.edu.web.service.CommonService;
import com.yunzhi.edu.web.service.PlatformAdminService;
import com.yunzhi.edu.web.service.SchoolService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private PlatformAdminService platformAdminService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = "/main.do")
	public ModelAndView main(){
		System.out.println("main");
		return new ModelAndView("main/main");
	}

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("start login--------"+username+"---"+password);
//		PlatformAdmin admin = platformAdminService.adminLogin(username, password);
//		if(null== admin){
//			System.out.println("user is null");
//		}
//        //UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//		req.getSession().setAttribute("admin", admin);
		
        return new ModelAndView("main/main");
	}
	
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest req,HttpServletResponse res){
		List<SchoolWithBLOBs> sds =  schoolService.listAllSchool();
		
		ModelAndView md = new ModelAndView("main/main");
		md.addObject("sd", sds);
//		System.out.println("start login--------"+username+"---"+password);
//		PlatformAdmin admin = platformAdminService.adminLogin(username, password);
//		if(null== admin){
//			System.out.println("user is null");
//		}
//        //UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//		req.getSession().setAttribute("admin", admin);
		
        return md;
	}
	@RequestMapping(value = "file.do")
	public ModelAndView upload(){
		return new ModelAndView("file");
	}
	
	@RequestMapping(value = "upload.do", produces="application/json;charset=utf-8")
	public @ResponseBody String upload(@RequestParam(required = false) MultipartFile file){
		Map<String, Object> result = new HashMap<String, Object>();
		Gson gson = new Gson();
		
//		byte[] readFileToByteArray = FileUtils.readFileToByteArray(mfile.getBytes());
//		String url = Upload.uploadFile(file);
		
		System.out.println("ok");
		result.put("errno", "0");
		result.put("msg", "上传成功");
//		result.put("data", url);
		return gson.toJson(result);
	}
	
}
