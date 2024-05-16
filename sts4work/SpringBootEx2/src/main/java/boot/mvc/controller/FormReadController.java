package boot.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.InfoDto;

@Controller
public class FormReadController {
	
	@PostMapping("/sist/read1")
	public ModelAndView read1(@RequestParam String name, @RequestParam int java, @RequestParam int spring)
	{
		ModelAndView mview=new ModelAndView();
		
		int tot=java+spring;
		int avg= tot/2;
		
		
		mview.addObject("name", name);
		mview.addObject("java", java);
		mview.addObject("spring", spring);
		mview.addObject("tot", tot);
		mview.addObject("avg", avg);
		
		mview.setViewName("result/result1");
		
		return mview;
	}
	
	@PostMapping("/sist/show2")
	public ModelAndView show2(@ModelAttribute InfoDto dto)
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("dto", dto);
		
		mview.setViewName("result/result2");
		
		return mview;
	}
	
	@PostMapping("/sist/write3")
	//map으로 읽을경우 폼의 name이 key값, 입력값이 value
	public ModelAndView result3(@RequestParam Map<String, String> map)
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("name", map.get("name"));
		mview.addObject("blood", map.get("blood"));
		mview.addObject("buseo", map.get("buseo"));
		
		mview.setViewName("result/result3");
		
		return mview;
	}
	
	

}
