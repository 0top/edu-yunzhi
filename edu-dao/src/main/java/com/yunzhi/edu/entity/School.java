package com.yunzhi.edu.entity;

public class School {
    private Long id;

    private String orgCode;

    private String orgName;

    private String orgImg;

    private String description;

    private Byte authorization;
    
    private Byte type;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgImg() {
        return orgImg;
    }

    public void setOrgImg(String orgImg) {
        this.orgImg = orgImg == null ? null : orgImg.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Byte authorization) {
        this.authorization = authorization;
    }

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", orgCode=" + orgCode + ", orgName=" + orgName + ", orgImg=" + orgImg
				+ ", description=" + description + ", authorization=" + authorization + "]";
	}
    
}