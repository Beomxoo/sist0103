<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Single+Day&family=Stylish&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<style type="text/css">
	img.photo{
	width: 200px;
	height: 230px;
	border: 1px solid gray;
	margin-bottom: 10px;
	}
	.shoptable{
		padding: 10px;
		height: 150px;
	}
</style>
<%
	ShopDao dao=new ShopDao();
	List<ShopDto> list=dao.getAllSangpums();
	NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
<div class="container mt-3">
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="tab" href="#tabs-total">전체</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-outer">아우터</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-top">상의</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-pants">하의</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-set">세트</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-ac">악세서리</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="tabs-total" class="container tab-pane active"><br>
      <h3>전체</h3>
      <p>
      <table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			int i=0;
      		for(ShopDto dto:list)
      		{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      		}
      		%>
      	</tr>
      </table>
    </p>
    </div>
    <div id="tabs-outer" class="container tab-pane fade"><br>
      <h3>아우터</h3>
      <p><table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			i=0;
      		for(ShopDto dto:list)
      		{
      			if(dto.getCategory().equals("아우터"))
      			{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      			}
      		}
      		%>
      	</tr>
      </table></p>
    </div>
    <div id="tabs-top" class="container tab-pane fade"><br>
      <h3>상의</h3>
      <p><table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			i=0;
      		for(ShopDto dto:list)
      		{
      			if(dto.getCategory().equals("상의"))
      			{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      			}
      		}
      		%>
      	</tr>
      </table></p>
    </div>
    <div id="tabs-pants" class="container tab-pane fade"><br>
      <h3>하의</h3>
      <p><table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			i=0;
      		for(ShopDto dto:list)
      		{
      			if(dto.getCategory().equals("하의"))
      			{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      			}
      		}
      		%>
      	</tr>
      </table></p>
    </div>
    <div id="tabs-set" class="container tab-pane fade"><br>
      <h3>세트</h3>
      <p><table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			i=0;
      		for(ShopDto dto:list)
      		{
      			if(dto.getCategory().equals("세트"))
      			{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      			}
      		}
      		%>
      	</tr>
      </table></p>
    </div>
    <div id="tabs-ac" class="container tab-pane fade"><br>
      <h3>악세서리</h3>
      <p><table class="shoptable table table-bordered" style="width: 50px;">
      	<tr>
      		<%
      			i=0;
      		for(ShopDto dto:list)
      		{
      			if(dto.getCategory().equals("악세서리"))
      			{
      			//20~50까지 난수발생
      			int sale=(int)(Math.random()*31)+20;
      			%>
      			<td>
      				<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="goDetail">
      				<img alt="" src="shopsave/<%=dto.getPhoto() %>" class="photo">
      				<br>
      				<%=dto.getSangpum() %><br>
      				<b style="color: red;"><%=sale %>%</b>
      				<span style="float: right;">
      					<div style="color: gray; font-size: 12px;">
      						<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      						%>
      						<strike><%=nf.format(dto.getPrice()) %></strike>
      					</div>
      					<div>
      						<%=nf.format(price) %>
      					</div>
      				</span>
      				</a>
      			</td>
      			
      		<%
      			if((i+1)%6==0)
      			{%>
      				</tr><tr>
      			<%}
      			i++;
      			}
      		}
      		%>
      	</tr>
      </table></p>
    </div>
  </div>
</div>

</body>
</html>