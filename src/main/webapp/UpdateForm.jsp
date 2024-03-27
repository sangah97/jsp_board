<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/reset.css" />
	<link rel="stylesheet" href="./css/css.css" />
</head>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>글 수정하기</h1>
		</header>
		<form action="UpdateBoard.do" method="post">
			<table class="table table-bordered">
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" class="form-control" value="${v.title }">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						${v.nickname }
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="10" cols="30">${v.content}</textarea>
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
						${v.userid }
					</td>
				</tr>

				<tr>
					<td colspan="5">
						<input type="hidden" name="num" value="${v.seq}"/>
						<input type="submit" value="글수정" class="btn btn-primary">
						<input type="reset" value="취소" class="btn btn-secondary" onclick="location.href='BoardListCtrl.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>