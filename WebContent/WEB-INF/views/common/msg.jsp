<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:100%;height:100%;text-align:center">
	${rMap.msg}<br>
	<button onclick="goPage()">확인</button>
</div>
<script>
function goPage(){
	location.href='${rMap.url}';
}
</script>
</body>
</html>