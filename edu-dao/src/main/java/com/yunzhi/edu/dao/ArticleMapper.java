package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteArticle(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);
    
    List<Article> listArticle(Article article);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    int lockArticle(String articleId);
	
	int unlockArticle(String articleId);
}