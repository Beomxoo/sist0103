package spring.mvc.test;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoController {
	
	@GetMapping("info/myform")
	public String start() {
		return "info/infoform";
	}
	@PostMapping("info/result")
	public String result(Model model,InfoDto dto) {
		
		ArrayList<String> hobby=new ArrayList<String>();
		hobby=dto.getHobby();
		
		
		if(hobby.size()==0) {
			hobby.add("¾øÀ½");
			dto.setHobby(hobby);
		} 
		
	
		
		model.addAttribute("dto", dto);
		
		
		return "info/infowrite";
	}
}
