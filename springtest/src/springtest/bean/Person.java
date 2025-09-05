package springtest.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
@Scope("prototype")
public class Person implements Serializable {

	public static final long serialVersionUID = 5452363354535L;

	private String name;
	private int age;
	private boolean isStudent;

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isStudent=" + isStudent + "]";
	}

}
