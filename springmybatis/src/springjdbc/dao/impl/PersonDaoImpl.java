package springjdbc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springjdbc.dao.PersonDao;
import springjdbc.model.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<Person> selectPersonList() {
		return template.selectList("person.selectPersonList");
	}

	@Override
	public Person selectPerson(int pid) {
		return template.selectOne("person.selectPerson", pid);
	}

	@Override
	public int insertPerson(Person person) {
		return template.insert("person.insertPerson", person);
	}
	
	@Override
	public int updatePerson(Person person) {
		return template.update("person.updatePerson", person);
	}
	
	@Override
	public int deletePerson(int pid) {
		return template.delete("person.deletePerson", pid);
	}
	
}
