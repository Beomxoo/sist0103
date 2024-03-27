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
<script type="text/javascript">
	$(function(){
		//아이디중복체크
		$("#btnIdCheck").click(function(){
				var id=$("#id").val();
				//alert(id);
				$.ajax({
					type:"get",
					dataType:"json",
					url:"member/idCheck.jsp",
					data: {"id": id},
					success:function(res){
						//alert(res.count);
						if(res.count==1){
							//alert("이미 가입된 아이디입니다.\n다시 입력해주세요.")
							$("span.idsuccess").text("not ok!!");
							$("#id").val("");
						} else{
							//alert("가입이 가능한 아이디입니다.");
							$("span.idsuccess").text("ok!!");
						}
					}
					
				}); 
		})
		$("#selemail").change(function(){
			if($(this).val()=="-"){
				$("#email2").val('');
			} else{
				$("#email2").val($(this).val());
			}
		});
		
	});
	
	function check(f) //f는 form을 의미
	{
		if(f.pass.value!=f.pass2.value){
			alert("비밀번호가 서로 다릅니다.");
			f.pass.value="";
			f.pass2.value="";
			return false; //action호출하지않는다. (넘어가지않게함)
		}
	}
</script>
</head>
<body>
<div style="margin: 100px 100px; width: 500px;">
<form action="member/addaction.jsp" method="post" onsubmit="return check(this)">
	<table class="table table-bordered" style="width: 500px;">
		<caption align="top"><b>회원정보수정</b></caption>
		<tr>
			<th width="100" class="table-danger">닉네임</th>
			<td>
				<div class="d-inline-flex">
				<input type="text" name="addr" class="form-control" required="required" style="width: 150px;">
				<button style="margin-left: 10px;" class="btn btn-danger" type="button">변경</button>
				</div>
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">아이디</th>
			<td>
				<div class="d-inline-flex">
				<input type="text" name="id" id="id" class="form-control" required="required" style="width: 120px;">
				<span class="idsuccess" style="color: blue; margin-left: 10px;"></span>
				</div>
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">비밀번호</th>
				<td>
				<div class="d-inline-flex">
					<input type="password" name="pass" class="form-control" required="required" style="width: 150px;" placeholder="변경할 비밀번호">
					<input type="password" name="pass2" class="form-control" required="required" style="width: 150px; margin-left: 5px;"placeholder="비밀번호 확인">
					<button type="button" class="btn btn-danger" id="btnIdCheck" style="margin-left: 10px;">변경</button>
				</div>
				</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">이름</th>
			<td>
				<input type="text" name="name" class="form-control" required="required" style="width: 120px;">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-danger">핸드폰</th>
			<td>
				<input type="text" name="hp" class="form-control" required="required" style="width: 180px;">
			</td>
		</tr>
		
		<tr>
			<th width="100" class="table-danger">이메일</th>
			<td>
			<div class="d-inline-flex">
				<input type="text" name="email1" class="form-control" required="required" style="width: 80px;">
				<b>@</b>
				<input type="text" name="email2" id="email2" class="form-control" required="required" style="width: 120px; margin-left: 10px;">
				<select id="selemail" class="form-control" style="margin-left: 10px;">
					<option value="-">직접입력</option>
					<option value="naver.com">네이버</option>
					<option value="nate.com">네이트</option>
					<option value="gmail.com">구글</option>
					<option value="daum.com">다음</option>
				</select>
			</div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-danger" style="width: 100px;">변경하기</button>
				<button type="reset" class="btn btn-outline-dark" style="width: 100px;">이전</button>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>