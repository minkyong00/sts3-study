package springlayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springlayer.dao.TodoDao;
import springlayer.model.Todo;
import springlayer.service.TodoService;

@Service("todoService")
public class TodoServiceimpl implements TodoService{
	
	@Autowired
	private TodoDao todoDao;

	@Override
	public List<Todo> listTodo() {
		return todoDao.listTodo();
	}
	
	@Override
	public Todo getTodo(int todoId) {
		return todoDao.getTodo(todoId);
	}
	
	@Override
	public int insertTodo(Todo todo) {
		return todoDao.insertTodo(todo);
	}
	
	@Override
	public int updateTodo(Todo todo) {
		return todoDao.updateTodo(todo);
	}
	
	@Override
	public int deleteTodo(Todo todo) {
		return todoDao.deleteTodo(todo);
	}
	
}
