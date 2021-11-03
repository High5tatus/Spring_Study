<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h3>
		list/<a href="/join">insert</a>
	</h3>


	<div id="memberDiv">
		<c:forEach items="${lists.content }" var="member">				
					번호 : ${member.id }<br />
					이름 : ${member.name }<br />
					주소 : ${member.addr }<br />
					이메일 : ${member.email }<br />
					<a href="detail/${member.id }">상세보기</a>
			<button type=button onclick="funDelete(${member.id })">삭제</button>
			<button type=button class="btnDel" data-mid="${member.id }">삭제
				class</button>
			<br />
			<br />

		</c:forEach>
	</div>
<a href="?page=${lists.number-1 }">이전</a>
<a href="?page=${lists.number+1 }">다음</a>
<c:choose>
	<c:when test="${lists.first }">
		[First]
		<a href="?page=${lists.number+1 }">다음</a>
	</c:when>
	<c:when test="${lists.last }">
		<a href="?page=${lists.number-1 }">이전</a>
		[Last]
	</c:when>
</c:choose>




<script>
function funDelete(id){
	$.ajax({
		type:"delete",
		url:"delete/"+id
	})
	.done(function(resp){
		alert(resp+"회원 삭제 완료");
		location.href="/list"
	})
	.fail(function(){
		alert("회원 삭제 실패")
	})
}
var delfun = function(){
	$.ajax({
		type:"delete",
		url:"delete/"+ $(this).data("mid")
	})
	.done(function(resp){
		alert(resp+"회원 삭제 완료");
		location.href="/list"
	})
	.fail(function(){
		alert("회원 삭제 실패")
	})
}
$("#memberDiv").on("click", ".btnDel", delfun);

/* $("#memberDiv").on("click", ".btnDel",function(){
	alert($(this).attr("data-mid"));
	alert($(this).data("mid")); 
	$.ajax({
		type:"delete",
		url:"delete/"+id
	})
	.done(function(resp){
		alert(resp+"회원 삭제 완료");
		location.href="/list"
	})
	.fail(function(){
		alert("회원 삭제 실패")
	})
	
}) */
</script>
</body>
</html>