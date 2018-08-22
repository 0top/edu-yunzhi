package com.yunzhi.edu.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Json {
	
	public static void main(String args[]){
		
		Gson gson = new Gson();
		
		List<String> json = new ArrayList<String>();
		json.add("json1");
		json.add("json2");
		
		System.out.println(gson.toJson(json));
	}

}
