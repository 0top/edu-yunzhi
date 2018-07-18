package com.yunzhi.edu.entity;

import java.util.Date;
import java.util.List;

public class Article {
    private Long id;

    private String orgCode;
    
    private String staffNum;

    private String articleId;

    private String title;

    private String author;

    private Date createTime;

    private Integer shareNum;

    private Integer commentCount;

    private Integer upvote;

    private Boolean isLock;

    private String content;
    
    List<ArticleComment> comments;

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
		this.orgCode = orgCode;
	}



	public String getStaffNum() {
		return staffNum;
	}



	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}



	public String getArticleId() {
		return articleId;
	}



	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Integer getShareNum() {
		return shareNum;
	}



	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}



	public Integer getCommentCount() {
		return commentCount;
	}



	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}



	public Integer getUpvote() {
		return upvote;
	}



	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}



	public Boolean getIsLock() {
		return isLock;
	}



	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public List<ArticleComment> getComments() {
		return comments;
	}



	public void setComments(List<ArticleComment> comments) {
		this.comments = comments;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", orgCode=" + orgCode + ", staffNum=" + staffNum + ", articleId=" + articleId
				+ ", title=" + title + ", author=" + author + ", createTime=" + createTime + ", shareNum=" + shareNum
				+ ", commentCount=" + commentCount + ", upvote=" + upvote + ", isLock=" + isLock + ", content="
				+ content + ", comments=" + comments + "]";
	}

	
   
}