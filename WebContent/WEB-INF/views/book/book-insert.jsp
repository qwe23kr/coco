<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책정보입력</title>
</head>
<body>
	<form method="post" action="/book/insert">
		<table border="1">
			<tr>
				<th>책제목</th>
				<td><input type="text" name="b_title"></td>
			</tr>
			<tr>
				<th>집필자</th>
				<td><input type="text" name="b_author"></td>
			</tr>

			<tr>
				<th>출판일</th>
				<td><input type="date" name="b_credat"></td>
			</tr>
			<tr>
				<th>리뷰</th>
				<td><input type="text" name="b_desc"></td>
			</tr>
			<tr>
				<th colspan="2"><button>책정보입력</button></th>
		</tr>
		</table>
	</form>
</body>
</html>