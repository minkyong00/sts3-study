package springaop_exam.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springaop_exam.dao.ArticleDao;
import springaop_exam.model.Article;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<Article> listArticle() {
		return template.selectList("article.listArticle");
	}
	
	@Override
	public Article getArticle(int aid) {
		return template.selectOne("article.getArticle", aid);
	}
	
	@Override
	public int insertArticle(Article article) {
		return template.insert("article.insertArticle", article);
	}
	
	@Override
	public int updateArticle(Article article) {
		return template.update("article.updateArticle", article);
	}
	
	@Override
	public int deleteArticle(int aid) {
		return template.delete("article.deleteArticle", aid);
	}

}
