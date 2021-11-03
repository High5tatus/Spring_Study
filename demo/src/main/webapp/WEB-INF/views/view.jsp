<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<h2>글 내용</h2>
	<input type="hidden" id="num" value="${board.num }" />

	<form action="update" method="post">
		<table class="table table-hover">
			<tr>
				<th>글번호</th>
				<td>${board.num }</td>
				<th>조회수</th>
				<td>${board.hitcount }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer }</td>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.regdate }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td colspan="3">${board.title }</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td colspan="3">${board.content }</td>
			</tr>
		</table>
	</form>
	<br />
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-secondary" id="btnDelete">삭제</button>
		</div>	
	<div class="container mt-5">
		<div class="form-group">
			<label for="comment">Comment:</label>
			<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
		</div>
		<button type="button" class="btn btn-success" id="commentBtn">Comment
			Write</button>
	</div>
	<div id="replyResult"></div>

</div>

<script>
var init=function(){
	$.ajax({
		type:"get",
		url:"/reply/commentList",
		data:{"bnum" : $("#num").val()}
		})
		.done(function(resp){
			//alert(resp.length)
			var str="<table class='table table-hover mt-3'>";
			$.each(resp, function(key, val){
				str+="<tr>"
				str+="<td>"+ val.userid + "</td>"
				str+="<td>"+ val.content + "</td>"
				str+="<td>"+ val.regdate + "</td>"
				str+="<td><a href='javascript:fdel("+val.cnum+")'>삭제 </a></td>"	
				str+="</tr>"
			})
			str+="</table>"
			$("#replyResult").html(str);
			
		})
}
//댓글삭제
function fdel(cnum){
	$.ajax({
		type:"delete",
		url:"/reply/del/" + cnum		
	})
	.done(function(resp){
		alert(resp+"번 글 삭제완료");
		init();
	})
	.fail(function(){
		alert("댓글삭제 실패");
	})
}


//댓굴추가
	$("#commentBtn").click(function() {
		if($("#msg").val()==""){
			alert("댓글을 입력하세요")
			return;
		}
		data = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val()
		}
		$.ajax({
			type : "post",
			url : "/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		}).done(function(resp) {
			alert("댓글 추가 성공");
			$("#msg").val("");
			init();
		}).fail(function() {
			alert("댓글 추가 실패")
		})
	})

	$("#btnUpdate").click(function() {
		if (confirm('정말 수정할까요?')) {
			location.href = "/update/${board.num}"
		}
	})
	$("#btnDelete").click(function() {
		if (!confirm('정말 삭제할까요?'))
			return false;
		$.ajax({
			type : "delete",
			url : "/delete/${board.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("삭제성공")
					location.href = "/list"
				}
			}
		})
	})
init();
</script>

