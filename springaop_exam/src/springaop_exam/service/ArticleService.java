package springaop_exam.service;

import java.util.List;

import springaop_exam.model.Article;

public interface ArticleService {

	public default List<Article> selectListArticle() { return null; }
	
	public default Article selectGetArticle(int aid) { return null; }
	
	public default int insertArticle(Article article) { return 0; }
	
	public default int updateArticle(Article article) { return 0; }
	
	public default int deleteArticle(int aid) { return 0; }
	
}
