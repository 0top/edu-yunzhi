package com.yunzhi.edu.domain;

import java.util.Date;
import java.util.List;

public class UserCourseDetail {
	
	private Long id;
	
	private String userId;

    private String courseId;
	
    private int chapterSum;
    
    private int coursewareSum;
    
    private int examSum;
    
    private int coursewareCount;
    
    private int examCount;
    
	private float engagePercent;
	
	private float examPercent;
	
	private Date lastmodifiedTime;
	
	//提问数量
	private int qaSum;
	
	private int qaHasProcess;
	
	private List<UserCourseChapterDetail> chapters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEngagePercent(int engagePercent) {
		this.engagePercent = engagePercent;
	}

	public List<UserCourseChapterDetail> getChapters() {
		return chapters;
	}

	public void setChapters(List<UserCourseChapterDetail> chapters) {
		this.chapters = chapters;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getChapterSum() {
		return chapterSum;
	}

	public void setChapterSum(int chapterSum) {
		this.chapterSum = chapterSum;
	}

	public int getCoursewareSum() {
		return coursewareSum;
	}

	public void setCoursewareSum(int coursewareSum) {
		this.coursewareSum = coursewareSum;
	}

	public int getExamSum() {
		return examSum;
	}

	public void setExamSum(int examSum) {
		this.examSum = examSum;
	}

	public int getCoursewareCount() {
		return coursewareCount;
	}

	public void setCoursewareCount(int coursewareCount) {
		this.coursewareCount = coursewareCount;
	}

	public int getExamCount() {
		return examCount;
	}

	public void setExamCount(int examCount) {
		this.examCount = examCount;
	}

	public float getEngagePercent() {
		return engagePercent;
	}

	public void setEngagePercent(float engagePercent) {
		this.engagePercent = engagePercent;
	}

	public float getExamPercent() {
		return examPercent;
	}

	public void setExamPercent(float examPercent) {
		this.examPercent = examPercent;
	}

	public Date getLastmodifiedTime() {
		return lastmodifiedTime;
	}

	public void setLastmodifiedTime(Date lastmodifiedTime) {
		this.lastmodifiedTime = lastmodifiedTime;
	}

	public int getQaSum() {
		return qaSum;
	}

	public void setQaSum(int qaSum) {
		this.qaSum = qaSum;
	}

	public int getQaHasProcess() {
		return qaHasProcess;
	}

	public void setQaHasProcess(int qaHasProcess) {
		this.qaHasProcess = qaHasProcess;
	}

	@Override
	public String toString() {
		return "UserCourseDetail [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", chapterSum="
				+ chapterSum + ", coursewareSum=" + coursewareSum + ", examSum=" + examSum + ", coursewareCount="
				+ coursewareCount + ", examCount=" + examCount + ", engagePercent=" + engagePercent + ", examPercent="
				+ examPercent + ", lastmodifiedTime=" + lastmodifiedTime + ", qaSum=" + qaSum + ", qaHasProcess="
				+ qaHasProcess + ", chapters=" + chapters + "]";
	}
	
	
}
