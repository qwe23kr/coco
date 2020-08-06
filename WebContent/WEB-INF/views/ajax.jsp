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
<script>
//ajax
function getAjax(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax?sido=서울&gugun=강서구');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			var sidos = JSON.parse(xhr.responseText);
			var html = '';
			for(var i=0;i<sidos.length;i++){
				html += '<div class="sido">';
				html += sidos[i].substring(0,2);
				html += '</div>';
			}
			document.querySelector('#rDiv').innerHTML = html;
		}
	}
	xhr.send();
}
</script>
<button onclick="getAjax()">클릭미</button>
<div id="rDiv"></div>
</body>
</html>




