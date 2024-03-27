<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>전체게시판</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/reset.css" />
	<link rel="stylesheet" href="./css/css.css" />
</head>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>전체 게시판</h1>
		</header>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
<c:forEach var="b" items="${boardList}">
			<tr>
				<td>${b.seq}</td>
				<td><a href="BoardInfo.do?num=${b.seq}">${b.title}</a></td>
				<td>${b.nickname}</td>
				<td>${b.regdate }</td>
				<td>${b.cnt }</td>
			</tr>
</c:forEach>	
			<tr>
				<td colspan="5">
					<button type="button" class="btn btn-primary" onclick="location.href='WriteForm.jsp'">글등록</button>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>