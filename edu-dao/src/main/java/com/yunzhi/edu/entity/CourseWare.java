package com.yunzhi.edu.entity;

public class CourseWare {
    private Long id;

    private String courseId;
    
    private String chapterId;

    private String coursewareId;

    private String coursewareName;

    private Short location;

    private String mediaUrl;

    private String exercise;

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


    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(String coursewareId) {
        this.coursewareId = coursewareId;
    }

    public String getCoursewareName() {
        return coursewareName;
    }

    public void setCoursewareName(String coursewareName) {
        this.coursewareName = coursewareName == null ? null : coursewareName.trim();
    }

    public Short getLocation() {
        return location;
    }

    public void setLocation(Short location) {
        this.location = location;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise == null ? null : exercise.trim();
    }

	@Override
	public String toString() {
		return "CourseWare [id=" + id + ", courseId=" + courseId + ", chapterId=" + chapterId + ", coursewareId="
				+ coursewareId + ", coursewareName=" + coursewareName + ", location=" + location + ", mediaUrl="
				+ mediaUrl + ", exercise=" + exercise + "]";
	}
    
}