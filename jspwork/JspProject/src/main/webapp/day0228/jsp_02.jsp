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

	<h3>멤버변수 출력</h3><br>
	<b>이름: <%=name %></b><br>
	<b>전화번호: <%=hp %></b><br><br>
	<%!
		String name="홍길동";
		String hp="010-1234-5678";
		int age=22;
		
		//메서드
		public String getCheck(){
			if(age>=20){
				return "성인입니다.";
			} else{
				return "미성년자입니다.";
			}
		}
	%>
	
	<%=name %>님의 나이는 <%=age%>세 입니다.<br>
	<%=getCheck() %>
	
	<%
		String addr="강원도 속초시";
		String major="경영학과";
		out.print(name+"님의 전공은 "+ major + "입니다<br>");  //자바의 내장객체 (그러나 html출력이 원칙임)
	%>
	
	<h5>주소: <%=addr %></h5>
	<h5>전공: <%=major %></h5>
</body>
</html>