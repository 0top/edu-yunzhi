package com.yunzhi.edu.domain;

public class UserCourseWareDetail {

	private Long id;
	private boolean see;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isSee() {
		return see;
	}
	public void setSee(boolean see) {
		this.see = see;
	}
	@Override
	public String toString() {
		return "UserCourseWareDetail [id=" + id + ", see=" + see + "]";
	}
	
}
