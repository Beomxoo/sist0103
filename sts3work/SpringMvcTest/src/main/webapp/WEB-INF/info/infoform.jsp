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
  <div style="margin: 50px 50px;">
     <form action="result" method="post">
      <table class="table table-bordered" style="width: 400px;">
        <caption align="top"><b>infoform.jsp</b></caption>
         <tr>
           <th>이름</th>
           <td>
             <input type="text" name="name" class="form-control"
             style="width: 130px;">
           </td>
         </tr>
         
         <tr>
           <th>좋아하는 색상</th>
           <td>
             <input type="color" name="color" class="form-control"
             style="width: 160px;">
           </td>
         </tr>
         <tr>
           <th>취미</th>
           <td>
             <input type="checkbox" name="hobby" value="넷플릭스 시청">&nbsp;넷플릭스 시청<br>
             <input type="checkbox" name="hobby" value="자전거 타기">&nbsp;자전거 타기<br>
             <input type="checkbox" name="hobby" value="게임하기">&nbsp;게임하기<br>
             <input type="checkbox" name="hobby" value="책 읽기">&nbsp;책 읽기<br>
             <input type="checkbox" name="hobby" value="영화 감상">&nbsp;영화 감상
           </td>
         </tr>  
         <tr>
           <th>가장 재미있는 언어선택</th>
           <td>
            <select name="lang">
      		  <option value="java">java</option>
      		  <option value="html">html</option>
       		 <option value="ajax">ajax</option>
      		  <option value="spring">spring</option>
   			 </select>
           </td>
         </tr>  
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-info">데이터전송</button>
           </td>
         </tr>
      </table>
   </form>
  </div>
</body>
</html>