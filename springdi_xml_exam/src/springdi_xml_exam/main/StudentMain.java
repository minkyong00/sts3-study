package springdi_xml_exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi_xml_exam.bean.Student;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context 
			= new GenericXmlApplicationContext("springdi_xml_exam/conf/applicationContext.xml");
		
		printStudentScore("홍길동", 100, 100, 100, context);
		printStudentScore("강감찬", 90, 90, 90, context);
		printStudentScore("이순신", 80, 80, 80, context);
		
	}
	
	private static void printStudentScore(String name, int kor, int eng, int math, ApplicationContext context) {
		Student student = (Student)context.getBean("student");
		student.setName(name);
		student.getScore().setKor(kor);
		student.getScore().setEng(eng);
		student.getScore().setMath(math);
		System.out.println(student);
	}
	
}
