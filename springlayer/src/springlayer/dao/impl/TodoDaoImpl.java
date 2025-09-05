package springlayer.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import springlayer.dao.TodoDao;
import springlayer.model.Todo;

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao{
	
	private static List<Todo> todoList = Collections.EMPTY_LIST;
	
	static {
		todoList = new ArrayList<Todo>();
	}

	@Override
	public List<Todo> listTodo() {
		return todoList;
	}
	
	@Override
	public Todo getTodo(int todoId) {
		return todoList.get(todoId-1);
	}
	
	@Override
	public int insertTodo(Todo todo) {
		return todoList.add(todo)==true ? 1 : 0;
	}
	
	@Override
	public int updateTodo(Todo todo) {
		return todoList.set((todo.getTodoId())-1, todo)!=null ? 1 : 0;
	}
	
	@Override
	public int deleteTodo(Todo todo) {
		return todoList.remove(todo.getTodoId()-1)!=null ? 1 : 0;
	}
	
}
