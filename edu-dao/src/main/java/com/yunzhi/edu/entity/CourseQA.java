package com.yunzhi.edu.entity;

public class CourseQA {
    private Long id;

    private String courseId;

    private String userId;
    
    private String userAvatar;
   
    private String userName;

    private String question;

    private String answer;

    private Boolean isProcess;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Boolean getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(Boolean isProcess) {
        this.isProcess = isProcess;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "CourseQA [id=" + id + ", courseId=" + courseId + ", userId=" + userId + ", userAvatar=" + userAvatar
				+ ", userName=" + userName + ", question=" + question + ", answer=" + answer + ", isProcess="
				+ isProcess + "]";
	}
	
	
}