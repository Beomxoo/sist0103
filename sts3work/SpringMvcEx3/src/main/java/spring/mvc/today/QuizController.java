package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {
	
	@GetMapping("sist/java/four")
	public ModelAndView quizProcess() {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("quiz_title", "***이미지 출력 퀴즈***");
		
		//포워드할 view
		mview.setViewName("quizResult");
		
		return mview;
	}
}
