<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>

<body>

  <div style="margin: 100px 100px; width: 600px;">
  
     <table class="table table-bordered">
       <caption align="top"><b>즐겨찾기 목록</b></caption>
         <tr class="table-light" align="center">
           <th width="30">번호</th>
           <th width="100">이름</th>
           <th width="30">비고</th>
         </tr>
         <tr align="center">
         	<td>1</td>
         	<td style="vertical-align: middle;">서울만남의광장(부산방향)</td>
         	<td><button type="submit" class="btn btn-outline-danger" style="width: 100px;">삭제</button></td>
         </tr>
        <tr align="center">
         	<td>2</td>
         	<td style="vertical-align: middle;">강릉휴게소</td>
         	<td><button type="submit" class="btn btn-outline-danger" style="width: 100px;">삭제</button></td>
         </tr>
         <tr align="center">
         	<td>3</td>
         	<td style="vertical-align: middle;">가평휴게소</td>
         	<td><button type="submit" class="btn btn-outline-danger" style="width: 100px;">삭제</button></td>
         </tr>
     </table>
  </div>
</body>
</html>