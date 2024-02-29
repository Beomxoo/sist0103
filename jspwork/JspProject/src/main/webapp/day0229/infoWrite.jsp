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
	<%
	
	request.setCharacterEncoding("utf-8");
	
	String grade= request.getParameter("grade");
	String []lang= request.getParameterValues("lang");
	String like= request.getParameter("like");
	String height= request.getParameter("height");
	String weight= request.getParameter("weight");
	String date= request.getParameter("ipsaday");
	
	%>
	
	<h3 class="alert alert-danger">사원정보</h3>
	
	<h4 class="alert alert-info">
	
	최종학력: <%=grade %><br>
	가능 언어: <%
	if(lang==null){%>
		<b>아무언어도 못합니다.</b><br>
	<%} else {
		for(int i=0; i<lang.length; i++){%>
			[<%=lang[i]%>]&nbsp;
		<%}
	}%><br><%
	%>
	같은 조 하고싶은사람: <%=like %><br>
	키: <%=height %><br>
	몸무게: <%=weight %><br>
	선택한날짜: <%=date %><br>

	</h4>
</body>
</html>