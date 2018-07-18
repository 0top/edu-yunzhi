package com.yunzhi.edu.entity;

import java.util.List;

public class CourseChapter {
    private Long id;

    private String courseId;

    private String chapterId;

    private String chapterName;

    private Short location;

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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public Short getLocation() {
        return location;
    }

    public void setLocation(Short location) {
        this.location = location;
    }

	@Override
	public String toString() {
		return "CourseChapter [id=" + id + ", courseId=" + courseId + ", chapterId=" + chapterId + ", chapterName="
				+ chapterName + ", location=" + location + "]";
	}
	
	/**
	 * extends
	 */
    private List<CourseChapterExam> exams;
    
    private List<CourseWare> coursewares;

	public List<CourseChapterExam> getExams() {
		return exams;
	}

	public void setExams(List<CourseChapterExam> exams) {
		this.exams = exams;
	}

	public List<CourseWare> getCoursewares() {
		return coursewares;
	}

	public void setCoursewares(List<CourseWare> coursewares) {
		this.coursewares = coursewares;
	}

    
}