<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>List(${count })</h3>
<c:forEach items="${list }" var="ps">
이름:<a href="view?id=${ps.id }">${ps.name }</a><br/>
아이디:${ps.id }<br/>
성별:${ps.gender }<br/>
직업:${ps.job }<hr/>
</c:forEach>

</body>
</html>