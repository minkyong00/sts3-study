package springaop.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaop.model.Person;
import springaop.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springaop/conf/applicationContext.xml")
public class PersonTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void testInsertPerson() {
		Person person = (Person)context.getBean("person");
		int result = personService.insertPerson(person);
		assertTrue(result>0);
	}
	
	@Test
	public void testUpdatePerson() {
		Person person = (Person)context.getBean("person");
		int result =  personService.updatePerson(person);
		assertTrue(result>0);
	}
	
//	@Test
	public void testListPerson() {
		List<Person> personList = personService.listPerson();
		assertNotNull(personList);
	}
	
//	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(1);
		assertNotNull(person);
	}
	
//	@Test
	public void testDeletePerson() {
		int result = personService.deletePerson(1);
		assertTrue(result>0);
	}
	
}





















