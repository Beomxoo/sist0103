<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="quizWrite.jsp" method="post">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<th width="100" class="table-info">사원명</th>
				<td><input type="text" name="name" placeholder="사원명"
					required="required" class="form-control" style="width: 120px">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-info">입사일자</th>
				<td><input type="date" name="ipsa" placeholder="입사일자"
					required="required" class="form-control" style="width: 180px">
				</td>
			</tr>
			<tr>
				<th width="130" class="table-info">오늘 점심메뉴</th>
				<td>
				<input type="radio" name="menu" value="../image/Food/burger.png">햄버거
				<input type="radio" name="menu" value="../image/Food/pizza.png">피자
				<input type="radio" name="menu" value="../image/Food/chicken.png">치킨
				</td>
			</tr>
			<tr>
				<th width="130" class="table-info">건의하는 메뉴</th>
				<td>
					<select name="advice" class="form-control" style="width: 100px" multiple="multiple">
						<option value="쌀국수">쌀국수</option>
						<option value="마라탕">마라탕</option>
						<option value="돈까스">돈까스</option>
						<option value="마라샹궈">마라샹궈</option>
						<option value="꿔바로우">꿔바로우</option>
						<option value="스시">스시</option>
						<option value="순대국">순대국</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-success" value="전송" style="width: 100px">
					<input type="reset" class="btn btn-warning" value="초기화" style="width: 100px">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>