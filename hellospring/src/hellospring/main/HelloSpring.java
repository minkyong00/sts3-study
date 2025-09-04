package hellospring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hellospring.bean.Hello;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext context
			= new GenericXmlApplicationContext("hellospring/conf/beans.xml");
		
		// 스프링이 생성해서 hello 객체를 줌
		// 스프링의 빈은 싱글톤으로 생성함
	 	Hello hello = (Hello)context.getBean("hello");
	 	
	 	hello.setMessage("Hello Spring !!");
	 	
	 	System.out.println(hello.getMessage());
		
	}
	
}
