<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/reset.css" />
	<link rel="stylesheet" href="./css/css.css" />
</head>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>글 상세보기</h1>
		</header>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td>
					${v.title}
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					${v.nickname}
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					${v.content}
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
					${v.regdate}
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>
					${v.cnt }
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					${v.userid}
				</td>
			</tr>

			<tr>
				<td colspan="5">
					<button type="button" class="btn btn-primary" onclick="location.href='GetUpdateBoard.do?num=${v.seq}'">글수정</button>
					<button type="button" class="btn btn-primary" onclick="location.href='DeleteBoard.jsp?num=${v.seq}'">글삭제</button>
					<button type="button" class="btn btn-primary" onclick="location.href='BoardListCtrl.do'">글목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>