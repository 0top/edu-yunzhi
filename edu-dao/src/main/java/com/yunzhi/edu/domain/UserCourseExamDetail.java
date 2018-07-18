package com.yunzhi.edu.domain;

import java.util.List;

public class UserCourseExamDetail {

	private Long id;
	private boolean isDone;
	private List<ExamAnswer> ans;
	private int score;
	private int sum;
	private int correctSum;
	private int errorSum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public List<ExamAnswer> getAns() {
		return ans;
	}
	public void setAns(List<ExamAnswer> ans) {
		this.ans = ans;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCorrectSum() {
		return correctSum;
	}
	public void setCorrectSum(int correctSum) {
		this.correctSum = correctSum;
	}
	public int getErrorSum() {
		return errorSum;
	}
	public void setErrorSum(int errorSum) {
		this.errorSum = errorSum;
	}
	@Override
	public String toString() {
		return "UserCourseExamDetail [id=" + id + ", isDone=" + isDone + ", ans=" + ans + ", score=" + score + ", sum="
				+ sum + ", correctSum=" + correctSum + ", errorSum=" + errorSum + "]";
	}
	
	
}
