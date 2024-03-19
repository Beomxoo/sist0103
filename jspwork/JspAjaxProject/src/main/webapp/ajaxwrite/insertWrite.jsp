<%@page import="ajaxwrite.model.AjaxWriteDao"%>
<%@page import="ajaxboard.AjaxBoardDao"%>
<%@page import="ajaxwrite.model.AjaxWriteDto"%>
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
	//post방식
	request.setCharacterEncoding("utf-8");

	String writer=request.getParameter("writer");
	String subject=request.getParameter("subject");
	String story=request.getParameter("story");
	String image=request.getParameter("image");
	
	AjaxWriteDto dto=new AjaxWriteDto();
	dto.setWriter(writer);
	dto.setSubject(subject);
	dto.setStory(story);
	dto.setImage(image);
	
	AjaxWriteDao dao=new AjaxWriteDao();
	
	dao.insertWrite(dto);

%>
</body>
</html>