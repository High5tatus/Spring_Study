<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">
<h3>JOIN</h3>
	<div class="form-group">
		<label for="username">아이디:</label> <input type="text"
			class="form-control" id="username" placeholder="Enter Username"
			name="username">
	</div>
	<div class="form-group">
		<label for="password">비밀번호:</label> <input type="password"
			class="form-control" id="password" placeholder="Enter Password"
			name="password">
	</div>
	<div class="form-group">
		<label for="email">이메일:</label> <input type="text"
			class="form-control" id="email" placeholder="Enter Email"
			name="email">
	</div>
	<button class="btn btn-primary btn-sm" id="btnJoin">회원가입</button>
</div>
<script>
	$("#btnJoin").click(function() {
		if ($("#username").val() == "") {
			alert("아이디를 입력하세요")
			$("#username").focus()
			return false;
		}
		if ($("#password").val() == "") {
			alert("비밀번호를 입력하세요")
			$("#password").focus()
			return false;
		}
		if ($("#email").val() == "") {
			alert("이메일을 입력하세요")
			$("#email").focus()
			return false;
		}
		var data = {
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()
		}
		$.ajax({
			type : "post",
			url : "/register",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		}).done(function(res) {
			if (res == "success") {
				alert("회원가입을 축하합니다.");
				location.href="/login"
			} else if (res == "fail") {
				alert("아이디를 중복확인하세요");
				$("#username").val("")
			}
		}).fail(function(e) {
			alert("회원가입실패");
		})
	})
</script>
</body>
</html>