package springmvc.person.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
@Scope("prototype")
public class Person implements Serializable {

	public static final long serialVersionUID = 36232322699599L;

	private int pid;
	private String name;
	private int age;

	public Person() {
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", age=" + age + "]";
	}

}
