<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h3>수정하기</h3>
	<form action="update" method="post">
		이름 : <input type="text" name="name" value=${person.name }> <br>
		아이디 : <input type="text" name="id" value=${person.id }	readonly="readonly"> <br> 
		패스워드 : <input type="password"	name="password"> <br> 
		성별 : <label for="male">남</label> <input	type='radio' name='gender' id="male" value='male' /> 
		<label for="female">여</label> <input type='radio'id="female" name='gender' value='female' /> <br> 
		직업 : <select id="job" name="job" size="1">
			<option value="학생">학생</option>
			<option value="공무원">공무원</option>
			<option value="백수">백수</option>
			<option value="회사원">회사원</option>
		</select>
<script>
//성별
if("${person.gender}"=="male"){
	$("input:radio[value='male']").prop("checked",true);
}else{
	$("input:radio[value='female']").prop("checked",true);
}
//직업
$("#job option").each(function(){
	if($(this).val()=="${person.job}"){
		$(this).prop("selected",true);
	}
})
</script>
		<br><br> 
		<input type="submit" value="수정하기"> 
		<input type="reset" value="취소">
	</form>
</body>
</html>