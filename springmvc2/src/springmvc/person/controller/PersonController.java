package springmvc.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.person.model.Person;
import springmvc.person.service.PersonService;

@Controller("personController")
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	// 실습
	// /jsp/person 디렉토리 listPerson.jsp, getPerson.jsp, insertPersonForm.jsp 생성

	// listPerson.do
	@RequestMapping("/listPerson.do")
	public ModelAndView listPerson(ModelAndView mav) {
		mav.addObject("personList", personService.listPerson());
		mav.setViewName("listPerson");
		return mav;
	}
	
	// getPerson.do
	@RequestMapping("/getPerson.do")
	public ModelAndView getPerson(@RequestParam int pid) {
		return new ModelAndView("getPerson", "person", personService.getPerson(pid));
	}
	
	// insertPersonForm.do
	@RequestMapping("/insertPersonForm.do")
	public String insertPersonForm() {
		return "insertPersonForm";
	}
	
	// insertPersonProc.do
	@RequestMapping("/insertPersonProc.do")
	public String insertPresonProc(@ModelAttribute Person person) {
		if(person!=null) {
			personService.insertPerson(person);
		}
		return "redirect:/person/listPerson.do";
	}

	// updatePersonForm.do
	@RequestMapping("/updatePersonForm.do")
	public String updatePersonForm(@RequestParam int pid, Model model) {
		model.addAttribute("person", personService.getPerson(pid));
		return "insertPersonForm";
	}
	
	// updatePersonProc.do
	@RequestMapping("/updatePersonProc.do")
	public String updatePersonProc(@ModelAttribute Person person) {
		if(person!=null) {
			personService.updatePerson(person);
		}
		return "redirect:/person/listPerson.do";
	}
	
	// deletePerson.do
	@RequestMapping(value = "/deletePerson.do")
	public String deletePerson(@RequestParam int pid) {
		personService.deletePerson(pid);
		return "redirect:/person/listPerson.do";
	}
	
	
}


























