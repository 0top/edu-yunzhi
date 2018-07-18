package com.yunzhi.edu.domain;

import java.util.List;

public class ExamAnswer {

	private int num;
	private List<String> ans;
	private String explanation;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public List<String> getAns() {
		return ans;
	}
	public void setAns(List<String> ans) {
		this.ans = ans;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "ExamAnswer [num=" + num + ", ans=" + ans + ", explanation=" + explanation + "]";
	}
}
