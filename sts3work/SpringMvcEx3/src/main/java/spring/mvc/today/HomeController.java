package spring.mvc.today;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home(Model model) {
		
		//request에 저장
		model.addAttribute("msg","HomeController 로부터 포워드됨");
		model.addAttribute("today", new Date());
		
		return "home"; //WEB-INF/day0502/home.jsp
	}
	
	@GetMapping("apple/list")
	public String applelist(Model model) //forward를 시키기위한 string -> model은 저장소가 필요해서 사용
	{
		model.addAttribute("stuName","김민규");
		model.addAttribute("stuLoc", "4강의장");
		
		return "stuResult1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana()   //위에 forward와 model를 한번에 해주는 메서드 modelAndView 타입(클래스)
	{
		//ModelAndView는 request에 저장하기위한 Model과 포워드를 위한 view를 합쳐놓은 클래스
		ModelAndView mview=new ModelAndView(); //인터페이스가 아니기때문에 객체생성해야함
		
		//request에 저장
		mview.addObject("java", 88);
		mview.addObject("mysql", 77);
		
		//포워드할 jsp파일 지정
		mview.setViewName("scoreResult");
		
		return mview;
	}
	
	@GetMapping("/orange/select")
	public String orange(Model model,HttpSession session)
	{	
		//request에 저장
		model.addAttribute("s_msg", "스프링 매핑 연습중!!");
		//세션에 저장
		session.setAttribute("myid", "admin");
		
		return "orangeResult";
	}
	
	@GetMapping("/shop/detail")  //today/shop/detail
	public String resShop()
	{
		return "resResult";
	}
}
