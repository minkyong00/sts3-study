package springaop_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springaop_exam.dao.ArticleDao;
import springaop_exam.model.Article;
import springaop_exam.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> selectListArticle() {
		return articleDao.listArticle();
	}
	
	@Override
	public Article selectGetArticle(int aid) {
		return articleDao.getArticle(aid);
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDao.insertArticle(article);
	}
	
	@Override
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}
	
	@Override
	public int deleteArticle(int aid) {
		return articleDao.deleteArticle(aid);
	}
	
}
