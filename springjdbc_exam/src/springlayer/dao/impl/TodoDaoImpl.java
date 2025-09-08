package springlayer.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springlayer.dao.TodoDao;
import springlayer.model.Todo;

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Todo> listTodo() {
		String sql = " select * from todo order by todoid desc ";
		List<Todo> todoList = jdbcTemplate.query(sql, new RowMapper<Todo>() {
			@Override
			public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Todo todo = new Todo();
				todo.setTodoId(rs.getInt("todoId"));
				todo.setTodoContent(rs.getString("todoContent"));
				todo.setTodoRegdate(rs.getTimestamp("todoRegdate"));
				todo.setTodoCompleted(rs.getString("todoCompleted"));
				return todo;
			}
		});
		return todoList;
	}
	
	@Override
	public Todo getTodo(int todoId) {
		String sql = " select * from todo where todoId=? ";
		Todo todo = jdbcTemplate.queryForObject(sql, new RowMapper<Todo>() {
			@Override
			public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Todo todo = new Todo();
				todo.setTodoId(rs.getInt("todoId"));
				todo.setTodoContent(rs.getString("todoContent"));
				todo.setTodoRegdate(rs.getTimestamp("todoRegdate"));
				todo.setTodoCompleted(rs.getString("todoCompleted"));
				return todo;
			}
		}, todoId);
		return todo;
	}
	
	@Override
	public int insertTodo(Todo todo) {
		String sql = " insert into todo values(seq_todo.nextval, ?, systimestamp, 'N') ";
		return jdbcTemplate.update(sql, todo.getTodoContent());
	}
	
	@Override
	public int updateTodo(Todo todo) {
		String sql = " update todo set todoContent=? where todoId=? ";
		return jdbcTemplate.update(sql, todo.getTodoContent(), todo.getTodoId());
	}
	
	@Override
	public int deleteTodo(Todo todo) {
		String sql = " delete todo where todoId=? ";
		return jdbcTemplate.update(sql, todo.getTodoId());
	}
	
}
