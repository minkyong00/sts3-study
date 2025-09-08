package springjdbc.service;

import java.util.List;

import springjdbc.model.Person;

public interface PersonService {

	public default List<Person> selectPersonList(){ return null; }
	
	public default Person selectPerson(int pid) { return null; }
	
	public default int insertPerson(Person person) { return 0; }
	
	public default int updatePerson(Person person) { return 0; }
	
	public default int deletePerson(int pid) { return 0; }
	
}
