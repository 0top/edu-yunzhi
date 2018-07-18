package com.yunzhi.edu.util;

public enum LoginType {
	
	USER("User"),
	STUDENT("Student"),
	TEACHER("Teacher"),
	ADMIN("Admin");
	
	private String type;
	
	private LoginType(String type){
		this.type = type;
	}
	
	public String toString(){
		return this.type.toString();
	}
}
