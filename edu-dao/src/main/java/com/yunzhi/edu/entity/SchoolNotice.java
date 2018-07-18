package com.yunzhi.edu.entity;

import java.util.Date;

public class SchoolNotice {
    private Long id;

    private String orgCode;
    
    private String sendFromId;

    private String sendFromName;

    private Date createTime;
    
    private String content; 

    private String acceptTo;

    private Boolean isRead;

    private Byte type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSendFromId() {
        return sendFromId;
    }

    public void setSendFromId(String sendFromId) {
        this.sendFromId = sendFromId == null ? null : sendFromId.trim();
    }

    public String getSendFromName() {
        return sendFromName;
    }

    public void setSendFromName(String sendFromName) {
        this.sendFromName = sendFromName == null ? null : sendFromName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAcceptTo() {
        return acceptTo;
    }

    public void setAcceptTo(String acceptTo) {
        this.acceptTo = acceptTo == null ? null : acceptTo.trim();
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}