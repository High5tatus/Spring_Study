<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="container">
	<h2>로그인</h2>
	<form action="/myapp/login" method="post">
		<div class="row">
			<div class="col">
				<label for="username">아이디:</label> <input type="text" class="form-control"
					id="username" placeholder="Enter id" name="username">
			</div>
			
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter Password" name="password">
		</div>
		<button type="submit" class="btn btn-primary btn-sm" id="btnLogin">로그인</button>
	</form>
</div>
<script>
/* $("#btnLogin").click(function(){
	$.ajax({
		type:"post",
		url:"/myapp/member/login",
		data:{"userid":$("#id").val(), "userpw":$("#pass").val()}
	})
	.done(function(resp){
		if(resp=="no"){
			alert("회원이 아닙니다. 회원가입하세요")
			location.href="join"
		}else if(resp=="success"){
			alert("로그인 성공")
			location.href="/myapp/"
		}else{
			alert("비밀번호를 확인하세요");
		}
	})
}) */


</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>

