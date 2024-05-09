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
	<div style="margin: 50px 100px; width: 800px;">
		<button type="button" class="btn btn-info" onclick="location.href='writeform'">회원가입</button>
		<button type="button" class="btn btn-danger" onclick="location.href='../index.jsp'">메인</button>
		
		<br><br>
		<c:if test="${count==0}">
			<h2 class="alert alert-warning">회원정보가 없습니다</h2>
		</c:if>
		<c:if test="${count>0}">
			<h2 class="alert alert-warning">총 ${count} 명의 회원이 있습니다</h2>
			<hr>
			<table class="table table-bordered">
				<tr class="table-primary" style="text-align: center; vertical-align: middle;">
					<th width="60">번호</th>
					<th width="100">회원명</th>
					<th width="120">아이디</th>
					<th width="150">핸드폰</th>
					<th width="150">가입일</th>
					<th width="120">편집</th>			
				</tr>
				<c:forEach var="dto" items="${list}" varStatus="i">
					<tr align="center" style="vertical-align: middle;">
						<td>${i.count}</td>
						<td>${dto.name}</td>
						<td>${dto.id}</td>
						<td>${dto.hp}</td>
						<td>
							${dto.gaipday}
						</td>
						<td>
							<button type="button" class="btn btn-info btn-sm"
							onclick="location.href=''">수정</button>
							<button type="button" class="btn btn-danger btn-sm"
							onclick="location.href=''">삭제</button>					
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</c:if>
	</div>
</body>
</html>