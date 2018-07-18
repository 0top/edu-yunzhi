package com.yunzhi.edu.entity;

import java.util.Date;

public class CourseComment {
    private Long id;

    private String courseId;

    private Byte rate;

    private String content;

    private String sendFromId;

    private String sendFromName;

    private String sendFromAvator;

    private Date createTime;

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
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Byte getRate() {
        return rate;
    }

    public void setRate(Byte rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSendFromId() {
        return sendFromId;
    }

    public void setSendFromId(String sendFromId) {
        this.sendFromId = sendFromId == null ? null : sendFromId.trim();
    }

    public String getSendFromName() {
        return sendFromName;
    }

    public void setSendFromName(String sendFromName) {
        this.sendFromName = sendFromName == null ? null : sendFromName.trim();
    }

    public String getSendFromAvator() {
        return sendFromAvator;
    }

    public void setSendFromAvator(String sendFromAvator) {
        this.sendFromAvator = sendFromAvator == null ? null : sendFromAvator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "CourseComment [id=" + id + ", courseId=" + courseId + ", rate=" + rate + ", content=" + content
				+ ", sendFromId=" + sendFromId + ", sendFromName=" + sendFromName + ", sendFromAvator=" + sendFromAvator
				+ ", createTime=" + createTime + "]";
	}
    
}