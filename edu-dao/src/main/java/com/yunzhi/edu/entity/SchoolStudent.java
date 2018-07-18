package com.yunzhi.edu.entity;

public class SchoolStudent {
    private Long id;

    private String orgCode;

    private String realName;

    private String staffNum;

    private String classId;

    private String departmentId;

    private String startTime;

    private String endTime;

    private Byte isActivate;

    private String sex;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum == null ? null : staffNum.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getStarttime() {
        return startTime;
    }

    public void setStarttime(String starttime) {
        this.startTime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endTime;
    }

    public void setEndtime(String endtime) {
        this.endTime = endtime == null ? null : endtime.trim();
    }

    public Byte getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(Byte isActivate) {
        this.isActivate = isActivate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

	@Override
	public String toString() {
		return "SchoolStudent [id=" + id + ", orgCode=" + orgCode + ", realName=" + realName + ", staffNum=" + staffNum
				+ ", classId=" + classId + ", departmentId=" + departmentId + ", starttime=" + startTime + ", endtime="
				+ endTime + ", isActivate=" + isActivate + ", sex=" + sex + "]";
	}
    
}