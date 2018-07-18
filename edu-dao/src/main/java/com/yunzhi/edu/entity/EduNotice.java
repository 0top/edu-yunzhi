package com.yunzhi.edu.entity;

import java.util.Date;

public class EduNotice {
    private Long id;

    private String sendFrom;

    private String acceptTo;

    private Date createTime;

    private Date endTime;

    private Short type;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom == null ? null : sendFrom.trim();
    }

    public String getAcceptTo() {
        return acceptTo;
    }

    public void setAcceptTo(String acceptTo) {
        this.acceptTo = acceptTo == null ? null : acceptTo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}