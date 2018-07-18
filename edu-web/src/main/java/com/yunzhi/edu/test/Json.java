package com.yunzhi.edu.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Json {
	
	public static void main(String args[]){
		
		Gson gson = new Gson();
		
		List<String> json = new ArrayList<String>();
		json.add("skd");
		json.add("dskf");
		json.add("skdf");
		
		System.out.println(gson.toJson(json));
	}

}
