package com.yunzhi.edu.entity;

public class SchoolClass extends SchoolClassKey {
    private String classId;

    private String className;

    private String departmentId;

    private String teacherId;
    
    private String description;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

	@Override
	public String toString() {
		return "SchoolClass [classId=" + classId + ", className=" + className + ", departmentId=" + departmentId
				+ ", teacherId=" + teacherId + ", description=" + description + ", getId()=" + getId()
				+ ", getOrgCode()=" + getOrgCode() + "]";
	}
	
}