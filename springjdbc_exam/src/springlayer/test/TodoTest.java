package springlayer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springlayer.model.Todo;
import springlayer.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springlayer/conf/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private TodoService todoService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("테스트 시작!");
	}
	
	@Test
	public void a_insertTodo() {
		Todo todo1 = createTodo(1, "할일1", new Date(), "N");
		Todo todo2 = createTodo(2, "할일2", new Date(), "N");
		Todo todo3 = createTodo(3, "할일3", new Date(), "N");
		
		todoService.insertTodo(todo1);
		todoService.insertTodo(todo2);
		todoService.insertTodo(todo3);
		
		assertNotNull(todo1);
		assertNotNull(todo2);
		assertNotNull(todo3);
	}
	
	@Test
	public void b_listTodo() {
		List<Todo> todoList = todoService.listTodo();
		assertNotNull(todoList);
		assertNotEquals(0, todoList.size());
	}
	
	@Test
	public void c_getTodo() {
		Todo todo = todoService.getTodo(2);
		assertNotNull(todo);
	}

	@Test
	public void d_updateTodo() {
		Todo newTodo = todoService.getTodo(2);
		newTodo.setTodoContent("새로운 할일2");
		int result = todoService.updateTodo(newTodo);
		assertEquals(1, result);
	}
	
	@Test
	public void e_deleteTodo() {
		Todo deleteTodo = todoService.getTodo(2);
		int result = todoService.deleteTodo(deleteTodo);
		assertEquals(1, result);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("테스트 종료!");
	}
	
	private Todo createTodo(int todoId, String todoContent, Date todoRegdate, String todoCompleted) {
		Todo todo = (Todo)context.getBean("todo");
		todo.setTodoId(todoId);
		todo.setTodoContent(todoContent);
		todo.setTodoRegdate(todoRegdate);
		todo.setTodoCompleted(todoCompleted);
		return todo;
	}
	
}
