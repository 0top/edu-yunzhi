package com.yunzhi.edu.entity;

import java.util.Date;

public class CourseFile {
    private Long id;

    private String courseId;

    private String mediaId;

    private Date createTime;

    private String fileName;

    private String description;

    private String mediaUrl;

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

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

	@Override
	public String toString() {
		return "CourseFile [id=" + id + ", courseId=" + courseId + ", mediaId=" + mediaId + ", createTime=" + createTime
				+ ", fileName=" + fileName + ", description=" + description + ", mediaUrl=" + mediaUrl + "]";
	}
    
}