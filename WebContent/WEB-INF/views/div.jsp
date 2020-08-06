<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido{
	border : 1px solid red;
	width : 40px;
	font-size : 9px;
	float:left;
	text-align:center;
	margin-left:2px;
	margin-top:2px;
	cursor:pointer;
}
div.selected{
	background-color:yellow
}
div.sido:hover{
	background-color:hotpink
}
div.gugun{
	border : 1px solid blue;
	width : 40px;
	font-size : 9px;
	float:left;
	text-align:center;
	margin-left:2px;
	margin-top:2px;
}
</style>
</head>
<body>
<div class="sido 
<c:if test="${param.sido==null}">
selected
</c:if>
">전체</div>
<c:forEach items="${sidoList}" var="sido">
	<div class="sido
	<c:if test="${param.sido==sido}">
	selected
	</c:if>
	" onclick="clickSido(this)" data-value="${sido}">${fn:substring(sido,0,2)}</div>
</c:forEach>
<br>
<div>
	<c:forEach items="${gugunList}" var="gugun">
		<div class="gugun" onclick="clickSido(this)" data-value="${gugun}">${fn:substring(gugun,0,2)}</div>
	</c:forEach>
</div>
dong : ${dongList}<br>
<script>
function clickSido(sidoObj){
	var sido = sidoObj.getAttribute('data-value');
	location.href='/test?sido=' + sido;
	
	var obj = document.querySelector('div.selected[name]')
}
</script>
</body>
</html>