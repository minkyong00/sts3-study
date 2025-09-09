package springaop_exam.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaop_exam.model.Article;
import springaop_exam.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springaop_exam/conf/applicationContext.xml")
public class ArticleTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private ArticleService articleService;
	
//	@Test
	public void insertArticle() {
		Article article = (Article)context.getBean("article");
		article.setAtitle("제목");
		article.setAcontent("내용");
		article.setMid("hong");
		int result = articleService.insertArticle(article);
		assertTrue(result>0);
	}
	
//	@Test
	public void listArticle() {
		List<Article> articleList = articleService.selectListArticle();
		assertNotNull(articleList);
	}
	
//	@Test
	public void getArticle() {
		Article article = articleService.selectGetArticle(1);
		assertNotNull(article);
	}
	
//	@Test
	public void updateArticle() {
		Article article = (Article)context.getBean("article");
		article.setAid(1);
		article.setAtitle("제목수정");
		article.setAcontent("내용수정");
		int result = articleService.updateArticle(article);
		assertTrue(result>0);
	}
	
//	@Test
	public void deleteArticle() {
		int result = articleService.deleteArticle(4);
		assertTrue(result>0);
	}
	
}















