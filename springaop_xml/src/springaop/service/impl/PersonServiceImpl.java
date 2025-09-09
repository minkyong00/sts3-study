package springaop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springaop.model.Person;
import springaop.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Override
	public List<Person> listPerson() {
		System.out.println("### listPerson 호출됨!");
		return PersonService.super.listPerson();
	}

	@Override
	public Person getPerson(int pid) {
		System.out.println("### getPerson 호출됨!");
		return PersonService.super.getPerson(pid);
	}

	@Override
	public int insertPerson(Person person) {
		System.out.println("### insertPerson 호출됨!");
		return PersonService.super.insertPerson(person);
	}
	
	@Override
	public int updatePerson(Person person) {
		System.out.println("### updatePerson 호출됨!");
		return PersonService.super.updatePerson(person);
	}

	@Override
	public int deletePerson(int pid) {
		System.out.println("### deletePerson 호출됨!");
		return PersonService.super.deletePerson(pid);
	}
	
}
