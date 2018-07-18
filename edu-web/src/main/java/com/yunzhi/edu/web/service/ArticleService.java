package com.yunzhi.edu.web.service;

import java.util.List;

import com.yunzhi.edu.entity.Article;
import com.yunzhi.edu.entity.ArticleComment;

public interface ArticleService {

	public int insertArticle(Article article);
	
	public Article getArticleById(Long id);
	
	public List<Article> listArticle(Article article);
	
	public int updateArticleSeletive(Article article);
	
	public int lockArticle(String articleId);
	
	public int unlockArticle(String articleId);
	
	public int deleteArticle(String articleId);
	
	public List<ArticleComment> listComments(String articleId);
	
	public int insertComment(ArticleComment comment);
}
