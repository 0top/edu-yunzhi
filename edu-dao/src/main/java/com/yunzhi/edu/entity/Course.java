package com.yunzhi.edu.entity;

import java.util.Date;
import java.util.List;


public class Course {
	private Long id;

	private String orgCode;

	private String courseId;

	private String title;

	private String thumbnail;

	private Integer userCount;

	private String teacherId;

	private String description;

	private Byte score;

	private Date startTime;

	private Date endTime;

	private String tags;

	private Boolean isPublic;

	private Short examUsual;

	private Short examFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId == null ? null : courseId.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail == null ? null : thumbnail.trim();
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Byte getScore() {
		return score;
	}

	public void setScore(Byte score) {
		this.score = score;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Short getExamUsual() {
		return examUsual;
	}

	public void setExamUsual(Short examUsual) {
		this.examUsual = examUsual;
	}

	public Short getExamFinal() {
		return examFinal;
	}

	public void setExamFinal(Short examFinal) {
		this.examFinal = examFinal;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", orgCode=" + orgCode + ", courseId=" + courseId + ", title=" + title
				+ ", thumbnail=" + thumbnail + ", userCount=" + userCount + ", teacherId=" + teacherId
				+ ", description=" + description + ", score=" + score + ", startTime=" + startTime + ", endTime="
				+ endTime + ", tags=" + tags + ", isPublic=" + isPublic + ", examUsual=" + examUsual + ", examFinal="
				+ examFinal + "]";
	}

	/**
	 * extends
	 */
	private List<CourseChapter> chapters;
	
	private List<CourseChapterExam> examlist;

	private List<CourseFile> files;
	
	private List<CourseQA> courseqalist; 

	public List<CourseChapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<CourseChapter> chapters) {
		this.chapters = chapters;
	}



	public List<CourseChapterExam> getExamlist() {
		return examlist;
	}

	public void setExamlist(List<CourseChapterExam> examlist) {
		this.examlist = examlist;
	}

	public List<CourseFile> getFiles() {
		return files;
	}

	public void setFiles(List<CourseFile> files) {
		this.files = files;
	}

	public List<CourseQA> getCourseqalist() {
		return courseqalist;
	}

	public void setCourseqalist(List<CourseQA> courseqalist) {
		this.courseqalist = courseqalist;
	}



}