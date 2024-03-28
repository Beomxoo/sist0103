<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="data.dto.SmartAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String anum=request.getParameter("anum");
	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	
	SmartAnswerDto dto=new SmartAnswerDto();
	SmartAnswerDao dao=new SmartAnswerDao();
	
	dto.setNum(anum);
	dto.setNickname(nickname);
	dto.setContent(content);

	dao.insertAnswer(dto);
%>
