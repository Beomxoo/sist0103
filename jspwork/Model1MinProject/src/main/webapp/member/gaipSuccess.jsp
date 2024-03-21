<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
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
<%	
	String id=request.getParameter("id");
	MemberDao dao=new MemberDao();
	String name=dao.getName(id);
	
%>
<body>
<div style="margin: 100px 250px;">
	<img alt="" src="image2/flower_ani/s6.JPG">
	<b><%=name %>님의 회원가입을 축하합니다</b>
	<br><br>
	<button type="button" class="btn btn-info" onclick="location.href='index.jsp?main=login/loginmain.jsp'">로그인</button>
	<button type="button" class="btn btn-success" onclick="location.href='index.jsp?main=member/mypage.jsp'">마이페이지</button>
</div>
</body>
</html>