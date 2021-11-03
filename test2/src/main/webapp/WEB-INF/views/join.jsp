<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<script src="../js/member.js"></script>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Join</h1>
	</div>
</div>
<div class="container">
	<form action="join" method="post" id="frm">
		<div class="row">
			<div class="col">
				<label for="username">UserID:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter UserID" readonly="readonly"
					name="username" >
			</div>
			<div class="col align-self-end">
				<button type="button" class="btn btn-secondary" id="btnIdCheck">중복확인</button>
			</div>
		</div>
		<div class="form-group">
			<label for="userpw">Password:</label> <input type="password"
				class="form-control" id="userpw" placeholder="Enter password"
				name="userpw">
		</div>
		<div class="form-group">
			<label for="pass_check">Password Check:</label> <input type="password"
				class="form-control" id="pass_check"
				placeholder="Enter password_check" name="pass_check">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="text"
				class="form-control" id="email" placeholder="Enter email"
				name="email">
		</div>
		<div class="form-check-inline">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="admin" checked value=0>일반회원
			</label>
		</div>
		<div class="form-check-inline">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="admin" value=1>관리자
			</label>
		</div>
		<br /> <br />
		<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
	</form>
</div>
<%@ include file="include/footer.jsp"%>