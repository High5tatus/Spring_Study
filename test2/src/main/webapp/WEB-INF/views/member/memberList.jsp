<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<script src="../js/member.js"></script>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Member List</h1>
	</div>
</div>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>구분</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members }" var="member">
				<tr>
					<td>${member.id }</td>
					<td>${member.username }</td>
					<c:if test="${member.admin=='role_user'}">
						<td>일반회원</td>
						<sec:authorize access="isAnonymous()">
						<td></td>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
						<td><button class="btn btn-secondary" onclick="btnDelete(${member.id })">삭제</button></td>
						</sec:authorize>
					</c:if>
					<c:if test="${member.admin=='role_admin'}">
						<td colspan="2">관리자</td>	
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>

function btnDelete(id){
	if (!confirm('정말 삭제할까요?'))
		return false;
	$.ajax({
		type:"delete",
		url:"delete/"+id
	})
	.done(function(resp){
		alert(resp+"번 회원 삭제 완료");
		location.href="/list"
	})
	.fail(function(){
		alert("회원 삭제 실패")
	})
}
var d

</script>
<%@ include file="../include/footer.jsp"%>