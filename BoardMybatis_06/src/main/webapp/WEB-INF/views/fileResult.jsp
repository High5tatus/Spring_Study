<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${uploadFileName }" var="file">
		uploadFileName : ${file }<br />
	</c:forEach>
	<hr />
	<c:forEach items="${imgUpload }" var="imgfile">
		<img src="/myapp06/resources/img/${imgfile }" width=200 height=200 /><br/>
	</c:forEach>
</body>
</html>