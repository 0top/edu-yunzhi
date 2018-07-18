package com.yunzhi.edu.entity;

public class SchoolDepartment {
    private Long id;

    private String orgCode;

    private String departmentId;

    private String departmentName;
    
    private String description;

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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

	@Override
	public String toString() {
		return "SchoolDepartment [id=" + id + ", orgCode=" + orgCode + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", description=" + description + "]";
	}
	
}