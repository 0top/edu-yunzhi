package com.yunzhi.edu.web.controller.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yunzhi.edu.entity.Article;
import com.yunzhi.edu.entity.ArticleComment;
import com.yunzhi.edu.util.ExtractJsonString;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.util.ReMap;
import com.yunzhi.edu.web.controller.BaseController;
import com.yunzhi.edu.web.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {

	@Autowired
	private ArticleService articleService;

	Gson gson = new Gson();

	@RequiresRoles(value = {"user","student"}, logical=Logical.OR)
	@RequestMapping(value = "/insert/article", produces = "application/json;charset=utf-8")
	public @ResponseBody String uploadArticle(HttpServletRequest req) {

		try {
			String json = ExtractJsonString.extractJson(req);

			Article article = gson.fromJson(json, Article.class);
			System.out.println(json.toString());
			System.out.println(article.toString());
			article.setArticleId(RandomId.createId());
			article.setCreateTime(new Date());

			articleService.insertArticle(article);

			return ReMap.ResultMap(0, "请求成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

//	@RequiresRoles(value={"admin"})
	@RequestMapping(value = "/lock/article/{articleId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String lockArticle(@PathVariable("articleId") String articleId) {
		// 判断当前用户是否具有此权限
		try {

			articleService.lockArticle(articleId);

			return ReMap.ResultMap(0, "请求成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

	@RequiresRoles(value={"admin"})
	@RequestMapping(value = "unlock/article/{articleId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String unlockArticle(@PathVariable("articleId") String articleId) {

		// 判断当前用户是否具有此权限
		try {
			articleService.unlockArticle(articleId);

			return ReMap.ResultMap(0, "请求成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

	@RequestMapping(value = "/delete/article/{articleId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteArticle(@PathVariable("articleId") String articleId) {
		// 判断当前用户是否具有此权限
		try {
			articleService.deleteArticle(articleId);

			return ReMap.ResultMap(0, "请求成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

	@RequestMapping(value = "/list/article", produces = "application/json;charset=utf-8")
	public @ResponseBody String listArticle(HttpServletRequest req){
		
		try {
			String json = ExtractJsonString.extractJson(req);

			Article article = gson.fromJson(json, Article.class);
						
			if(article != null){
				List<Article> articles = articleService.listArticle(article);
				return ReMap.ResultMap(0, "请求成功", articles);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return ReMap.ResultMap(1, "请求失败", null);
	}
	
	@RequestMapping(value = "/get/article/{id}", produces = "application/json;charset=utf-8")
	public @ResponseBody String getArticle(HttpServletRequest req, 
			@PathVariable("id") String id) {
		try {

			Article article = articleService.getArticleById(Long.parseLong(id));
			return ReMap.ResultMap(0, "请求成功", article);

		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}
	}

	@RequestMapping(value = "/insert/comment", produces = "application/json;charset=utf-8")
	public @ResponseBody String insertComment(HttpServletRequest req) {

		try {
			String json = ExtractJsonString.extractJson(req);
			ArticleComment comment = gson.fromJson(json, ArticleComment.class);
			
			comment.setCreateTime(new Date());
			
			articleService.insertComment(comment);
			return ReMap.ResultMap(0, "请求成功", null);

		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}

	}

	@RequestMapping(value = "/list/comment/{articleId}", produces = "application/json;charset=utf-8")
	public @ResponseBody String listComment(HttpServletRequest req, @PathVariable("articleId") String articleId) {
		try {
			
			List<ArticleComment> comments = articleService.listComments(articleId);
			
			return ReMap.ResultMap(0, "请求成功", comments);

		} catch (Exception e) {
			e.printStackTrace();
			return ReMap.ResultMap(1, "请求失败", null);
		}

	}
}
