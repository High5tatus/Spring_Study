<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>개인 정보 입력</h3>
<form action="insert" method="post">
이름 : <input type="text" name="name"> <br>
아이디 : <input type="text" name="id"> <br>
패스워드 : <input type="password" name="password"> <br>
성별 :  <label for="man">남</label><input type='radio' name='gender' value='male' />
여  <input type='radio' name='gender' value='female' /> <br>
직업 : <select id="job" name="job" size="1">
			<option value="학생">학생</option>
			<option value="공무원">공무원</option>
			<option value="백수">백수</option>
			<option value="회사원">회사원</option>
		</select> <br><br>
<input type="submit" value="확인"><input type="reset" value="취소">
</form>
</body>
</html>