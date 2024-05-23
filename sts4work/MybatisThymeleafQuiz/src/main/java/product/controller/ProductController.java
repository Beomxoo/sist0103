package product.controller;

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
import lombok.RequiredArgsConstructor;
import product.dto.ProductDto;
import product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:product/list";
	}
	
	
	@GetMapping("/product/list")
	public String list(Model model)
	{
		int totalCount=productService.getTotalCount();
		List<ProductDto> list=productService.getAllDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "product/productlist";
	}
	
	@GetMapping("/product/form")
	public String addform()
	{
		return "product/addform";
	}
	
	@PostMapping("/product/insert")
	public String insert(@ModelAttribute ProductDto dto,@RequestParam MultipartFile upload,HttpServletRequest request)
	{
		String path=request.getServletContext().getRealPath("/productimage");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		String photoname=sdf.format(new Date())+ upload.getOriginalFilename();
		dto.setPro_image(photoname);
		
		try {
			upload.transferTo(new File(path+ "\\" + photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productService.insertProduct(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/product/detail")
	public String detail(@RequestParam int num,Model model)
	{
		ProductDto dto=productService.getOneData(num);
		
		model.addAttribute("dto", dto);
		
		
		return "product/productdetail";
	}
	
}
