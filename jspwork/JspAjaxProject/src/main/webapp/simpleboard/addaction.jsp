<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String writer=request.getParameter("writer");
	String subject=request.getParameter("subject");
	String pass=request.getParameter("pass");
	String content=request.getParameter("content");
	
	SimpleBoardDto dto=new SimpleBoardDto();
	dto.setWriter(writer);
	dto.setSubject(subject);
	dto.setPass(pass);
	dto.setContent(content);
	
	SimpleBoardDao dao=new SimpleBoardDao();
	dao.insert(dto);
	//목록
	 //response.sendRedirect("boardlist.jsp");
	//insert후 내용보기로 이동하려면 방금 insert된 num의 값을 알아야한다.
	int num=dao.getMaxNum();
	response.sendRedirect("contentview.jsp?num="+num);
	 
	 
%>
</body>
</html>