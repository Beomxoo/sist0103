package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	//3개의 매핑주소를 포워드한 주소로 연결되게 만들고 결과물은 해당 포워드된 jsp파일에서 나타나게 합니다
	
	@GetMapping("/happy")
	public String happy(Model model) {
		
		
		
		return "nice";
	}
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("msg", "***이 파일에 이미지를 출력하겠음***");
		
		return "hello";
	}
	@GetMapping("nice/like")
	public String nice(Model model) {
		
		model.addAttribute("name", "김민규");
		model.addAttribute("addr", "경기도 구리시");
		model.addAttribute("hp", "010-2222-3333");
		
		return "happy";
	}
}
