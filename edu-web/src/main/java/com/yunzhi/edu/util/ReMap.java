package com.yunzhi.edu.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ReMap {
	
	static Gson gson = new Gson();
	
	
	public static String ResultMap(int errno, String msg, Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errno", errno);
		result.put("msg", msg);
		if(null != data){
			result.put("data", data);
		}
		return gson.toJson(result);
	}

}
