package myshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import myshop.dto.ShopDto;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor
public class MyShopController {
	
	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model)
	{
		int totalCount=shopService.getTotalCount();
		List<ShopDto> list=shopService.getAllSangpums();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "myshop/shoplist";
	}
	
	@GetMapping("/addform")
	public String form()
	{
		return "myshop/shopform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto,@RequestParam MultipartFile upload, HttpServletRequest request)
	{
		String path=request.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		String photoname=sdf.format(new Date())+ upload.getOriginalFilename();
		dto.setPhoto(photoname);
		
		try {
			upload.transferTo(new File(path+ "\\" + photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		shopService.insertShop(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int num,Model model)
	{
		ShopDto dto=shopService.getOneDataShop(num);
		
		model.addAttribute("dto", dto);
		
		return "myshop/shopdetail";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam int num,HttpSession session)
	{
		String photo=shopService.getOneDataShop(num).getPhoto();
		
			String path=session.getServletContext().getRealPath("/photo");
			File file=new File(path+ "\\"+ photo);
			
			if(file.exists()) {
				file.delete();
			}
		
		
		shopService.deleteShop(num);
		
		return "redirect:/";
	}
	
	
	
}
