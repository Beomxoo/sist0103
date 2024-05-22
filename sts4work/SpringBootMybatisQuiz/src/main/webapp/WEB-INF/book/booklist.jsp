<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
table, th, td{
	border: none;
	border-collapse: collapse;
}
/* 모든 테두리 제거 */
table th, table td {
  border-top: none;
  border-bottom: none;
}
/* 각 테이블의 tr 요소에 대한 스타일 */
table tr {
  border-top: none;
  border-bottom: none;
}
.btnbtnbtn{
	width: 50px;
	height: 30px;
	font-size: 12px;
	
}
</style>
</head>
<body>
 <div style="margin: 100px 100px;">
   <button type="button" class="btn btn-outline-info"
   onclick="location.href='addform'">상품등록</button>
   <br><br>
   <c:if test="${totalCount==0 }">
  <div class="alert alert-info">
    <b>저장된 정보가 없습니다</b>
  </div>
</c:if>
<c:if test="${totalCount>0 }">
  <div class="alert alert-warning">
    <b>총 ${totalCount }개의 도서정보가 있습니다</b>
  </div>
</c:if>

<br>

<c:forEach var="a" items="${list }">
    <div class="d-inline-flex"  style="width: 200px; margin-right: 30px;">
   <table class="table table-bordered" style="width: 200px;">
      <tr>
        <td>
          <c:if test="${a.bookimage!='no' }">
            <img alt="" src="../bookphoto/${a.bookimage }" style="width: 200px; height: 300px;"align="left">
          </c:if> 
          <c:if test="${a.bookimage=='no' }">
            <img alt="" src="../bookphoto/noimage.png" style="width: 150px;" align="left">  
          </c:if>
        </td>
      </tr>
      <tr>
       <td><b>${a.bookname}</b></td>
      </tr>
      <tr>
       <td style="font-size: 0.7em;">
       저자: ${a.writer}<br>
       	출판사: ${a.bookcompany}<br>
       	가격: <fmt:formatNumber value="${a.bookprice }" type="currency"/><br>
       	입고날짜: <fmt:formatDate value="${a.ipgoday }" pattern="yyyy-MM-dd"/>
       
       </td>
      </tr>
      <tr>
      	<td align="center">
      		 <button type="button" class="btn btn-outline-warning btnbtnbtn"
             onclick="location.href='updateform?num=${a.num}'">수정</button>
             <button type="button" class="btn btn-outline-danger btnbtnbtn"
             onclick="location.href='delete?num=${a.num}'">삭제</button>
      	</td>
      </tr>

   </table>
   </div>

</c:forEach>





</div>
</body>
</html>