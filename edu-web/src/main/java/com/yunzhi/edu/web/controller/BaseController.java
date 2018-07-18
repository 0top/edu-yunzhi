package com.yunzhi.edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunzhi.edu.util.ReMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class})
	public @ResponseBody String authenticatedException(HttpServletRequest req, HttpServletResponse res ) {
		
		System.out.println("UnauthenticatedException or AuthenticationException");

		if(null != SecurityUtils.getSubject().getPrincipal()){
			
			if(null != SecurityUtils.getSubject().getSession().getAttribute("user"))
				System.out.println(SecurityUtils.getSubject().getSession().getAttribute("user").toString());
		}
		else{
			
		}
		return ReMap.ResultMap(1, "认证失败", null);
		
	}
	
	@ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
	public @ResponseBody String authorizationException(HttpServletRequest req, HttpServletResponse res){
		
		System.out.println("UnauthenticatedException or AuthenticationException");
		if(null != SecurityUtils.getSubject().getPrincipal()){
			
			if(null != SecurityUtils.getSubject().getSession().getAttribute("user"))
				System.out.println(SecurityUtils.getSubject().getSession().getAttribute("user").toString());
			
		}
		return ReMap.ResultMap(1, "权限不足", null);
	}
	
	@ExceptionHandler({Exception.class})
	public @ResponseBody String unknowException(){
		
		logger.info("----------- 请求出错  ");
		
		return ReMap.ResultMap(1, "请求出错", null);
	}
}
