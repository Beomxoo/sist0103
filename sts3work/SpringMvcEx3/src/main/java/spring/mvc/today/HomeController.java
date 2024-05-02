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
		
		//request�� ����
		model.addAttribute("msg","HomeController �κ��� �������");
		model.addAttribute("today", new Date());
		
		return "home"; //WEB-INF/day0502/home.jsp
	}
	
	@GetMapping("apple/list")
	public String applelist(Model model) //forward�� ��Ű������ string -> model�� ����Ұ� �ʿ��ؼ� ���
	{
		model.addAttribute("stuName","��α�");
		model.addAttribute("stuLoc", "4������");
		
		return "stuResult1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana()   //���� forward�� model�� �ѹ��� ���ִ� �޼��� modelAndView Ÿ��(Ŭ����)
	{
		//ModelAndView�� request�� �����ϱ����� Model�� �����带 ���� view�� ���ĳ��� Ŭ����
		ModelAndView mview=new ModelAndView(); //�������̽��� �ƴϱ⶧���� ��ü�����ؾ���
		
		//request�� ����
		mview.addObject("java", 88);
		mview.addObject("mysql", 77);
		
		//�������� jsp���� ����
		mview.setViewName("scoreResult");
		
		return mview;
	}
	
	@GetMapping("/orange/select")
	public String orange(Model model,HttpSession session)
	{	
		//request�� ����
		model.addAttribute("s_msg", "������ ���� ������!!");
		//���ǿ� ����
		session.setAttribute("myid", "admin");
		
		return "orangeResult";
	}
	
	@GetMapping("/shop/detail")  //today/shop/detail
	public String resShop()
	{
		return "resResult";
	}
}
