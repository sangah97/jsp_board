<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글삭제 확인</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/reset.css" />
	<link rel="stylesheet" href="./css/css.css" />
</head>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>삭제하시겠습니까?</h1>
		</header>
		<form action="DeleteBoard.do" method="post">
			<table class="table table-bordered">
				<tr>
					<td>
						<input type="hidden" name="num" value="<%=request.getParameter("num") %>" />
						<input type="submit" value="네" class="btn btn-primary" onclick="location.href='DeleteBoard.do'">
						<input type="reset" value="아니오" class="btn btn-secondary" onclick="location.href='BoardListCtrl.do'">
					</td>
				</tr>
			</table>
		</form>
		</div>
</body>
</html>