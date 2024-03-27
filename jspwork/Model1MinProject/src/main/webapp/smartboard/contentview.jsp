<%@page import="data.dao.SmartDao"%>
<%@page import="data.dto.SmartDto"%>
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
	<!-- 상세페이지 적당히 만들어볼것!
	작성자,글제목,내용 등등...조회수 증가도 포함
	맨아래에는 목록,글쓰기,수정,삭제버튼 만들기-->
<%
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	
	SmartDao dao=new SmartDao();
	SmartDto dto=dao.getData(num);
	
%>
<div style="margin: 50px 100px;">
<table  class="table table-bordered">
	<caption align="top"><b>상세보기</b></caption>
	<tr>
		<td>작성자</td>
		<td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><%=dto.getSubject() %></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><%=dto.getContent() %></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><%=dto.getReadcount() %></td>
	</tr>
	


</table>
</div>
</body>
</html>