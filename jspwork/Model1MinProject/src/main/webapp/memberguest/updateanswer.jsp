<%@page import="data.dao.AnswerGuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String content=request.getParameter("content");
	String idx=request.getParameter("idx");
	
	AnswerGuestDao dao=new AnswerGuestDao();
	dao.updateAnswer(idx, content);

%>
