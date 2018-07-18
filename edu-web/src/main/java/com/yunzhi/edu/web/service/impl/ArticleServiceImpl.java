package com.yunzhi.edu.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunzhi.edu.dao.ArticleCommentMapper;
import com.yunzhi.edu.dao.ArticleMapper;
import com.yunzhi.edu.entity.Article;
import com.yunzhi.edu.entity.ArticleComment;
import com.yunzhi.edu.web.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleDao;
	
	@Autowired
	private ArticleCommentMapper commentDao;
	
	//操作文章
	
	@Override
	public int insertArticle(Article article) {
		return articleDao.insertSelective(article);
	}

	@Override
	public List<Article> listArticle(Article article) {
		
		if(article == null)
			return null;
		
		article.setIsLock(false);;
		return articleDao.listArticle(article);
	}
	
	
	@Override
	public Article getArticleById(Long id) {
		
		Article article = articleDao.selectByPrimaryKey(id);
		
		article.setComments(commentDao.listCommentByArticleId(article.getArticleId()));
		
		return article;
	}

	@Override
	public int updateArticleSeletive(Article article) {
		
		return articleDao.updateByPrimaryKeyWithBLOBs(article);
	}
	
	@Override
	public int lockArticle(String articleId) {
		
		//是否有权限锁文章
		
		return articleDao.lockArticle(articleId);
	}



	@Override
	public int unlockArticle(String articleId) {
		
		//是否有权限解锁
		
		return articleDao.unlockArticle(articleId);
	}
	
	@Override
	public int deleteArticle(String articleId) {
		
		//是否有权限删除
		
		commentDao.deleteByArticleId(articleId);
		articleDao.deleteArticle(articleId);
		
		return 1;
	}
	
	
	//操作评论
	
	@Override
	public List<ArticleComment> listComments(String articleId) {
		
		List<ArticleComment> comments = commentDao.listCommentByArticleId(articleId);
		
		System.out.println("length  "+comments.size());
		
		List<ArticleComment> commentList = new ArrayList<ArticleComment>();
		
		if(null != comments){
			
			for(ArticleComment comment: comments){
				if(comment.getParentId() == 0){
//					commentList.add(comment);
					for(ArticleComment co: comments){
						if(co.getParentId() != 0 && co.getParentId() == comment.getChildrenId()){
//							if(null == commentList.get(commentList.size()-1).getChilrenComment()){
//								commentList.get(commentList.size()-1).setChilrenComment(new ArrayList<ArticleComment>());
//							}
//							commentList.get(commentList.size()-1).getChilrenComment().add(co);
							if(null == comment.getChildrenComment()){
								comment.setChildrenComment(new ArrayList<ArticleComment>());
							}
							comment.getChildrenComment().add(co);
						}
					}
				}
			}
		}

		for(ArticleComment com: comments){
			if(com.getParentId()==0){
				commentList.add(com);
			}
		}
		
		
		return commentList;
	}

	@Override
	public int insertComment(ArticleComment comment) {
		
		return commentDao.insertSelective(comment);
	}

}
