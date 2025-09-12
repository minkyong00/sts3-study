package springmvc.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("personController")
@RequestMapping("/person")
public class PersonController {

	@GetMapping("/getPerson1.do")
	public ModelAndView getPerson1(ModelAndView mav) {
		mav.addObject("name", "홍길동");
		mav.addObject("age", 20);
		mav.setViewName("getPerson");
		return mav;
	}

	@GetMapping("/getPerson2.do")
	public String getPerson2(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 20);
		return "getPerson";
	}
	
}
