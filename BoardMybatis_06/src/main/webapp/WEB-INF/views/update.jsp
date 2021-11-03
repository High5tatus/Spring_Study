<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<div class="container">
	<h2>"${board.title }" 글 수정</h2>
	<div class="form-group">
		<label for="num">글 번호:</label> <input type="text" class="form-control"
			id="num" name="num" value="${board.num }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="${board.title }">
	</div>
	<div class="form-group">
		<label for="writer">작성자:</label> <input type="text"
			class="form-control" id="writer" name="writer"
			value="${board.writer }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" rows="5" id="content" name="content">${board.content }</textarea>
	</div>
	<div class="form-group text-right">
		<button type="button" class="btn btn-secondary btn-sm" id="btnModify">수정하기</button>
	</div>

</div>
<script>
	$("#btnModify").click(function() {
		data = {
			"num" : $("#num").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val()
		}
		$.ajax({
			type : "put",
			url : "/myapp06/update",
			contentType : "application/json;charset=utf-8",
			data:JSON.stringify(data),
			success : function(resp) {
				if(resp=="success"){
					alert("수정 성공");
					location.href="/myapp06/list"
				}
				
			},
			error : function(e) {
				alert("error : " + e)
			}
		})
	})
</script>

<%@ include file="includes/footer.jsp"%>