package com.yunzhi.edu.dao;

import java.util.List;

import com.yunzhi.edu.entity.ArticleComment;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteByArticleId(String articleId);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(Long id);
    
    List<ArticleComment> listCommentByArticleId(String articleId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}