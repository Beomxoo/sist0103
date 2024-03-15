<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<style type="text/css">
	body *{
		font-family: 'Nanum Pen Script';
		font-size: 15pt;
	}
	span.day{
		color: #ccc;
		font-size: 0.8em;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		//ajax insert
		var num=$("#num").val();
		//alert(num);
		$.ajax({
			type: "get",
			dataType: ""
		});
	});
</script>
<body>
<%
	String num=request.getParameter("num");
	SimpleBoardDao dao=new SimpleBoardDao();
	//dto
	SimpleBoardDto dto=dao.getContent(num);
	//조회수1증가
	dao.updateReadCount(num);
	//날짜
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>


<div style="margin: 50px 100px; width: 500px;">
	<table class="table table-bordered">
		<caption align="top"><b style="font-size: 19pt;"><%=dto.getSubject() %></b></caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
				&nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount() %>
			</td>
		</tr>
		<tr height="250">
			<td>
				<%=dto.getContent().replace("\n", "<br>") %>
			</td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<b class="acount">댓글<span>0</span></b>
				<div class="alist">
					댓글목록
				</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control" style="width: 80px;" placeholder="닉네임">
					<input type="text" id="content" class="form-control" style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">
					<button type="button" id="btnsend" class="btn btn-info btn-sm" style="margin-left: 10px;">저장</button>
				</div>
			</td>
		</tr>
		
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-info" onclick="location.href='addform.jsp'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
				<button type="button" class="btn btn-outline-success" onclick="location.href='boardlist.jsp'"><i class="bi bi-list-stars"></i>목록</button>
				<button type="button" class="btn btn-outline-primary" onclick="location.href='updatepassform.jsp?num=<%=dto.getNum() %>'"><i class="bi bi-pencil-square"></i>수정</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='deletepassform.jsp?num=<%=dto.getNum() %>'"><i class="bi bi-trash"></i>삭제</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>