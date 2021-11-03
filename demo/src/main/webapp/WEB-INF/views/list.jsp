<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="container">
	<h2>글 목록(${count })</h2>
	<div class="form-group text-right">
		<button type="button" class="btn btn-secondary mb-2" id="btnWrite"
			onclick="location.href='insert'">글쓰기</button>
	</div>

	<table class="table table=hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists }" var="board">
				<tr>
					<td>${board.num }</td>
					<td><a href="view/${board.num }">${board.title }(${board.replycnt })</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${board.hitcount }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="d-flex justify-content-between mt-5">
		

		<!-- 검색 -->
		<form class="form-inline" action="/myapp06/list" id="searchFrm">
			<select class="form-control mb-2 mr-sm-2" id="field" name="field">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select> <input class="form-control  mb-2 mr-sm-2" type="text"
				placeholder="Enter Search" id="word" name="word">
			<button class="btn btn-primary mb-2" type="submit">Search</button>
		</form>
	</div>
</div>
