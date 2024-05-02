package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	//@RequestMapping(value = "/", method = RequestMethod.GET) //스프링 3버전
//	@GetMapping("/")   //스프링 5버전일경우 이렇게 getmapping 사용  pom.xml에서 5.2.9.RELEASE 로 변경
//	public String hello1(Model model) {
//		model.addAttribute("name", "손범수"); //손범수라는 이름을 name에 저장
//		model.addAttribute("addr", "서울시 강남구 역삼동"); // addr에 저장
//		
//		return "result1";
//	}
}
