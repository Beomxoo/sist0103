<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>
</head>
<body>

	<div style="margin: 100px; width: 500px">
		<form action="insert" method="post">
			<table class="table table-bordered">
				<caption align="top">
					<b>상품정보</b>
				</caption>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="sangname" class="form-control"
						style="width: 150px;" required="required"></td>
				</tr>
				<tr>
					<th>상품가격</th>
					<td><input type="text" name="sangprice" class="form-control"
						style="width: 150px;" required="required"></td>
				</tr>
				<tr>
					<th>상품색상</th>
					<td><input type="color" name="sangcolor" class="form-control"
						style="width: 200px;" required="required"></td>
				</tr>
				<tr>
					<th>입고일</th>
					<td><input type="date" name="sangipgo" class="form-control"
						style="width: 250px;" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" class="btn btn-info" value="저장"> 
						<input type="button" class="btn btn-info" value="목록" onclick="location.href='list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>