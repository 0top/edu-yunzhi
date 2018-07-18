package com.yunzhi.edu.domain;

import java.util.List;

public class UserCourseChapterDetail {
	
	private Long id;

	private List<UserCourseWareDetail> coursewares;
	
	private List<UserCourseExamDetail> exams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserCourseWareDetail> getCoursewares() {
		return coursewares;
	}

	public void setCoursewares(List<UserCourseWareDetail> coursewares) {
		this.coursewares = coursewares;
	}

	public List<UserCourseExamDetail> getExams() {
		return exams;
	}

	public void setExams(List<UserCourseExamDetail> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "UserCourseChapterDetail [id=" + id + ", coursewares=" + coursewares + ", exams=" + exams + "]";
	}
	
}
