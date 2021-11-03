<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	loadData();
	$("#btnSearch").click(function(){
		loadData($("#field").val(),$("#word").val());
	})//btnSearch click	
	
	$("#submit").click(function() {
		var postString = {
			"name" : $("#name").val(),
			"content" : $("#content").val(),
			"grade" : $("input:radio[name=grade]:checked").val()
		}
		$.ajax({
			type : "POST",
			url : "gInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(postString),
			success : function(resp) {
				alert(resp);
				loadData();
			},
			error : function(e) {
				alert("error : " + e)
			},
			beforeSend : showRequest
		//위에 명령을 실행하기 전에 먼저 실행
		})//ajax
	})//submit
})//document
function showRequest() {
	//이름
	if (!$("#name").val()) {
		alert("이름을 입력하세요");
		$("#name").focus();
		return false;
	}
	//내용
	if (!$("#content").val()) {
		alert("내용을 입력하세요");
		$("#content").focus();
		return false;
	}
	//평가
	if ($("input:radio[name=grade]:checked").length == 0) {
		alert("평가하세요");
		return false;
	}
	return true;
}
function loadData(field, word) {
	$.ajax({
		type : "get",
		url : "gList",
		data : {"field" : field, "word" : word},
		success : function(resp) {
			var str = "";
			$("#cntDiv").html("개수 : " + resp.count)
			$.each(resp.list, function(key, val) {
				str +="<a href='javascript:fview("+ val.num + ")'> "+ val.name + "</a> "
				str += val.content + " "
				str += val.grade + " "
				str += "<a href='javascript:fdelete("+val.num+")'>삭제</a><br>"
			})
			$("#result").html(str);
		}
	})
}
//삭제
function fdelete(num){
	$.ajax({
		type:"DELETE",
		url: "gDelete/" + num,
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공");
				loadData();
			}
		},
		error:function(e){
			alert("삭제 실패 : " +e );
		}			
	})		
}
//상세보기
function fview(num){
	$.getJSON("gView",{"num" : num }, function(resp){
		var str="";
		str +="이름 : " +resp.name + "<br/>"
		str +="내용 : " +resp.content + "<br/>"
		str +="평가 : " +resp.grade + "<br/>"
		str +="작성일 : " +resp.created + "<br/>"
		$("#views").html(str);
	})
}
</script>
</head>
<body>
	<form action="">
		<table>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" id="content" size="80"></td>
			</tr>
			<tr>
				<th>평가</th>
				<td><input type='radio' name='grade' value='excellent'
					id='excellent' checked="checked" /><label for="excellent">아주잘함(excellent)</label>
					<input type='radio' name='grade' value='good' id='good' /><label
					for="good">잘함(good)</label> <input type='radio' name='grade'
					value='normal' id='normal' /><label for="normal">보통(normal)</label>
					<input type='radio' name='grade' value='fail' id='fail' /><label
					for="fail">노력(fail)</label></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="입력" id="submit">
				</td>
			</tr>
		</table>
	</form>
	<br/>
	<div align="right">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="button" value="찾기" id="btnSearch">
	</div>
	
	<hr/>
	<div id="cntDiv"></div>
	<div id="result"></div>
	<hr/>
	<div id="views"></div>
</body>
</html>