package com.yunzhi.edu.entity;

import java.util.Date;

public class CourseTask {
    private Long id;

    private String courseId;

    private String taskId;

    private String sendFromId;

    private String sendFromName;

    private String taskTitle;

    private String taskDescription;

    private String type;

    private String actor;

    private Date deadline;

    private Date createTime;
    
    private int hasFinish;
    
    private int totleActor; 

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
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

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription == null ? null : taskDescription.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public int getHasFinish() {
		return hasFinish;
	}

	public void setHasFinish(int hasFinish) {
		this.hasFinish = hasFinish;
	}

	public int getTotleActor() {
		return totleActor;
	}

	public void setTotleActor(int totleActor) {
		this.totleActor = totleActor;
	}

	@Override
	public String toString() {
		return "CourseTask [id=" + id + ", courseId=" + courseId + ", taskId=" + taskId + ", sendFromId=" + sendFromId
				+ ", sendFromName=" + sendFromName + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription
				+ ", type=" + type + ", actor=" + actor + ", deadline=" + deadline + ", createTime=" + createTime
				+ ", hasFinish=" + hasFinish + ", totleActor=" + totleActor + "]";
	}
	
	
}