package springmvc.person.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import springmvc.person.model.Person;
import springmvc.person.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	
	private static List<Person> personList;
	
	static {
		personList = new ArrayList<Person>();
	}
	
	@Override
	public List<Person> listPerson() {
		return personList;
	}
	
	@Override
	public Person getPerson(int pid) {
		return personList.stream().filter(person -> person.getPid()==pid).findFirst().get();
	}
	
	@Override
	public int insertPerson(Person person) {
		return personList.add(person)==true ? 1 : 0;
	}
	
	@Override
	public int updatePerson(Person person) {
		deletePerson(person.getPid());
		return insertPerson(person);
	}
	
	@Override
	public int deletePerson(int pid) {
		return personList.remove(getPerson(pid))==true ? 1 : 0;
	}

}
