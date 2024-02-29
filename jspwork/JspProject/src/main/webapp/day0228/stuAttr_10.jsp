<%@page import="test.Student"%>
<%@page import="java.util.Vector"%>
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
	<h3>request에 Vector 저장후 불러오는 연습</h3>
	
	<%
		Vector<Student> list= new Vector<>();
		list.add(new Student("김태희", "강남구", 90));
		list.add(new Student("김지훈", "서초구", 60));
		list.add(new Student("이서연", "관악구", 56));
		list.add(new Student("이창수", "강원도 강릉", 88));
		list.add(new Student("주하윤", "인천 검단", 93));
		
		//데이터 vector를 request에 저장
		request.setAttribute("list", list);
		
		//페이지이동2: forward(url주소 안바뀜) redirect(url주소바뀜)
		
	%>
	
	<jsp:forward page="stuForward_10.jsp"/>
</body>
</html>