package com.yunzhi.edu.domain;

import java.util.List;

public class Exam {
	
	private int id;
	
	//本场考试总分
	private int sum;
	
	private List<ExamQuestion> questions;
	
	private List<ExamAnswer> ans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<ExamQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ExamQuestion> questions) {
		this.questions = questions;
	}

	public List<ExamAnswer> getAns() {
		return ans;
	}

	public void setAns(List<ExamAnswer> ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", questions=" + questions + ", ans=" + ans + "]";
	}

}
