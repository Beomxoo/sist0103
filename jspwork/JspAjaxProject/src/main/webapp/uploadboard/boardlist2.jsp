
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uploadboard.data.UploadBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.data.UploadBoardDao"%>
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
<style>
	span{
		font-family: 'Nanum Pen Script';
	}
</style>
<body>
<%
	UploadBoardDao dao=new UploadBoardDao();
	List<UploadBoardDto> list=dao.getAllDatas();
	SimpleDateFormat sdf=new SimpleDateFormat();

%>
<div style="margin: 50px 100px; width: 800px;">
	<h6 class="alert alert-info">전체게시글: <%=list.size() %>개</h6>
	<%
	for(int i=0; i<list.size(); i++){
		//1번째열에 출력할번호
		int no=list.size()-i;
		UploadBoardDto dto=list.get(i);
		// 4개마다 줄바꿈을 위한 조건문
        if (i > 0 && i % 3 == 0) {
            %>
            <br><br>
            <%
        }
		%>
		<div style="width: 250px; height:300px; border: 5px groove beige;  display: inline-block; text-align: center;">
			<br>
			<img alt="" src="../save/<%=dto.getImgname()%>" style="width: 100px; height: 100px;"><br><br><br>
			<span>제목: <%=dto.getSubject()%></span><br>
			<span>작성자: <%=dto.getWriter() %></span><br>
			<span>작성일: <%=sdf.format(dto.getWriteday())%></span><br>
			<span>조회: <%=dto.getReadcount() %></span><br>
		</div>
	<%
		
	}
	%>
</div>
</body>
</html>
