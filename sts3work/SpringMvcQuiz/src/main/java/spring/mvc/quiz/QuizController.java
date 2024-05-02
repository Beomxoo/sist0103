package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	//3���� �����ּҸ� �������� �ּҷ� ����ǰ� ����� ������� �ش� ������� jsp���Ͽ��� ��Ÿ���� �մϴ�
	
	@GetMapping("/happy")
	public String happy(Model model) {
		
		
		
		return "nice";
	}
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("msg", "***�� ���Ͽ� �̹����� ����ϰ���***");
		
		return "hello";
	}
	@GetMapping("nice/like")
	public String nice(Model model) {
		
		model.addAttribute("name", "��α�");
		model.addAttribute("addr", "��⵵ ������");
		model.addAttribute("hp", "010-2222-3333");
		
		return "happy";
	}
}
