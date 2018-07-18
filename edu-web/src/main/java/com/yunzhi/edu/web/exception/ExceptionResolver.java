package com.yunzhi.edu.web.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class ExceptionResolver implements HandlerExceptionResolver{

	@Override
	@RequestMapping(produces = "application/json;charset=utf-8")
	public @ResponseBody ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, 
			Object handler,
			Exception ex) {
		Map<String, Object> result = new HashMap<String, Object>();
		Gson gson = new Gson();
		
		System.out.println("resolveException");
		
		ex.printStackTrace();
		result.put("error", 1);
		result.put("msg", "请求失败");
		
		try {
			res.getWriter().print(gson.toJson(result));
			res.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("error");
	}

}
