<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin: 100px 100px;">
	<h2>도서정보 입력</h2>
	<form action="insert" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 400px; text-align: center; vertical-align: middle;">
			<tr>
				<th width="100" class="table-light">도서명</th>
				<td>
					<input type="text" name="bookname" class="form-control" style="width: 250px;" required="required"> 
				</td>
			</tr>
			<tr>
				<th width="100" class="table-light">작가</th>
				<td>
					<input type="text" name="writer" class="form-control" style="width: 130px;" required="required"> 
				</td>
			</tr>
			<tr>
				<th width="100" class="table-light">가격</th>
				<td>
					<input type="text" name="bookprice" class="form-control" style="width: 130px;"> 
				</td>
			</tr>
			<tr>
				<th width="100" class="table-light">도서이미지</th>
				<td>
					<input type="file" name="photo" class="form-control" style="width: 250px;"> 
				</td>
			</tr>
			<tr>
				<th width="100" class="table-light">출판사</th>
				<td>
					<input type="text" name="bookcompany" class="form-control" style="width: 130px;"> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-outline-info">등록</button>
					<button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>