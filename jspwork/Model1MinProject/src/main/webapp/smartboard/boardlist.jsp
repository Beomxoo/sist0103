<%@page import="data.dto.SmartDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SmartDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>
</head>

<%
	//전체갯수
	SmartDao dao=new SmartDao();
	int totalCount=dao.getTotalCount();
	int perPage=3; //한페이지당 보여질 글의 갯수
	int perBlock=5; //한블럭당 보여질 페이지 갯수
	int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
	int startPage; //각블럭당 보여질 시작페이지
	int endPage; //각블럭당 보여질 끝페이지
	int currentPage;  //현재페이지
	int totalPage; //총페이지수
	int no; //각페이지당 출력할 시작번호
	
	//현재페이지 읽는데 단 null일경우는 1페이지로 준다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	
	//총페이지수 구한다
	//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
	//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
	//각블럭당 보여질 시작페이지
	//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
	//현재가 13일경우 시작:11 끝:15
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	
	//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
	if(endPage>totalPage)
		endPage=totalPage;
	
	//각페이지에서 보여질 시작번호
	//1페이지:0, 2페이지:5 3페이지: 10.....
	startNum=(currentPage-1)*perPage;
	
	//각페이지당 출력할 시작번호 구하기
	//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
	no=totalCount-(currentPage-1)*perPage;
	
	//페이지에서 보여질 글만 가져오기
	List<SmartDto>list=dao.getList(startNum, perPage);
	
	
	/*마지막 페이지의 단 한개 남은 글을 삭제시 빈페이지가 남는다 그러므로 해결책은 그이전페이지로 가면 된다  */
	if(list.size()==0 && currentPage!=1)
	{%>
		<script type="text/javascript">
		location.href="index.jsp?main=memberguest/guestlist.jsp?currentPge=<%=currentPage-1%>";
		</script>
	<%}
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
%>
<body>
<div style="margin: 50px 100px;">
	<h6><b>총 <%=totalCount %>개의 게시판 글이 있습니다</b></h6>
	
	<table  class="table table-bordered">
		<caption align="top"><b>스마트게시판 목록</b></caption>
		<tr align="center" class="table-light">
			<th width="80">번호</th>
			<th width="380">제목</th>
			<th width="200">작성자</th>
			<th width="200">작성일</th>
			<th width="80">조회</th>
		</tr>
	<%
	if(totalCount==0){%>
		<tr>
			<td colspan="5" align="center">
				<h6><b>등록된 게시글이 없습니다</b></h6>			
			</td>
		</tr>
	<%}else{
		for(SmartDto dto:list)
		{%>
			<tr align="center">
				<td>
				<input type="checkbox" value="<%=dto.getNum() %>" class="alldel">&nbsp;&nbsp;
				<%=no--%>
				</td>
				<td>
				<a href="index.jsp?main=smartboard/contentview.jsp?num=<%=dto.getNum() %>&currentPage=<%=currentPage %>">
				<span style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: 250px; display: block;">
				<%=dto.getSubject()%></span></a></td>
				<td><%=dto.getWriter() %></td>
				<td><%=sdf.format(dto.getWriteday()) %></td>
				<td><%=dto.getReadcount() %></td>
			</tr>
		<%}%>
		<tr>
			<td colspan="5">
				<input type="checkbox" value="alldelcheck">&nbsp;&nbsp;전체선택
				<span style="float: right;">
					<button type="button" class="btn btn-danger btn-sm" id="btndel"><i class="bi bi-x-circle"></i>삭제</button>
					<button type="button" class="btn btn-info btn-sm" onclick="location.href='index.jsp?main=smartboard/smartform.jsp'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
				</span>
			</td>
		</tr>
	<%}
	%>
	</table>
</div>


	



 <!-- 페이지 번호 출력 -->
  <div style="width: 580px; text-align: center; margin: 50px 100px;">
  
  <ul class="pagination justify-content-center">
  <%
  //이전
  if(startPage>1)
  {%>
	  <li class="page-item ">
	   <a class="page-link" href="index.jsp?main=smartboard/boardlist.jsp?currentPage=<%=startPage-1%>" style="color: black;">이전</a>
	  </li>
  <%}
    for(int pp=startPage;pp<=endPage;pp++)
    {
    	if(pp==currentPage)
    	{%>
    		<li class="page-item active">
    		<a class="page-link" href="index.jsp?main=smartboard/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
    		</li>
    	<%}else
    	{%>
    		<li class="page-item">
    		<a class="page-link" href="index.jsp?main=smartboard/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
    		</li>
    	<%}
    }
    
    //다음
    if(endPage<totalPage)
    {%>
    	<li class="page-item">
    		<a  class="page-link" href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=endPage+1%>"
    		style="color: black;">다음</a>
    	</li>
    <%}
  %>
  
  </ul>
</div>
</body>
</html>