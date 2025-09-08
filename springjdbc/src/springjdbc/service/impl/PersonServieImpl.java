package springjdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springjdbc.dao.PersonDao;
import springjdbc.model.Person;
import springjdbc.service.PersonService;

@Service("personService")
public class PersonServieImpl implements PersonService{
	
	@Autowired
	private PersonDao personDao;

	@Override
	public List<Person> selectPersonList() {
		return personDao.selectPersonList();
	}
	
	@Override
	public Person selectPerson(int pid) {
		return personDao.selectPerson(pid);
	}
	
	@Override
	public int insertPerson(Person person) {
		return personDao.insertPerson(person);
	}
	
	@Override
	public int updatePerson(Person person) {
		return personDao.updatePerson(person);
	}
	
	@Override
	public int deletePerson(int pid) {
		return personDao.deletePerson(pid);
	}
}
