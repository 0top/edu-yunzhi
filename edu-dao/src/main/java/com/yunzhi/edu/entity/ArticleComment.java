package com.yunzhi.edu.entity;

import java.util.Date;
import java.util.List;

public class ArticleComment {
    private Long id;

    private String articleId;

    private Integer parentId;

    private Integer childrenId;

    private String content;
    
    private Date createTime;

    private String sendFromName;
    
    private String sendFromId;

    private String acceptToName;
    
    private String acceptToId;
    
    private List<ArticleComment> childrenComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getChildrenId() {
		return childrenId;
	}

	public void setChildrenId(Integer childrenId) {
		this.childrenId = childrenId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSendFromName() {
		return sendFromName;
	}

	public void setSendFromName(String sendFromName) {
		this.sendFromName = sendFromName;
	}

	public String getSendFromId() {
		return sendFromId;
	}

	public void setSendFromId(String sendFromId) {
		this.sendFromId = sendFromId;
	}

	public String getAcceptToName() {
		return acceptToName;
	}

	public void setAcceptToName(String acceptToName) {
		this.acceptToName = acceptToName;
	}

	public String getAcceptToId() {
		return acceptToId;
	}

	public void setAcceptToId(String acceptToId) {
		this.acceptToId = acceptToId;
	}

	public List<ArticleComment> getChildrenComment() {
		return childrenComment;
	}

	public void setChildrenComment(List<ArticleComment> childrenComment) {
		this.childrenComment = childrenComment;
	}

	@Override
	public String toString() {
		return "ArticleComment [id=" + id + ", articleId=" + articleId + ", parentId=" + parentId + ", childrenId="
				+ childrenId + ", content=" + content + ", createTime=" + createTime + ", sendFromName=" + sendFromName
				+ ", sendFromId=" + sendFromId + ", acceptToName=" + acceptToName + ", acceptToId=" + acceptToId
				+ ", childrenComment=" + childrenComment + "]";
	}
	
}