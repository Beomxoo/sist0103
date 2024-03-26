<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
	

	String content=multi.getParameter("content");
	String num=multi.getParameter("num");
	String currentPage=multi.getParameter("currentPage");
	String photoname=multi.getFilesystemName("photo");
	
	//기존포토명가져오기
	GuestDao dao=new GuestDao();
	String old_photoname=dao.getData(num).getPhotoname();

	//받은값들 dto에 저장하기
	GuestDto dto=new GuestDto();
	dto.setNum(num);
	dto.setContent(content);
	//사진선택을 안하면 
	dto.setPhotoname(photoname==null?old_photoname:photoname);
	
	dao.updateGuest(dto);
	
	//목록이동 (목록이동시 수정했던 페이지로 이동)
	response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp?currentPage="+currentPage);
	} catch (Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>