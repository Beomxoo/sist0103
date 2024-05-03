<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="background-color: ${dto.color}; width: 400px; border-radius: 3px; margin: 50px 50px;">
		<h2>**결과출력**</h2>
		이름: ${dto.name }<br>
		좋아하는 색상: ${dto.color }<br>
		취미:
		<c:forEach var="hobby" items="${dto.hobby}" varStatus="loop" >
			[${hobby }]
		</c:forEach>
<%-- 		취미: ${dto.hobby }<br> --%>
		<br>가장 재미있는 언어선택: ${dto.lang }
	</div>
</body>
</html>