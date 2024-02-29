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
	
	String name= request.getParameter("name");
	String ipsa=request.getParameter("ipsa");
	String menu= request.getParameter("menu");
	String []advice= request.getParameterValues("advice");
	

	%>
	
	<h3 class="alert alert-danger">결과출력</h3>
	<h6 class="alert alert-warning">
	사원명: <%=name %><br>
	입사일자: <%=ipsa %><br>
	오늘 선택 점심메뉴: <img alt="" src="<%=menu %>" width="100px"><br>
	건의하는 메뉴: <%
	if(advice==null){%>
		<b>건의할 메뉴가 없습니다.</b>
	<%} else{
		for(int i=0; i<advice.length; i++)
		{%>
			[<%=advice[i]%>]&nbsp;&nbsp;
		<%}%>
		<br><b>선택한개수:<%=advice.length%></b>
	<%}
	%>
	
	</h6>
	
</body>
</html>