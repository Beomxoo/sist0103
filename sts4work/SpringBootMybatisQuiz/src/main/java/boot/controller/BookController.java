package boot.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import boot.data.BookDto;
import boot.data.BookMapperInter;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {
	
	@Autowired
	BookMapperInter mapper;
	
	@GetMapping("/")
	public String start()
	{
		
		return "redirect:book/list";
	}
	
	
	@GetMapping("/book/list")
	public String list(Model model)
	{
		int totalCount=mapper.getTotalCount();
		List<BookDto> list=mapper.getAllDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "book/booklist";
	}
	
	@GetMapping("/book/addform")
	public String addform()
	{
		return "book/addform";
	}
	
	@PostMapping("/book/insert")
	public String insert(@ModelAttribute BookDto dto,@RequestParam MultipartFile photo,HttpServletRequest request)
	{
		String path=request.getServletContext().getRealPath("/bookphoto");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setBookimage("no"); 
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setBookimage(photoname);
			
			try {
				photo.transferTo(new File(path+ "\\"+ photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mapper.insertBook(dto);
		
		return "redirect:list";
	}
}
