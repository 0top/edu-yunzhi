package com.yunzhi.edu.domain;

public class ExamQuestion {

	private int num;
	private String question;
	private String ans;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String answer;
	private int type;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "ExamQuestion [num=" + num + ", question=" + question + ", ans=" + ans + ", ans1=" + ans1 + ", ans2="
				+ ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", type=" + type + "]";
	}
	
	
}
