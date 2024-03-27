<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Test Main Page</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/reset.css" />
	<link rel="stylesheet" href="./css/css.css" />
</head>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>SQL응용 평가</h1>
		</header>
		<table class="table table-bordered">
			<tr>
				<td>게시판으로 이동하려면 클릭하세요.</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-primary" onclick="location.href='BoardListCtrl.do'">게시판</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>