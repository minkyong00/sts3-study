package springmvc.person.service;

import java.util.List;

import springmvc.person.model.Person;

public interface PersonService {
	
	public default List<Person> listPerson() { return null; }

	public default Person getPerson(int pid) { return null; }

	public default int insertPerson(Person person) { return 0; }
	
	public default int updatePerson(Person person) { return 0; }
	
	public default int deletePerson(int pid) { return 0; }
	
}
