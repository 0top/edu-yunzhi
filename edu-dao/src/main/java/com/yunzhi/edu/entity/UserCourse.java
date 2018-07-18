package com.yunzhi.edu.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserCourse {
    private Long id;

    private String userId;
    
    private String title;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String courseId;

    private String thumbnail;
    
    public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	private BigDecimal engagePercent;

    private BigDecimal examPercent;
    
    public Date getLastModify() {
		return lastModify;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	private Date lastModify;

    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public BigDecimal getEngagePercent() {
        return engagePercent;
    }

    public void setEngagePercent(BigDecimal engagePercent) {
        this.engagePercent = engagePercent;
    }

    public BigDecimal getExamPercent() {
        return examPercent;
    }

    public void setExamPercent(BigDecimal examPercent) {
        this.examPercent = examPercent;
    }



	public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		return "UserCourse [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", engagePercent="
				+ engagePercent + ", examPercent=" + examPercent + ", detail=" + detail + "]";
	}
    
    
}