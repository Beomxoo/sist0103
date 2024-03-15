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
<style type="text/css">
	body *{
		font-family: 'Single Day'
	}
</style>
</head>
<%
String num=request.getParameter("num");
%>
<body>
	<div style="margin: 200px 200px; width: 300px;">
		<form action="updatepassaction.jsp" method="post">
			<div class="d-inline-flex">
				<h4 style="width: 100px;">비밀번호</h4>
				<input type="text" class="form-control" required="required" name="pass" style="width: 150px;">
			</div>
			<br><br>
			<input type="hidden" name="num" value="<%=num %>">
			<button type="submit" class="btn btn-danger">수정시 필요한 비밀번호 확인</button>
			<button type="button" class="btn btn-success" onclick="history.back()">이전</button>
		</form>
	</div>
</body>
</html>