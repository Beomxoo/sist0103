package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.data.PhotoDto;

@Controller

public class JsonTestController {
	
	@GetMapping("/list1")
	@ResponseBody
	public Map<String, String> list1()
	{
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "±è¹Î±Ô");
		map.put("hp", "010-1111-2222");
		map.put("addr", "¼­¿ï½Ã ¸¶Æ÷±¸");
		
		return map;
	}
	
	@GetMapping("/foodlist2")
	@ResponseBody
	public List<PhotoDto> list2()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("»÷µåÀ§Ä¡", "1.jpg"));
		list.add(new PhotoDto("²¿Ä¡±¸ÀÌ", "2.jpg"));
		list.add(new PhotoDto("¸Á°íºù¼ö", "11.jpg"));
		list.add(new PhotoDto("¼øµÎºÎ¶ó¸é", "12.jpg"));
		list.add(new PhotoDto("¸®Á¶¶Ç", "5.jpg"));
		
		return list;
	}
}
