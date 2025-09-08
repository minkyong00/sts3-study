package springlayer.service;

import java.util.List;

import springlayer.model.Todo;

public interface TodoService {

	public default List<Todo> listTodo() { return null;}
	
	public default Todo getTodo(int todoId) { return null; }
	
	public default int insertTodo(Todo todo) { return 0; }
	
	public default int updateTodo(Todo todo) { return 0; }
	
	public default int deleteTodo(Todo todo) { return 0; }

}
