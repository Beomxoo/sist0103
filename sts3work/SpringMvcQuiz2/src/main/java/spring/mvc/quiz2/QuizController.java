package spring.mvc.quiz2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
	
	@GetMapping("/")
	public String start() {
		
		return "redirect:testform";
	}
	
	@GetMapping("/testform")
	public String form() {
		
		return "testform";
	}
	
	@PostMapping("/info")
	public String process(Model model, SawonDto dto)
	{
		model.addAttribute("dto",dto);
		
		return "sawoninfo";
	}
}
