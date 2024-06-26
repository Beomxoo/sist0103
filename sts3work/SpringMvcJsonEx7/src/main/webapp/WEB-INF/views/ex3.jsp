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
	<h3 class="alert alert-success">Ex3번 예제</h3>
	<br>
	<h4>메뉴 이름을 입력후 엔터를 눌러주세요</h4>
	<input type="text" id="search" class="form-control" style="width: 150px;">
	<br><br>
	<h2 id="fname"></h2>
	<img alt="" src="" id="photo" width="100">
	
	<script type="text/javascript">
		$(function(){
			$("#search").keypress(function(e){
				if(e.keyCode === 13) {
					var foodname = $(this).val();
					
					$.ajax({
						type:"get",
						dataType:"json",
						data: { foodname: foodname },
						url:"foodlist3",
						success:function(res){
							
							$("#fname").text(res.foodname);
							$("#photo").attr("src","upload/"+ res.photo);
							$("#search").val('');
						}
					})
				}
			});
		})
	</script>
</body>
</html>