<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<form action="/myapp07/login" method="post">
<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> --%>
ID : <input type="text" name="username"/><br/>
PWD : <input type="password" name="password"/><br/>
<input type="submit" value="로그인전송">
</form>

<%@ include file="includes/footer.jsp" %>