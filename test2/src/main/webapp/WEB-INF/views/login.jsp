<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<script src="../js/member.js"></script>
<form action="login" method="post">
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Login</h1>
	</div>
</div>
<div class="container">
    <div class="form-group">
      <label for="userid">UserID:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter UserID" name="username">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    
    <button type="submit" class="btn btn-primary" id="loginBtn">로그인</button>
    <button type="reset" class="btn btn-secondary">취소</button>
    <button type="button" class="btn btn-secondary" onclick="location.href='join'">회원가입</button>
</div>
<script>
/* $("#loginBtn").click(function(){
	if($("#userid").val()==""){
		alert("아이디를 입력하세요");
		$("#userid").focus();
		return false;
	}
	if($("#pwd").val()==""){
		alert("비밀번호를 입력하세요");
		$("#pwd").focus();
		return false;
	}
	$.ajax({
		type:"post",
		url:"login",
		data:{"userid" :$("#userid").val(), "pwd" : $("#pwd").val()},
		success:function(resp){//0일반회원 1관리자 -1비회원 2: 비밀번호오류
			//alert(resp);
			location.href="memberlist";
		},
		error:function(e){
			alert("error : " + e);
		}
	})
}) */

</script>

</form>
<%@ include file="include/footer.jsp"%>