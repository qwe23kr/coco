<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("str","abcdeFG");
String str = (String) request.getAttribute("str");
str = str.substring(0,2);
out.println(str);
%>
${fn:substring(str,0,2)}
</body>
</html>




