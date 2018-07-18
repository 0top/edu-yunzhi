package com.yunzhi.edu.entity;

import java.util.Date;

public class CourseChapterExam {
    private Long id;

    private String courseId;

    private String chapterId;

    private String examId;

    private String examTitle;

	private Integer examtime;

	private String description;

    private Date endTime;

    private String answer;

    private Boolean type;

    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getChapterId() {
		return chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public Integer getExamtime() {
		return examtime;
	}

	public void setExamtime(Integer examtime) {
		this.examtime = examtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CourseChapterExam [id=" + id + ", courseId=" + courseId + ", chapterId=" + chapterId + ", examId="
				+ examId + ", examTitle=" + examTitle + ", examtime=" + examtime + ", description=" + description
				+ ", endTime=" + endTime + ", answer=" + answer + ", type=" + type + ", content=" + content + "]";
	}

    

   
}