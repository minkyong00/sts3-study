package springjdbc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springjdbc.model.Person;
import springjdbc.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/springjdbc/conf/applicationContext.xml")
public class PersonTest {

	@Autowired
	private PersonService personServie;
	
	@Autowired
	private ApplicationContext context;
	
//	@Test
	public void testInsertPerson() {
		Person person = (Person)context.getBean("person");
		person.setPname("홍길동");
		person.setPage(20);
		int result = personServie.insertPerson(person);
		assertTrue(result>0);
	}
	
//	@Test
	public void testSelectPersonList() {
		List<Person> personList = personServie.selectPersonList();
		assertNotNull(personList);
	}
	
//	@Test
	public void testSelectPerson() {
		Person person = personServie.selectPerson(5);
		assertNotNull(person);
	}
	
//	@Test
	public void testUpdatePerson() {
		Person person = personServie.selectPerson(3);
		person.setPname("홍길동수정");
		person.setPage(30);
		int result = personServie.updatePerson(person);
		assertTrue(result>0);
	}
	
	@Test
	public void testDeletePerson() {
		int result = personServie.deletePerson(4);
		assertTrue(result>0);
	}
	
}














