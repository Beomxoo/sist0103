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
<style type="text/css">
#passsearchbtn{
   background-color: #618E6E;
      color: white;
      border-radius: 5px;
      border:0px;
      height: 50px;
      margin-top: 40px;
}
table th{
   padding-top: 20px;
   font-size: 0.9em;
}
</style>
</head>
<body>
<div style="width: 500px;  margin: 0 auto; margin-top: 100px; border: 1px solid #ccc; border-radius: 10px;"
id="passsearch">
<h3 style="margin-top:50px; width: 500px; padding-left: 150px">비밀번호 찾기</h3>
   <form style="margin:50px;" action="#" method="post" id="passfrm" >

      <table style="margin: 0 auto;">
         <tr>
            <th>아이디</th>
         </tr>
         <tr>
            <td>
               <input type="text" name="id" id="id" placeholder="아이디를 입력해 주세요."
               style="width: 250px;height: 40px;">
            </td>
         </tr>
         <tr>
            <th>이름</th>
         </tr>
         <tr>
            <td>
               <input type="text" name="name" id="name" placeholder="이름을 입력해 주세요."
               style="width: 250px;height: 40px;">
            </td>
         </tr>
         <tr>
            <th>핸드폰 번호</th>
         </tr>
         <tr>
            <td>
               <input type="text" name="hp2" id="hp2" placeholder="핸드폰 번호를 입력해 주세요."
               style="width: 250px;height: 40px;">
            </td>
         </tr>
         
      </table>
      <div align="center">
         <button type="button" id="passsearchbtn"style="width: 250px;height: 40px;">비밀번호 찾기</button><br>
      </div>
   </form>
</div>
</body>
</html>