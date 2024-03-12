<%@page import="quizshop.model.QuizShopDto"%>
<%@page import="quizshop.model.QuizShopDao"%>
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
<%
  String num=request.getParameter("num");
  QuizShopDao dao=new QuizShopDao();
  QuizShopDto dto=dao.getOneData(num);
  
  
%>
<body>
	<!-- 이미지가 크게 나오고 옆에 설명 추가  [맨아래 목록,수정,삭제 버튼 3개 추가]
	설명:  상품명, 가격 , 입고일 
	상품명을 누르면 디테일페이지 들어와짐-->  
	<h3 class="alert alert-info">상품 상세보기</h3>
	<div style="float: left; margin: 50px 50px;">
		<img src="../image/쇼핑몰사진/<%=dto.getPhoto() %>.jpg">
	</div>
	<div style="float: left; margin-top: 50px; width: 300px; height: 300px;">
	<table class="table table-bordered">
	<form action="#" method="post" name="frm">
		<input type="hidden" name="num" value="<%=num%>">
          <caption align="top"><b>클릭한 상품정보</b></caption>
            <tr>
              <th width="100" class="table-info">상품명</th>
              <td>
                <input type="text" name="sang_name" 
                 class="form-control" style="width: 200px;" value=" <%=dto.getSang_name()%>">
              </td>
            </tr>
            <tr>
              <th width="100" class="table-warning">가격</th>
              <td>
                <input type="text" name="sang_name" 
                 class="form-control" style="width: 200px;" value="<%=dto.getPrice()%>">
              </td>
            </tr>
            <tr>
              <th width="100" class="table-danger">입고일</th>
              <td>
              <input type="date" name="sang_name" 
                 class="form-control" style="width: 200px;" value=<%=dto.getIpgoday()%>>
              </td>
            </tr>
            <tr>
              <td colspan="2" align="center">
                <input type="submit" value="수정" class="btn btn-outline-warning">
                <input type="button" value="삭제" class="btn btn-outline-danger">
                <input type="button" value="목록" class="btn btn-outline-success"
                onclick="location.href='shoplist.jsp'">
              </td>
            </tr>
           </table>
     </table>
	</div>
	
</body>
</html>