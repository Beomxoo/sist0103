package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	//@RequestMapping(value = "/", method = RequestMethod.GET) //������ 3����
//	@GetMapping("/")   //������ 5�����ϰ�� �̷��� getmapping ���  pom.xml���� 5.2.9.RELEASE �� ����
//	public String hello1(Model model) {
//		model.addAttribute("name", "�չ���"); //�չ������ �̸��� name�� ����
//		model.addAttribute("addr", "����� ������ ���ﵿ"); // addr�� ����
//		
//		return "result1";
//	}
}
