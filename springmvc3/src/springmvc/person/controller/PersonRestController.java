package springmvc.person.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springmvc.person.model.Person;
import springmvc.person.service.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:9999")
public class PersonRestController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public Map<String, Object> listPerson() {
		List<Person> personList = personService.listPerson();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(personList!=null) {
			resultMap.put("size", personList.size());
		} else {
			resultMap.put("size", 0);
		}
		resultMap.put("personList", personList);
		return resultMap;
	}
	
	@GetMapping("/{pid}")
	public Person getPerson(@PathVariable int pid) {
		return personService.getPerson(pid);
	}
	
	@PostMapping("/")
	public Map<String, Object> insertPerson(@RequestBody Person person) {
		int result = personService.insertPerson(person);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("person", person);
		
		return resultMap;
	}
	
	@PutMapping("/")
	public Map<String, Object> updatePerson(@RequestBody Person person) {
		int result = personService.updatePerson(person);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("person", person);
		
		return resultMap;
	}
	
	@DeleteMapping("/{pid}")
	public Map<String, Object> deletePerson(@PathVariable int pid) {
		int result = personService.deletePerson(pid);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
}




























