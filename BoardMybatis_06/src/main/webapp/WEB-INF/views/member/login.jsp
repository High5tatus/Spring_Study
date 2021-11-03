<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<script src="/myapp06/resources/js/member.js"></script>
<div class="container">
	<h2>로그인</h2>
	<form action="/myapp06/member/join" method="post">
		<div class="row">
			<div class="col">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" placeholder="Enter id" name="id">
			</div>
			
		</div>
		<div class="form-group">
			<label for="pass">비밀번호:</label> <input type="password"
				class="form-control" id="pass" placeholder="Enter Password" name="pass">
		</div>
		<button type="button" class="btn btn-primary btn-sm" id="btnLogin">로그인</button>
	</form>
</div>
<script>
$("#btnLogin").click(function(){
	$.ajax({
		type:"post",
		url:"/myapp06/member/login",
		data:{"id":$("#id").val(), "pass":$("#pass").val()}
	})
	.done(function(resp){
		if(resp=="no"){
			alert("회원이 아닙니다. 회원가입하세요")
			location.href="join"
		}else if(resp=="success"){
			alert("로그인 성공")
			location.href="/myapp06/"
		}else{
			alert("비밀번호를 확인하세요");
		}
	})
})


</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>

