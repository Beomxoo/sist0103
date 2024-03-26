<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.bi-camera{
		color: purple;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("i.camera").click(function(){
			$("#photo").trigger("click");
		})
	})
	
	function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
        reader.onload = function (e) {
        //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
            $('#showing').attr('src', e.target.result);
            //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
            //(아래 코드에서 읽어들인 dataURL형식)
        }                   
        reader.readAsDataURL(input.files[0]);
        //File내용을 읽어 dataURL형식의 문자열로 저장
    }
}//readURL()--

	
</script>
</head>
<%
	//num,currentPage
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	
	GuestDao dao=new GuestDao();
	GuestDto dto=dao.getData(num);
%>
<body>
<!-- 이미지미리보기 -->
<img id="showing" style="position: absolute; left: 800px; top: 100px; max-width: 200px;" src="<%=(dto.getPhotoname()==null?"":"save/"+dto.getPhotoname()) %>">

<div style="margin: 50px 100px; width: 600px;">
	<form action="memberguest/updateaction.jsp" method="post" enctype="multipart/form-data">
	<!--  num hidden 처리할때, 페이징처리시는 currentPage도 hidden처리 필수 -->
	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="currentPage" value="<%=currentPage %>">
		<table class="table table-bordered">
			<caption align="top">
				<b>방명록 수정</b>&nbsp;&nbsp;
				<i class="bi bi-camera fs-2 camera"></i>
				<input type="file" name="photo" id="photo" style="visibility: hidden;" onchange="readURL(this)" >
			</caption>
			<tr>
				<td>
					<textarea style="width: 500px; height: 100px;" name="content" class="form-control" required="required"><%=dto.getContent() %></textarea>
				</td>
				<td>
					<button type="submit" class="btn btn-warning" style="width: 100px; height: 100px;">수정</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>