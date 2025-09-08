package springlayer.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springlayer.model.Todo;
import springlayer.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/springlayer/conf/applicationContext.xml")
public class JdbcTodoTest {
	
	@Autowired
	private TodoService todoService;

	@Autowired
	private ApplicationContext context;
	
//	@Test
	public void testInsertTodo() {
		Todo todo = (Todo)context.getBean("todo");
		todo.setTodoContent("할일1");
		int result = todoService.insertTodo(todo);
		assertTrue(result>0);
	}
	
	@Test
	public void testSelectTodoList() {
		List<Todo> todoList = todoService.listTodo();
		assertNotNull(todoList);
	}
	
	@Test
	public void testSelectTodo() {
		Todo todo = todoService.getTodo(3);
		assertNotNull(todo);
	}
	
//	@Test
	public void testUpdateTodo() {
		Todo todo = todoService.getTodo(2);
		todo.setTodoContent("할일수정");
		int result = todoService.updateTodo(todo);
		assertTrue(result>0);
	}
	
//	@Test
	public void testDeleteTodo() {
		int result = todoService.deleteTodo(todoService.getTodo(5));
		assertTrue(result>0);
	}
	
}

















