<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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

	String myid=(String)session.getAttribute("myid");
	
	//업로드에 필요한 변수선언
	//업로드할 경로(톰캣에 올라가는 프로젝트경로)
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	//업로드사이즈
	int uploadSize=1024*1024*3; //3mb
	
	MultipartRequest multi=null;
	
	//생성자파라메터(request, 업로드폴더, 업로드사이즈,한글,같은이름일경우 1,2,3)
	try{
	multi=new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
	
	//입력값 읽기
	String content=multi.getParameter("content");
	//실제 업로드 이미지이름 읽어오기
	String photoname=multi.getFilesystemName("photo");

	//받은값들 dto에 저장하기
	GuestDto dto=new GuestDto();
	dto.setMyid(myid);
	dto.setContent(content);
	dto.setPhotoname(photoname);
	
	GuestDao dao=new GuestDao();
	dao.insertGuest(dto);
	
	//목록이동 
	response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp");
	
	} catch (Exception e){
		e.printStackTrace();
	}

	

%>
</body>
</html>