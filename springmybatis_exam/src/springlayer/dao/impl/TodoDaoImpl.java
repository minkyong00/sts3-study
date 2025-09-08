package springlayer.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springlayer.dao.TodoDao;
import springlayer.model.Todo;

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<Todo> listTodo() {
		return template.selectList("todo.listTodo");
	}
	
	@Override
	public Todo getTodo(int todoId) {
		return template.selectOne("todo.getTodo", todoId);
	}
	
	@Override
	public int insertTodo(Todo todo) {
		return template.insert("todo.insertTodo", todo);
	}
	
	@Override
	public int updateTodo(Todo todo) {
		return template.update("todo.updateTodo", todo);
	}
	
	@Override
	public int deleteTodo(Todo todo) {
		return template.delete("todo.deleteTodo", todo);
	}
	
}
