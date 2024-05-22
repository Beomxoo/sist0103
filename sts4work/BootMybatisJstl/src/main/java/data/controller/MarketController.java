package data.controller;

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
import org.springframework.web.servlet.ModelAndView;

import data.dto.MarketDto;
import data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {
	
	@Autowired
	MarketMapperInter mapper;
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:market/list";
	}
	
	@GetMapping("/market/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		//db로부터 총갯얻기
		int totalCount=mapper.getTotalCount();
		List<MarketDto> list=mapper.getAllDatas();
		
		//저장
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		//포워드
		mview.setViewName("market/marketlist");
		return mview;
	}
	
	@GetMapping("/market/addform")
	public String form()
	{
		return "market/addform";
	}
	
	@PostMapping("/market/insert")
	public String insert(@ModelAttribute MarketDto dto,@RequestParam MultipartFile photo,HttpServletRequest request)
	{
		
		String path=request.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname("no"); 
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
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
		mapper.insertMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/market/updateform")
	public ModelAndView updateform(@RequestParam String num)
	{
		ModelAndView mview=new ModelAndView();
		
		MarketDto dto=mapper.getData(num);
		
		mview.addObject("dto", dto);
		mview.setViewName("market/updateform");
		
		
		return mview;
	}
	
	@PostMapping("/market/update")
	public String update(@ModelAttribute MarketDto dto,@RequestParam MultipartFile photo,HttpServletRequest request)
	{
		
		String path=request.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname("no"); 
		} else {
			
			//수정전에 이전사진 지우기
			String pre_photo=mapper.getData(dto.getNum()).getPhotoname();
			File file=new File(path+"\\"+ pre_photo);
			
			if(file.exists()) {
				file.delete();				
			}

			
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
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
		//db에 업데이트
		mapper.updateMarket(dto);
		
		return "redirect:list";
	}
	
	
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num,HttpSession session)
	{
		String photo=mapper.getData(num).getPhotoname();
		if(!photo.equals("no")) {
			String path=session.getServletContext().getRealPath("/photo");
			File file=new File(path+ "\\"+ photo);
			
			if(file.exists()) {
				file.delete();
			}
		}
		mapper.deleteMarket(num);
		
		return "redirect:list";
	}
}
