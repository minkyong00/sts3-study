package springlayer.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("todo")
public class Todo implements Serializable {

	public static final long serialVersionUID = 22665665665656L;

	private int todoId;
	private String todoContent;
	private Date todoRegdate;
	private String todoCompleted;

	public Todo() {
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoContent() {
		return todoContent;
	}

	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public Date getTodoRegdate() {
		return todoRegdate;
	}

	public void setTodoRegdate(Date todoRegdate) {
		this.todoRegdate = todoRegdate;
	}

	public String getTodoCompleted() {
		return todoCompleted;
	}

	public void setTodoCompleted(String todoCompleted) {
		this.todoCompleted = todoCompleted;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoContent=" + todoContent + ", todoRegdate=" + todoRegdate
				+ ", todoCompleted=" + todoCompleted + "]";
	}

}
