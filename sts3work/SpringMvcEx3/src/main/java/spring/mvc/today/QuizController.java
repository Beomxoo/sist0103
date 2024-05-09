package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {
	
	@GetMapping("sist/java/four")
	public ModelAndView quizProcess() {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("quiz_title", "***�̹��� ��� ����***");
		
		//�������� view
		mview.setViewName("quizResult");
		
		return mview;
	}
}