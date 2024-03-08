<%@page import="myworld.model.WorldDto"%>
<%@page import="myworld.model.WorldDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	//한글엔코딩
	request.setCharacterEncoding("utf-8");
	
	//데이터읽기(writer,content,avata)
	String num=request.getParameter("unum");
	String writer=request.getParameter("uwriter");
	String content=request.getParameter("ucontent");
	String avata=request.getParameter("uavata");
	
	WorldDto dto=new WorldDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setAvata(avata);
	
	//dao 선언
	WorldDao dao=new WorldDao();
	//수정메서드호출
	dao.updataWorld(dto);
%>