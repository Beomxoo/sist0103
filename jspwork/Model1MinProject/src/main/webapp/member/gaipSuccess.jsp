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
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	
	MemberDao dao=new MemberDao();
	MemberDto dto=dao.getName(id);
	
%>
<body>
<h3>가입성공화면</h3><br><br>
<h5><%=dto.getName()%>님의 가입을 환영합니다.</h5><br><br>
<input type="button" value="로그인" class="btn btn-info"> 
<input type="button" value="메인화면" class="btn btn-success"> 

</body>
</html>