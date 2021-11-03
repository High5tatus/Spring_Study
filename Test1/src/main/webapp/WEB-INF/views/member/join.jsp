<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<script src="/myapp/resources/js/member.js"></script>
<div class="container">
	<h2>회원가입</h2>
	<form action="/myapp/member/join" method="post">
		<div class="row">
			<div class="col">
				<label for="userid">아이디:</label> <input type="text" class="form-control" id="userid" placeholder="Enter id" name="userid" readonly="readonly">
			</div>
			<div class="col align-self-end">
				<button type="button" class="btn btn-secondary" id="btnIdCheck">중복확인</button>
			</div>
		</div>
		<div class="form-group">
			<label for="userpw">비밀번호:</label> <input type="password" 	class="form-control" id="userpw" placeholder="Enter Password"
				name="userpw">
		</div>
		<div class="form-group">
			<label for="pass_check">비밀번호확인:</label> <input type="password"
				class="form-control" id="pass_check"
				placeholder="Enter Password_check" name="pass_check">
		</div>
		<div class="form-group">
			<label for="username">이름:</label> <input type="text" class="form-control"
				id="username" placeholder="Enter name" name="username">
		</div>

		<button type="button" class="btn btn-primary btn-sm" id="btnJoin">회원가입</button>
	</form>
</div>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>