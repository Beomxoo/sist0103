<%@page import="ajaxboard.AjaxBoardDao"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글엔코딩
	request.setCharacterEncoding("utf-8");
	
	//데이터읽기(writer,subject,content,avata)
	String num=request.getParameter("unum");
	String writer=request.getParameter("uwriter");
	String subject=request.getParameter("usubject");
	String content=request.getParameter("ucontent");
	String avata=request.getParameter("uavata");
	
	AjaxBoardDto dto=new AjaxBoardDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setAvata(avata);
	
	AjaxBoardDao dao=new AjaxBoardDao();
	dao.updateBoard(dto);
%>
