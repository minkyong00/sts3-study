package springaop_exam.dao;

import java.util.List;

import springaop_exam.model.Article;

public interface ArticleDao {

	public default List<Article> listArticle() { return null; }
	
	public default Article getArticle(int aid) { return null; }
	
	public default int insertArticle(Article article) { return 0; }
	
	public default int updateArticle(Article article) { return 0; }
	
	public default int deleteArticle(int aid) { return 0; }
	
}
