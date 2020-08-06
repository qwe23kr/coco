<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function(){
	var obj = document.querySelector('div div.test');
	obj.innerText='다다';
}
</script>
</head>
<body>
	<div class="test" onclick="test()">나나1</div>

<div>
	<div class="test" onclick="test()">나나2</div>
</div>
</body>
</html>