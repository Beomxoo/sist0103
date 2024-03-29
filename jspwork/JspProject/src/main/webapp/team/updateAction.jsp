<%@page import="team.model.TeamDao"%>
<%@page import="team.model.TeamDto"%>
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
      
   	 String num=request.getParameter("num");
  	 String name=request.getParameter("name");
  	 String driver=request.getParameter("driver");
  	 String addr=request.getParameter("addr");
      
      //System.out.println(driver); 체크안하면 null,체크하면 on   
      
      //dto선언
      TeamDto dto=new TeamDto();
   	
      dto.setNum(num);
      dto.setName(name);
      dto.setDriver(driver==null?"없음":"있음");
      dto.setAddr(addr);
      
      //dao선언..메서드 불러오기 위함
      TeamDao dao=new TeamDao();
      //insert메서드 호출
      dao.updateTeam(dto);
      
      //목록파일로이동
      response.sendRedirect("teamList.jsp");
   
   %>  

</body>
</html>