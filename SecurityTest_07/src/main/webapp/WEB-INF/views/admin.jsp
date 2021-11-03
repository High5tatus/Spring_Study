<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
</head>
<body>
<h3>Admin</h3>
<p>principal : <sec:authentication property="principal"/></p>
<p>Member : <sec:authentication property="principal.member"/></p> 
<p>사용자이름 : <sec:authentication property="principal.member.username"/></p> 
<p>사용자ID : <sec:authentication property="principal.member.userid"/></p> 
<p>사용자ID : <sec:authentication property="principal.username"/></p>
<p>권한 : <sec:authentication property="principal.member.authList"/></p>  
<!-- <a href="customLogout">로그아웃</a> -->
<a href="/myapp07/board/insert">게시글 쓰기</a>
</body>
</html>