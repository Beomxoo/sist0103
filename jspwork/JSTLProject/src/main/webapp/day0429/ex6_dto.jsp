<%@page import="java.util.ArrayList"%>
<%@page import="jstl.data.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	List<Student> list=new ArrayList<>();

	list.add(new Student("김영민","서울시 서초구",90));
	list.add(new Student("강호동","서울시 마포구",80));
	list.add(new Student("유재석","서울시 관악구",78));
	list.add(new Student("이영자","서울시 동작구",95));
	
	request.setAttribute("list",list);
%>

<table class="table table-bordered" style="width: 500px;">
	<tr>
		<th>번호</th>
		<th>인덱스</th>
		<th>이름</th>
		<th>주소</th>
		<th>점수</th>
	</tr>
	
	<c:set var="sum" value="0"/>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<!--items (리스트가 받아올 배열명) varStatus(상태변수)-->
		<tr>
			<td>${i.count}</td>
			<td>${i.index}</td>
			<td>${dto.name}</td>
			<td>${dto.addr}</td>
			<td>${dto.score}</td>
			<c:set var="sum" value="${sum+dto.score}"/>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5">
			<h3>점수의 총 합계는 ${sum }점입니다</h3>
	</tr>
</table>
</body>
</html>